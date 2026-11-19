package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** Executes population report queries and maps their result rows. */
public class PopulationReportConnection {
    private final Connection connection;
    public PopulationReportConnection(Connection connection) { this.connection = connection; }

    public List<PopulationReport> run(String sql, Object... params) {
        List<PopulationReport> reports = new ArrayList<>();
        if (connection == null || sql == null || sql.isBlank()) return reports;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; params != null && i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            try (ResultSet result = statement.executeQuery()) {
                ResultSetMetaData metadata = result.getMetaData();
                boolean hasCityPopulation = false;
                for (int i = 1; i <= metadata.getColumnCount(); i++) {
                    if ("CityPopulation".equalsIgnoreCase(metadata.getColumnLabel(i))) {
                        hasCityPopulation = true; break;
                    }
                }
                while (result.next()) {
                    String name = result.getString("AreaName");
                    int total = result.getInt("TotalPopulation");
                    if (hasCityPopulation) reports.add(new PopulationReport(name, total, result.getInt("CityPopulation")));
                    else reports.add(new PopulationReport(name, total));
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve population report: " + e.getMessage());
        }
        return reports;
    }
}
