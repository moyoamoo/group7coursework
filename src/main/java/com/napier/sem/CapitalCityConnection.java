package com.napier.sem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Represents db connection for city reports


public class CapitalCityConnection {
    private final Connection con;

    public CapitalCityConnection(Connection con){
        this.con = con;
    }

    public List<CapitalCity> runCapitalCityQuery(String sql, Object... params){
        List<CapitalCity> cities = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }

            try(ResultSet rset = stmt.executeQuery()) {
                while (rset.next()) {
                    cities.add(new CapitalCity(
                            rset.getString("Name"),
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