package com.napier.sem;

import java.sql.*;
import java.util.List;

public class App
{
    private Connection con = null;
    public CountryConnection countryConnect;
    public CapitalCityConnection capitalCityConnect;
    public CityConnection cityConnect;
    public PopulationReportConnection populationReportConnect;
    public Reports reports = new Reports();



    //Print Reports
    public void printReports(){
        //Country Reports

        //Issue 7
        // All the countries in the world organised by largest population to smallest (Report 1)
        List<Country> allCountries = reports.getAllCountries(countryConnect);
        reports.displayCountryReports(allCountries);
        reports.outputCountryReport(allCountries, "Report_1.md");

        //Issue 8
        // All the countries in a continent organised by largest population to smallest (Report 2)
        List<Country> countriesByContinent = reports.getCountriesByContinent(countryConnect,"South America");
        reports.displayCountryReports(countriesByContinent);
        reports.outputCountryReport(countriesByContinent, "Report_2.md");

        //Issue 9
        // All the countries in a region organised by largest population to smallest (Report 3)
        List<Country> countriesByRegion = reports.getCountriesByRegion(countryConnect, "Polynesia");
        reports.displayCountryReports(countriesByRegion);
        reports.outputCountryReport(countriesByRegion, "Report_3.md");


        //Issue 10
        // The top N populated countries in the world (Report 4)
        List<Country> nCountriesInWorld = reports.getNCountriesInWorld(countryConnect, 3);
        reports.displayCountryReports(nCountriesInWorld);
        reports.outputCountryReport(nCountriesInWorld, "Report_4.md");


        //Issue 11
        // The top N populated countries in a continent (Report 5)
        List<Country> nCountriesInContinent = reports.getNCountriesInContinent(countryConnect, "Europe", 3);
        reports.displayCountryReports(nCountriesInContinent);
        reports.outputCountryReport(nCountriesInContinent, "Report_5.md");

        //Issue 12
        // The top N populated countries in a region (Report 6)
        List<Country> nCountriesInRegion = reports.getNCountriesInRegion(countryConnect, "Nordic Countries", 3);
        reports.displayCountryReports(nCountriesInRegion);
        reports.outputCountryReport(nCountriesInRegion, "Report_6.md");


        // City Report

        //Issue 13
        // All the cities in the world organised by largest population to smallest (Report 7)
        List <City> allCities = reports.getAllCities(cityConnect);
        reports.displayCityReports(allCities);
        reports.outputCityReport(allCities, "Report_7.md");

        //Issue 14
        // All the cities in a continent organised by largest population to smallest (Report 8)
        List <City> allCitiesInContinent = reports.getAllCitiesInContinent(cityConnect, "Oceania");
        reports.displayCityReports(allCitiesInContinent);
        reports.outputCityReport(allCitiesInContinent, "Report_8.md");

        //Issue 17
        //All the cities in a region organised by largest population to smallest (Report 9)
        List<City> allCitiesInRegion = reports.getAllCitiesInRegion(cityConnect, "Polynesia");
        reports.displayCityReports(allCitiesInRegion);

        //Issue 15
        // All the cities in a country organised by largest population to smallest (Report 10)
        List <City> allCitiesInCountry = reports.getAllCitiesInCountry(cityConnect, "France");
        reports.displayCityReports(allCitiesInCountry);
        reports.outputCityReport(allCitiesInCountry, "Report_10.md");

        //Issue 16
        //All the cities in a district organised by largest population to smallest (Report 11)
        List <City> allCitiesInDistrict = reports.getAllCitiesInCountry(cityConnect, "Baltic Countries");
        reports.displayCityReports(allCitiesInDistrict);

        // Issue 18
        //All the cities in the world organised by largest population to smallest (Report 12)
        List <City> nCitiesInWorld = reports.getNCitiesInWorld(cityConnect, 10);
        reports.displayCityReports(nCitiesInWorld);

        //Issue 19
        //The top N populated cities in a continent where N is provided by the user (Report 13)
        List <City> nCitiesInContinent = reports.getNCitiesInContinent(cityConnect, "South America", 5);
        reports.displayCityReports(nCitiesInContinent);

        //Issue 20
        //The top N populated cities in a region where N is provided by the user (Report 14)
        List <City> nCitiesInRegion = reports.getNCitiesInRegion(cityConnect, "Eastern Asia", 3);
        reports.displayCityReports(nCitiesInRegion);
        reports.outputCityReport(nCitiesInRegion, "Report_14.md");

        // Capital City Reports



        // Issue 21
        // The top N populated cities in a country where N is provided by the user (Report 15)

        // Issue 22
        // The top N populated cities in a district where N is provided by the user (Report 16)

        // Capital City Reports

        // All the capital cities in the world organised by largest population to smallest (Report 17)

        // Issue 24
        //All the capital cities in a continent organised by largest population to smallest (Report 18)
        List <CapitalCity> capitalCitiesByContinent = reports.getCapitalsByContinent(capitalCityConnect, "Asia");
        reports.displayCapitalCityReports(capitalCitiesByContinent);
        reports.outputCapitalCityReport(capitalCitiesByContinent, "Report_18.md");

        // All the capital cities in a region organised by largest to smallest (Report 19)

        // Issue 27
        // The top N populated capital cities in the world where N is provided by the user (Report 20)
        List <CapitalCity> topNCapitalsWorld = reports.getTopNCapitalsWorld(capitalCityConnect, 3);
        reports.displayCapitalCityReports(topNCapitalsWorld);
        reports.outputCapitalCityReport(topNCapitalsWorld, "Report_20.md");


        // Issue 26
        // The top N populated capital cities in a continent where N is provided by the user (Report 21)
        List <CapitalCity> topNCapitalsByContinent = reports.getTopNCapitalsByContinent(capitalCityConnect, "Africa", 3);
        reports.displayCapitalCityReports(topNCapitalsByContinent);
        reports.outputCapitalCityReport(topNCapitalsByContinent, "Report_21.md");


        // Issue 25
        //The top N populated capital cities in a region where N is provided by the user (Report 22)
        List <CapitalCity> topNCapitalsByRegion = reports.getTopNCapitalsByRegion(capitalCityConnect, "Caribbean", 3);
        reports.displayCapitalCityReports(topNCapitalsByRegion);
        reports.outputCapitalCityReport(topNCapitalsByRegion, "Report_22.md");


        // Population Reports

        //Issue 28
        // The population of people, people living in cities, and people not living in cities in each continent (Report 23)
        System.out.println("\n#28 Population distribution by continent");
        reports.displayPopulationReports(reports.getPopulationDistributionByContinent(populationReportConnect));

        // Issue 29
        // The population of people, people living in cities, and people not living in cities in each region (Report 24)
        System.out.println("\n#29 Population distribution by region");
        reports.displayPopulationReports(reports.getPopulationDistributionByRegion(populationReportConnect));

        // Issue 30
        // The population of people, people living in cities, and people not living in cities in each country (Report 25)
        System.out.println("\n#30 Population distribution by country");
        reports.displayPopulationReports(reports.getPopulationDistributionByCountry(populationReportConnect));

        // Issue 87
        // The population of the world (Report 26)

        //Issue 31
        // The population of a continent (Report 27)
        System.out.println("\n#31 Total population by continent");
        reports.displayPopulationReports(reports.getTotalPopulationByContinent(populationReportConnect));

        //Issue 32
        // The population of region (Report 28)
        System.out.println("\n#32 Total population by region");
        reports.displayPopulationReports(reports.getTotalPopulationByRegion(populationReportConnect));

        // Issue 33
        // The population of a country (Report 29)
        System.out.println("\n#33 Total population by country");
        reports.displayPopulationReports(reports.getTotalPopulationByCountry(populationReportConnect));

        // Issue 34
        // The population of a district (Report 30)

        // Issue 35
        // The population of a city (Report 31)

        // Issue 36
        // The number of people who speak Chinese, English, Hindi, Spanish, Arabic from greatest number to smallest, including the percentage of the world population (Report 32)
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

                // Database connections
                countryConnect = new CountryConnection(con);
                capitalCityConnect = new CapitalCityConnection(con);
                cityConnect = new CityConnection(con);
                populationReportConnect = new PopulationReportConnection(con);
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
