package com.napier.sem;

import java.sql.*;

public class App
{
    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        Country ctry = a.getCountry("France");
        a.displayCountry(ctry);
        a.getCountriesByPopulation();

        // Disconnect from database
        a.disconnect();
    }

    private Connection con = null;

    // Connect to the MySQL database
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            // If class not found, exit with status -1
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        // Retry connection if it does not connect
        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait for database  to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sql)
            {

                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sql.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    // Disconnect from the MySQL database.
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }


    public Country getCountry(String country) {
        try {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // String for SQL statement
            String strSelectCountry =
                    "SELECT c.Name, c.Continent, c.Region, c.Population, c.Code, ci.Name AS CapitalName "
                            + "FROM country c "
                            + "LEFT JOIN city ci ON c.Capital = ci.ID "
                            + "WHERE c.Name = '" + country + "'";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelectCountry);

            // Return a new country
            if (rset.next()) {
                String name = rset.getString("Name");
                String code = rset.getString("Code");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                String capital = rset.getString("CapitalName");
                Country newCountry = new Country(code, name, continent, region, population, capital);

                return newCountry;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void getCountriesByPopulation() {
        try {

            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL statement
            String strSelectCountries = 
                "SELECT c.Name, c.Continent, c.Region, c.Population, c.Code, ci.Name AS CapitalName "
                + "FROM country c"
                + "LEFT JOIN city ci ON c.Capital = ci.ID "
                + "ORDER BY c.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelectCountries);

            // Display each country
            while (rset.next()) {
                String name = rset.getString("Name");
                String code = rset.getString("Code");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                String capital = rset.getString("CapitalName");

                Country country = new Country(
                    code,
                    name,
                    continent,
                    region,
                    population,
                    capital
                );

                displayCountry(country);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries by population");
        }
    }

    
    public void displayCountry(Country newCountry) {
        if (newCountry != null) {
            System.out.println(newCountry.toString());
        } else {
            System.out.println("No country found");
        }
    }
}
