package com.napier.sem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CountryConnection {
    private final Connection con;

    public CountryConnection(Connection con){
        this.con = con;
    }

    /** Get countries in a region organised by largest population to smallest from database
     * @param sql SQL that will be run
     * @param params User selects report type (region, continent etc.), if no params all countries shown
     * @return countries List of countries
     *
     */
    public List<Country> runCountryQuery(String sql, Object... params){
       // New list of countries
        List<Country> countries = new ArrayList<>();

        // Prepare SQL Statement
        try (PreparedStatement stmt = con.prepareStatement(sql)){

            // If the statement has params, add the params to SQL
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }

            // Execute SQL Statement
            try(ResultSet rset = stmt.executeQuery()){

            // Add country as object, add countries to array list
            while (rset.next()) {
                countries.add(new Country(
                        rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getInt("Population"),
                        rset.getString("CapitalName")
                ));
            }
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries by region");
        }
        return countries;
    }
}
