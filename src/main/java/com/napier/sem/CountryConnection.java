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
     * @param region Name of region user has selected to view report
     * @return countries ArrayList of countries
     *
     */
    public List<Country> getCountriesByRegion(String region){
        List<Country> countries = new ArrayList<>();

        try{
            // SQL statement to find countries in the selected region
            String sqlCountriesByRegion =
                    "SELECT c.Name, c.Continent, c.Region, c.Population, c.Code, ci.Name AS CapitalName "
                            + "FROM country c "
                            + "LEFT JOIN city ci ON c.Capital = ci.ID "
                            + "WHERE c.Region = '" + region + "' "
                            + "ORDER BY c.Population DESC";

            // Create SQL statement, prepared statement allows sql parameters
            PreparedStatement stmt = con.prepareStatement(sqlCountriesByRegion);
            // Parameter is region selected by user
            stmt.setString(1, region);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();

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

            rset.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries by region");
        }
        return countries;
    }
}
