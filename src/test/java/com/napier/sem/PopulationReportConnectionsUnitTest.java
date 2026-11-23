package com.napier.sem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PopulationReportConnectionUnitTest {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metadata;
    private PopulationReportConnection reportConnection;

    // Builds a fresh set of mocks before every test and wires them together:
    // connection -> statement -> result set -> metadata.
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

    // Helper: tells the mocked metadata which column labels the "query" returns.
    private void columns(String... labels) throws SQLException {
        when(metadata.getColumnCount()).thenReturn(labels.length);
        for (int i = 0; i < labels.length; i++) {
            when(metadata.getColumnLabel(i + 1)).thenReturn(labels[i]);
        }
    }

    // A null Connection should not throw; run() should just return an empty list.
    @Test
    void run_nullConnection_returnsEmptyList() {
        PopulationReportConnection c = new PopulationReportConnection(null);
        assertTrue(c.run("SELECT 1").isEmpty());
    }

    // A null SQL string should return an empty list and never touch the database.
    @Test
    void run_nullSql_returnsEmptyList() throws SQLException {
        assertTrue(reportConnection.run(null).isEmpty());
        verify(connection, never()).prepareStatement(anyString());
    }

    // A whitespace-only SQL string is treated as blank: empty list, no statement prepared.
    @Test
    void run_blankSql_returnsEmptyList() throws SQLException {
        assertTrue(reportConnection.run("   ").isEmpty());
        verify(connection, never()).prepareStatement(anyString());
    }

    // A query that returns zero rows should give back an empty list.
    @Test
    void run_emptyResultSet_returnsEmptyList() throws SQLException {
        columns("AreaName", "TotalPopulation");
        when(resultSet.next()).thenReturn(false);

        assertTrue(reportConnection.run("SELECT x").isEmpty());
    }

    // With only AreaName and TotalPopulation columns, each row becomes a report with
    // name and total, and CityPopulation is never read from the result set.
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

    // When a CityPopulation column is present, all three fields are mapped into the report.
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

    // The CityPopulation column check ignores case, so an uppercase label
    // (as some databases return) is still detected.
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

    // Calling run() with no parameters should not bind anything to the statement.
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

    // If preparing the statement fails with an SQLException, the error is caught
    // and an empty list is returned instead of the exception propagating.
    @Test
    void run_prepareStatementThrows_returnsEmptyList() throws SQLException {
        when(connection.prepareStatement(anyString())).thenThrow(new SQLException("boom"));

        assertTrue(reportConnection.run("SELECT x").isEmpty());
    }

    // If executing the query fails with an SQLException, the error is caught
    // and an empty list is returned.
    @Test
    void run_executeQueryThrows_returnsEmptyList() throws SQLException {
        when(statement.executeQuery()).thenThrow(new SQLException("bad query"));

        assertTrue(reportConnection.run("SELECT x").isEmpty());
    }

    // The try-with-resources blocks should close both the ResultSet and the
    // PreparedStatement, so no database resources leak.
    @Test
    void run_closesStatementAndResultSet() throws SQLException {
        columns("AreaName", "TotalPopulation");
        when(resultSet.next()).thenReturn(false);

        reportConnection.run("SELECT x");

        verify(resultSet).close();
        verify(statement).close();
    }
}
