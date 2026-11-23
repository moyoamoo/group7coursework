package com.napier.sem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql*;
import.util.list;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PopulationReportConnectionUnitTest {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metadata;
    private PopulationReportConnection reportConnection;


    @BeforeEach
    void setUp() throws SQLException {
        connection = mock(Connection.class);
        statement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
        metadata = mock(ResultSetMetaData.class);

        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.getMetaData()).thenReturn(metadata);

        reportConnection = new PopulationReportConnection(connection);
    }


    private void columns(String... labels) throws SQLException {
        when(metadata.getColumnCount()).thenReturn(labels.length);
        for (int i = 0; i < labels.length; i++) {
            when(metadata.getColumnLabel(i + 1)).thenReturn(labels[i]);
        }
    }

    @Test
    void run_nullConnection_returnsEmptyList() {
        PopulationReportConnection c = new PopulationReportConnection(null);
        assertTrue(c.run("SELECT 1").isEmpty());
    }


    @Test
    void run_nullSql_returnsEmptyList() throws SQLException {
        assertTrue(reportConnection.run(null).isEmpty());
        verify(connection, never()).prepareStatement(anyString());
    }

    @Test
    void run_blankSql_returnsEmptyList() throws SQLException {
        assertTrue(reportConnection.run("   ").isEmpty());
        verify(connection, never()).prepareStatement(anyString());
    }

    @Test
    void run_emptyResultSet_returnsEmptyList() throws SQLException {
        columns("AreaName", "TotalPopulation");
        when(resultSet.next()).thenReturn(false);

        assertTrue(reportConnection.run("SELECT x").isEmpty());
    }


    @Test
    void run_withoutCityPopulation_mapsNameAndTotal() throws SQLException {
        columns("AreaName", "TotalPopulation");
        when(resultSet.next()).thenReturn(true, true, false);
        when(resultSet.getString("AreaName")).thenReturn("France", "Spain");
        when(resultSet.getLong("TotalPopulation")).thenReturn(60_000_000L, 40_000_000L);

        List<PopulationReport> reports = reportConnection.run("SELECT x");

        assertEquals(2, reports.size());
        assertEquals("France", reports.get(0).getName());
        assertEquals(60_000_000L, reports.get(0).getTotalPopulation());
        assertEquals("Spain", reports.get(1).getName());
        verify(resultSet, never()).getLong("CityPopulation");
    }

    @Test
    void run_withCityPopulation_mapsAllThreeFields() throws SQLException {
        columns("AreaName", "TotalPopulation", "CityPopulation");
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getString("AreaName")).thenReturn("Asia");
        when(resultSet.getLong("TotalPopulation")).thenReturn(4_000L);
        when(resultSet.getLong("CityPopulation")).thenReturn(1_500L);

        List<PopulationReport> reports = reportConnection.run("SELECT x");

        assertEquals(1, reports.size());
        assertEquals(1_500L, reports.get(0).getCityPopulation());
    }

    @Test
    void run_cityPopulationLabelIsCaseInsensitive() throws SQLException {
        columns("AreaName", "TotalPopulation", "CITYPOPULATION");
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getString("AreaName")).thenReturn("Europe");
        when(resultSet.getLong("TotalPopulation")).thenReturn(10L);
        when(resultSet.getLong("CityPopulation")).thenReturn(4L);

        List<PopulationReport> reports = reportConnection.run("SELECT x");

        assertEquals(4L, reports.get(0).getCityPopulation());
    }

    // Query parameters are bound to the statement in order, using 1-based JDBC indexes.
    @Test
    void run_bindsParametersInOrderStartingAtOne() throws SQLException {
        columns("AreaName", "TotalPopulation");
        when(resultSet.next()).thenReturn(false);

        reportConnection.run("SELECT x WHERE a = ? AND b = ?", "Asia", 5);

        verify(statement).setObject(1, "Asia");
        verify(statement).setObject(2, 5);
    }


    @Test
    void run_noParams_doesNotBindAnything() throws SQLException {
        columns("AreaName", "TotalPopulation");
        when(resultSet.next()).thenReturn(false);

        reportConnection.run("SELECT x");

        verify(statement, never()).setObject(anyInt(), any());
    }

    // Explicitly passing a null params array should be handled safely (no NullPointerException).
    @Test
    void run_nullParamsArray_isHandled() throws SQLException {
        columns("AreaName", "TotalPopulation");
        when(resultSet.next()).thenReturn(false);

        assertDoesNotThrow(() -> reportConnection.run("SELECT x", (Object[]) null));
    }

    @Test
    void run_prepareStatementThrows_returnsEmptyList() throws SQLException {
        when(connection.prepareStatement(anyString())).thenThrow(new SQLException("boom"));

        assertTrue(reportConnection.run("SELECT x").isEmpty());
    }


    @Test
    void run_executeQueryThrows_returnsEmptyList() throws SQLException {
        when(statement.executeQuery()).thenThrow(new SQLException("bad query"));

        assertTrue(reportConnection.run("SELECT x").isEmpty());
    }


    @Test
    void run_closesStatementAndResultSet() throws SQLException {
        columns("AreaName", "TotalPopulation");
        when(resultSet.next()).thenReturn(false);

        reportConnection.run("SELECT x");

        verify(resultSet).close();
        verify(statement).close();
    }
}
