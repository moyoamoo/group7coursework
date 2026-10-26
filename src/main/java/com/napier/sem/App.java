package com.napier.sem;

import java.sql.*;
import java.util.List;

public class App
{
    private Connection con = null;
    private CountryConnection countryConnect;
    private CapitalCityConnection capitalCityConnect;
    private CityConnection cityConnect;
    private final Reports reports = new Reports();



    //Print Reports
    public void printReports(){

        //Country Reports
        // All the countries in the world organised by largest population to smallest (Report 1)
        reports.printAllCountries(countryConnect);

        // All the countries in a continent organised by largest population to smallest (Report 2)
        reports.printCountriesByContinent(countryConnect);

        //All the countries in a region organised by largest population to smallest (Report 3)
        reports.printCountriesByRegion(countryConnect);

        //The top N populated countries in the world (Report 4)
        reports.printNCountriesInWorld(countryConnect);

        //The top N populated countries in a continent (Report 5)
        reports.printNCountriesInContinent(countryConnect);

        // Capital City Reports
        // The top N populated capital cities in the world where N is provided by the user (Report 20)
        reports.printTopNCapitalsWorld(capitalCityConnect, 3);

        //The top N populated capital cities in a continent where N is provided by the user (Report 21)
        reports.printTopNCapitalsByContinent(capitalCityConnect, "Africa", 3);

        //The top N populated capital cities in a region where N is provided by the user (Report 22)
        reports.printTopNCapitalsByRegion(capitalCityConnect, "Caribbean", 3);
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
                countryConnect = new CountryConnection(con);
                capitalCityConnect = new CapitalCityConnection(con);
                cityConnect = new CityConnection(con);
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
