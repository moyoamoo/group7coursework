package com.napier.sem;

import java.sql.*;
import java.util.List;

public class App
{
    private Connection con = null;
    private CountryConnection countryConnect;
    private final Regions regions = new Regions();
    private final Reports reports = new Reports();
    private final Continents continents = new Continents();


    //Print Reports
    public void printReports(){

        //Report 1
        System.out.println("All the countries in the world organised by largest population to smallest ");
        allCountries();

        //Report 2
        System.out.println("All the countries in a continent organised by largest population to smallest ");
        countriesByContinent();

        //Report 3
        System.out.println("All the countries in a region organised by largest population to smallest ");
        countriesByRegion();

        //Report 4
        System.out.println("The top N populated countries in the world");
        nCountriesInWorld();

        System.out.println("Report not found");
   }
    /** Connect to the MySQL Database
     *
     */
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

                // connection
                countryConnect= new CountryConnection(con);
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

    /** Disconnect from the MySQL database
     *
     */
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

    /** All the countries in the world organised by largest population to smallest (Report 1)
     *
     */
    public void allCountries(){
        // Run database query to get all countries
        List<Country> countries = countryConnect.runCountryQuery(CountryQueries.ALL_COUNTRIES);

        // Display countries
        for(Country c : countries){
            System.out.println(c.toString());
        }
    }

    /** All the countries in a continent organised by largest population to smallest (Report 2)
     *
     */
    public void countriesByContinent(){
        // Display list of continents
        continents.displayContinents("Continents:");

        // Get user section of continent as int
        int continentNumber = 2;

        String continent = continents.getContinent(continentNumber);

        System.out.println("All the countries in " + continent + " organised by largest population to smallest");

        // Run database query to get countries as continents
        List<Country> countries = countryConnect.runCountryQuery(CountryQueries.COUNTRIES_BY_CONTINENT, continent);

        // Display countries
        for(Country c : countries){
            System.out.println(c.toString());
        }

    }

    /** All the countries in a region organised by largest population to smallest (Report 3)
     *
     */
    public void countriesByRegion(){
        // Display list of regions
        regions.displayRegions("Regions:");

        int regionNumber = 2;

        // Get user selection of region as string
        String region = regions.getRegion(regionNumber);
        System.out.println("All the countries in " + region + " organised by largest population to smallest");

        // Run database query to get countries as region
        List<Country> countries = countryConnect.runCountryQuery(CountryQueries.COUNTRIES_BY_REGION, region);

        // Display countries
        for(Country c : countries){
            System.out.println(c.toString());
        }
    }

    public void nCountriesInWorld(){
        int numberOfCountries = 10;

        System.out.println("Top " + numberOfCountries + " populated countries in the world");

        // Run database query to get countries as region
        List<Country> countries = countryConnect.runCountryQuery(CountryQueries.N_COUNTRIES, numberOfCountries);

        // Display countries
        for(Country c : countries){
            System.out.println(c.toString());
        }
    }

    public static void main(String[] args) {

        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Show list of possible reports
        a.reports.displayReports("Welcome to Population Report");

        // Print all reports
        a.printReports();

        // Disconnect from database
        a.disconnect();
    }
}
