package com.napier.sem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Represents db connection for city reports


public class CityConnection {
    private final Connection con;

    public CityConnection(Connection con){
        this.con = con;
    }

    public List<City> runCityQuery(String sql, Object... params){

        // New list of cities
        List<City> cities = new ArrayList<>();

        // Prepare SQL Statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // If the statement has params, add the params to SQL
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            // Execute SQL Statement
            try(ResultSet rset = stmt.executeQuery()) {
                while (rset.next()) {
                    cities.add(new City(
                            rset.getString("Name"),
                            rset.getString("District"),
                            rset.getString("Country"),
                            rset.getInt("Population")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return cities;
    }
}