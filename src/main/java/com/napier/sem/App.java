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
        try{
            // Create SQL statement
            Statement stmt = con.createStatement();

            // String got SQL statement
            String strSelectCountry =
                    "SELECT Name, Continent, Region, Population, Capital, Code "
                            + "FROM country "
                            + "WHERE country = " + country;

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelectCountry);

            // Return a new country
            if(rset.next()){
                String name = rset.getString("Name");
                String code = rset.getString("Code");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                String capital = rset.getString("Capital");
                Country newCountry = new Country(code, name, continent, region, population, capital);

                return newCountry;
            } else {
                return null;
            }
        }   catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }


    }

    public void displayCountry(Country newCountry){
        if(newCountry != null){
            newCountry.toString();
        }
    }
}
