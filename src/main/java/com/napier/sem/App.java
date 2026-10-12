package com.napier.sem;

import java.sql.*;
import java.util.List;

public class App
{
    private Connection con = null;
    private CountryConnection countryConnect;
    private static final int MIN_INPUT_RANGE = 1;
    private final Regions regions = new Regions();
    private final Reports reports = new Reports();
    private final Continents continents = new Continents();
    private final UserInput userInput = new UserInput();



    /** User select the report they want to view
     *
     * @param reportNumber Number shown to user, not reports index in array
     */
    public void selectReport(int reportNumber){

        switch (reportNumber){
            case 1:
                System.out.println("All the countries in the world organised by largest population to smallest ");
                allCountries();
                break;
            case 2:
                System.out.println("All the countries in a continent organised by largest population to smallest ");
                countriesByContinent();
                break;
            case 3:
                System.out.println("All the countries in a region organised by largest population to smallest ");
                countriesByRegion();
                break;
            default:
                System.out.println("Report not found");

        }
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
        int continentNumber = userInput.getUserInt("Enter a Continent number: ", MIN_INPUT_RANGE, continents.count());

        //Get user selection of continent as string
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

        // Get user selection of region as int
        int regionNumber = userInput.getUserInt("Enter a Region number: ", MIN_INPUT_RANGE, regions.count());

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

    public static void main(String[] args) {

        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Show list of possible reports
        a.reports.displayReports("Welcome to Population Report");

        // Get the number of the report the user would like to view
        int reportNumber = a.userInput.getUserInt("Enter a Report Number: ", MIN_INPUT_RANGE, a.reports.count());

        // Select report
        a.selectReport(reportNumber);

        //Disconnect from database
        a.disconnect();
    }
}
