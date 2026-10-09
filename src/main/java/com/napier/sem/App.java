package com.napier.sem;

import java.lang.annotation.ElementType;
import java.sql.*;
import java.util.Scanner;

public class App
{

    private Connection con = null;
    private static final Scanner scan = new Scanner(System.in);
    private final Regions regions = new Regions();
    private final Reports reports = new Reports();


    // Get the users report number
    public int getUserReportSelection(){
        return getUserInt("Enter a report number: ", 1, reports.count());
   }

    // Get the users region number
    public int getUserRegionSelection(){
        return getUserInt("Enter a region number: ", 1, regions.count());
    }


    // Get a valid user integer within range
    private int getUserInt(String prompt, int min, int max) {
        boolean validInput = false;
        int userValue = 0;
        //while user input is invalid
        while (!validInput) {
            //print user prompt
            System.out.print(prompt);
            if (!scan.hasNextLine()) {
                throw new IllegalStateException("No input available");
            }

            String input = scan.nextLine().trim();
            try {
                userValue = Integer.parseInt(input);
                //see if int is in range of expected values
                if ((userValue < min) || (userValue > max)) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                } else {
                    validInput = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("'" + input + "' is not a valid number.");
            }
        }
        return userValue;
    }


   public void selectReport(int reportNumber){

        switch (reportNumber){
            case 1:
                System.out.println("All the countries in the world organised by largest population to smallest ");
                break;
            case 2:
                System.out.println("All the countries in a continent organised by largest population to smallest ");
                break;
            case 3:
                System.out.println("All the countries in a region organised by largest population to smallest ");
                countriesByRegion();
                break;
            default:
                System.out.println("Report not found");

        }
   }
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

    public void countriesByRegion(){
        int regionNumber = getUserRegionSelection();
        String region = regions.getRegion(regionNumber);
        System.out.println("All the countries in " + region + "organised by largest population to smallest");
        getCountriesByRegion(region);
    }


    public void getCountriesByRegion(String region) {
        try {
        // Create SQL statement
        Statement stmt = con.createStatement();

        // SQL statement to find countries in the selected region
        String strSelectCountries =
        "SELECT c.Name, c.Continent, c.Region, c.Population, c.Code, ci.Name AS CapitalName "
        + "FROM country c "
        + "LEFT JOIN city ci ON c.Capital = ci.ID "
        + "WHERE c.Region = '" + region + "' "
        + "ORDER BY c.Population DESC";

        // Execute SQL statement
        ResultSet rset = stmt.executeQuery(strSelectCountries);

        // Display each country
        while (rset.next()) {
        String name = rset.getString("Name");
        String code = rset.getString("Code");
        String continent = rset.getString("Continent");
        String countryRegion = rset.getString("Region");
        int population = rset.getInt("Population");
        String capital = rset.getString("CapitalName");

        Country country = new Country(
        code,
        name,
        continent,
        countryRegion,
        population,
        capital
        );

        displayCountry(country);
        }

        rset.close();
        stmt.close();

    } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Failed to get countries by region");
    }
}

    public void displayCountry(Country newCountry) {
        if (newCountry != null) {
            System.out.println(newCountry.toString());
        } else {
            System.out.println("No country found");
        }
    }

    public static void main(String[] args) {

        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Show list of possible reports
        a.reports.displayReports("Welcome to Population Report");

        // Get the number of the report the user would like to view
        int reportNumber = a.getUserReportSelection();

        // Select report
        a.selectReport(reportNumber);

        //Disconnect from database
        a.disconnect();
    }
}
