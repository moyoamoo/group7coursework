package com.napier.sem;

import java.sql.*;
import java.util.List;

public class App
{
    private Connection con = null;
    public CountryConnection countryConnect;
    private CapitalCityConnection capitalCityConnect;
    public CityConnection cityConnect;
    public Reports reports = new Reports();



    //Print Reports
    public void printReports(){

        //Country Reports
        // All the countries in the world organised by largest population to smallest (Report 1)
        List<Country> allCountries = reports.getAllCountries(countryConnect);
        reports.displayCountryReports(allCountries);

        // All the countries in a continent organised by largest population to smallest (Report 2)
        List<Country> countriesByContinent = reports.getCountriesByContinent(countryConnect,"South America");
        reports.displayCountryReports(countriesByContinent);

        // All the countries in a region organised by largest population to smallest (Report 3)
        List<Country> countriesByRegion = reports.getCountriesByRegion(countryConnect, "Polynesia");
        reports.displayCountryReports(countriesByRegion);

        // The top N populated countries in the world (Report 4)
        List<Country> nCountriesInWorld = reports.getNCountriesInWorld(countryConnect, 3);
        reports.displayCountryReports(nCountriesInWorld);

        // The top N populated countries in a continent (Report 5)
        List<Country> nCountriesInContinent = reports.getNCountriesInContinent(countryConnect, "Europe", 3);
        reports.displayCountryReports(nCountriesInContinent);


        // City Report
        // All the cities in the world organised by largest population to smallest (Report 7)
        List <City> allCities = reports.getAllCities(cityConnect);
        reports.displayCityReports(allCities);

        // All the cities in a continent organised by largest population to smallest (Report 8)
        List <City> allCitiesInContinent = reports.getAllCitiesInContinent(cityConnect, "Oceania");
        reports.displayCityReports(allCitiesInContinent);

        // All the cities in a country organised by largest population to smallest (Report 10)
        List <City> allCitiesInCountry = reports.getAllCitiesInCountry(cityConnect, "France");
        reports.displayCityReports(allCitiesInCountry);

        //The top N populated cities in a region where N is provided by the user (Report 14)
        List <City> nCitiesInRegion = reports.getNCitiesInRegion(cityConnect, "Eastern Asia", 3);
        reports.displayCityReports(nCitiesInRegion);

                // Capital City Reports
        // The top N populated capital cities in the world where N is provided by the user (Report 20)

        List <CapitalCity> topNCapitalsWorld = reports.getTopNCapitalsWorld(capitalCityConnect, 3);
        reports.displayCapitalCityReports(topNCapitalsWorld);

        //The top N populated capital cities in a continent where N is provided by the user (Report 21)
        List <CapitalCity> topNCapitalsByContinent = reports.getTopNCapitalsByContinent(capitalCityConnect, "Africa", 3);
        reports.displayCapitalCityReports(topNCapitalsByContinent);

        //The top N populated capital cities in a region where N is provided by the user (Report 22)
        List <CapitalCity> topNCapitalsByRegion = reports.getTopNCapitalsByRegion(capitalCityConnect, "Caribbean", 3);
        reports.displayCapitalCityReports(topNCapitalsByRegion);
   }

    /** Connect to the MySQL Database
     *
     * @param location Host and port for the database
     * @delay ms to wait before each connection attempt
     */
    public void connect(String location, int delay)
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
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");

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

        if (args.length < 1){
            // Connect to database
            a.connect("localhost:33060", 30000);
        } else {
            a. connect(args[0], Integer.parseInt(args[1]));
        }

        // Show list of possible reports
        // a.reports.displayReports("Welcome to Population Report");

        // Print all reports
        a.printReports();

        // Disconnect from database
        a.disconnect();
    }
}
