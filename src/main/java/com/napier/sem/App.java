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
    public LanguageConnection languageConnect;
    public Reports reports = new Reports();
    public PrintReportConsole consoleReport = new PrintReportConsole();
    public PrintReportMarkdown markdownReport = new PrintReportMarkdown();



    //Print Reports
    public void printReports(){
        //Country Reports

        //Issue 7
        //Report 1
        // All the countries in the world organised by largest population to smallest (Report 1)
        /* Issue 7
          All the countries in the world organised by largest population to smallest (Report 1) */
        List<Country> allCountries = reports.getAllCountries(countryConnect);
        consoleReport.displayCountryReports(allCountries);
        markdownReport.outputCountryReport(allCountries, "Report_1.md");

        /* Issue 8
           All the countries in a continent organised by largest population to smallest (Report 2) */
        //Issue 8
        //Report 2
        // All the countries in a continent organised by largest population to smallest (Report 2)
        List<Country> countriesByContinent = reports.getCountriesByContinent(countryConnect,"South America");
        consoleReport.displayCountryReports(countriesByContinent);
        markdownReport.outputCountryReport(countriesByContinent, "Report_2.md");

        //Issue 9
        //Report 3
        // All the countries in a region organised by largest population to smallest (Report 3)
        /* Issue 9
           All the countries in a region organised by largest population to smallest (Report 3) */
        List<Country> countriesByRegion = reports.getCountriesByRegion(countryConnect, "Polynesia");
        consoleReport.displayCountryReports(countriesByRegion);
        markdownReport.outputCountryReport(countriesByRegion, "Report_3.md");


        //Issue 10
        //Report 4
        // The top N populated countries in the world (Report 4)
        List<Country> nCountriesInWorld = reports.getNCountriesInWorld(countryConnect, 3);
        consoleReport.displayCountryReports(nCountriesInWorld);
        markdownReport.outputCountryReport(nCountriesInWorld, "Report_4.md");


        //Issue 11
        //Report 5
        // The top N populated countries in a continent (Report 5)
        List<Country> nCountriesInContinent = reports.getNCountriesInContinent(countryConnect, "Europe", 3);
        consoleReport.displayCountryReports(nCountriesInContinent);
        markdownReport.outputCountryReport(nCountriesInContinent, "Report_5.md");

        //Issue 12
        //Report 6
        // The top N populated countries in a region (Report 6)
        List<Country> nCountriesInRegion = reports.getNCountriesInRegion(countryConnect, "Nordic Countries", 3);
        consoleReport.displayCountryReports(nCountriesInRegion);
        markdownReport.outputCountryReport(nCountriesInRegion, "Report_6.md");


        // City Report

        //Issue 13
        //Report 7
        // All the cities in the world organised by largest population to smallest (Report 7)
        List <City> allCities = reports.getAllCities(cityConnect);
        consoleReport.displayCityReports(allCities);
        markdownReport.outputCityReport(allCities, "Report_7.md");

        //Issue 14
        //Report 8
        // All the cities in a continent organised by largest population to smallest (Report 8)
        List <City> allCitiesInContinent = reports.getAllCitiesInContinent(cityConnect, "Oceania");
        consoleReport.displayCityReports(allCitiesInContinent);
        markdownReport.outputCityReport(allCitiesInContinent, "Report_8.md");

        //Issue 17
        //Report 9
        //All the cities in a region organised by largest population to smallest (Report 9)
        List<City> allCitiesInRegion = reports.getAllCitiesInRegion(cityConnect, "Polynesia");
        consoleReport.displayCityReports(allCitiesInRegion);

        //Issue 15
        //Report 10
        // All the cities in a country organised by largest population to smallest (Report 10)
        List <City> allCitiesInCountry = reports.getAllCitiesInCountry(cityConnect, "France");
        consoleReport.displayCityReports(allCitiesInCountry);
        markdownReport.outputCityReport(allCitiesInCountry, "Report_10.md");

        //Issue 16
        //Report 11
        //All the cities in a district organised by largest population to smallest (Report 11)
        List <City> allCitiesInDistrict = reports.getAllCitiesInCountry(cityConnect, "Baltic Countries");
        consoleReport.displayCityReports(allCitiesInDistrict);

        // Issue 18
        //Report 12
        //All the cities in the world organised by largest population to smallest (Report 12)
        List <City> nCitiesInWorld = reports.getNCitiesInWorld(cityConnect, 10);
        consoleReport.displayCityReports(nCitiesInWorld);

        //Issue 19
        //Report 13
        //The top N populated cities in a continent where N is provided by the user (Report 13)
        List <City> nCitiesInContinent = reports.getNCitiesInContinent(cityConnect, "South America", 5);
        consoleReport.displayCityReports(nCitiesInContinent);

        //Issue 20
        //Report 14
        //The top N populated cities in a region where N is provided by the user (Report 14)
        List <City> nCitiesInRegion = reports.getNCitiesInRegion(cityConnect, "Eastern Asia", 3);
        consoleReport.displayCityReports(nCitiesInRegion);
        markdownReport.outputCityReport(nCitiesInRegion, "Report_14.md");


        // Issue 21
        //Report 15
        // The top N populated cities in a country where N is provided by the user (Report 15)
        List <City> nCitiesInCountry = reports.getNCitiesInCountry(cityConnect, "France", 3);
        consoleReport.displayCityReports(nCitiesInCountry);

        // Issue 22
        //Report 16
        // The top N populated cities in a district where N is provided by the user (Report 16)
        List <City> nCitiesInDistrict = reports.getNCitiesInDistrict(cityConnect, "Bali", 3);
        consoleReport.displayCityReports(nCitiesInDistrict);
        // Capital City Reports

        // All the capital cities in the world organised by largest population to smallest (Report 17)

        //Issue 130
        //Report 17
        List <CapitalCity> allCapitals  = reports.getAllCapitals(capitalCityConnect);
        reports.displayCapitalCityReports(allCapitals);
        reports.outputCapitalCityReport(allCapitals, "Report_17.md");


        // Issue 24
        //Report 18
        //All the capital cities in a continent organised by largest population to smallest (Report 18)
        List <CapitalCity> capitalCitiesByContinent = reports.getCapitalsByContinent(capitalCityConnect, "Asia");
        consoleReport.displayCapitalCityReports(capitalCitiesByContinent);
        markdownReport.outputCapitalCityReport(capitalCitiesByContinent, "Report_18.md");

        //Issue 131
        //Report 19
        // All the capital cities in a region organised by largest to smallest (Report 19)
        List <CapitalCity> capitalCitiesByRegion = reports.getCapitalsByRegion(capitalCityConnect, "Caribbean");
        reports.displayCapitalCityReports(capitalCitiesByRegion);
        reports.outputCapitalCityReport(capitalCitiesByRegion, "Report_19.md");

        // All the capital cities in a region organised by largest to smallest (Report 19)

        // Issue 27
        //Report 20
        // The top N populated capital cities in the world where N is provided by the user (Report 20)
        List <CapitalCity> topNCapitalsWorld = reports.getTopNCapitalsWorld(capitalCityConnect, 3);
        consoleReport.displayCapitalCityReports(topNCapitalsWorld);
        markdownReport.outputCapitalCityReport(topNCapitalsWorld, "Report_20.md");


        // Issue 26
        //Report 21
        // The top N populated capital cities in a continent where N is provided by the user (Report 21)
        List <CapitalCity> topNCapitalsByContinent = reports.getTopNCapitalsByContinent(capitalCityConnect, "Africa", 3);
        consoleReport.displayCapitalCityReports(topNCapitalsByContinent);
        markdownReport.outputCapitalCityReport(topNCapitalsByContinent, "Report_21.md");


        // Issue 25
        //Report 22
        //The top N populated capital cities in a region where N is provided by the user (Report 22)
        List <CapitalCity> topNCapitalsByRegion = reports.getTopNCapitalsByRegion(capitalCityConnect, "Caribbean", 3);
        consoleReport.displayCapitalCityReports(topNCapitalsByRegion);
        markdownReport.outputCapitalCityReport(topNCapitalsByRegion, "Report_22.md");


        // Population Reports

        //Issue 28
        //Report 23
        // The population of people, people living in cities, and people not living in cities in each continent (Report 23)
        System.out.println("\n#28 Population distribution by continent");
        consoleReport.displayPopulationReports(reports.getPopulationDistributionByContinent(populationReportConnect));

        // Issue 29
        //Report 24
        // The population of people, people living in cities, and people not living in cities in each region (Report 24)
        System.out.println("\n#29 Population distribution by region");
        consoleReport.displayPopulationReports(reports.getPopulationDistributionByRegion(populationReportConnect));

        // Issue 30
        //Report 25
        // The population of people, people living in cities, and people not living in cities in each country (Report 25)
        System.out.println("\n#30 Population distribution by country");
        consoleReport.displayPopulationReports(reports.getPopulationDistributionByCountry(populationReportConnect));

        // Issue 87
        //Report 26
        // The population of the world (Report 26)

        /* Issue 31
          The population of a continent (Report 27) */
        List<PopulationReport> populationByContinent = reports.getPopulationByContinent(populationReportConnect, "Africa");
        consoleReport.displayPopulationReports(populationByContinent);
        //Issue 31
        //Report 27
        // The population of a continent (Report 27)
        System.out.println("\n#31 Total population by continent");
        reports.displayPopulationReports(reports.getTotalPopulationByContinent(populationReportConnect));

        //Issue 32
        //Report 28
        // The population of region (Report 28)
        System.out.println("\n#32 Total population by region");
        reports.displayPopulationReports(reports.getTotalPopulationByRegion(populationReportConnect));
        /* Issue 32
          The population of a region (Report 28) */
        List<PopulationReport> populationByRegion = reports.getPopulationByRegion(populationReportConnect, "Central Africa");
        consoleReport.displayPopulationReports(populationByRegion);

        /* Issue 33
           The population of a country (Report 29) */
        List<PopulationReport> populationByCountry = reports.getPopulationByCountry(populationReportConnect, "France");
        consoleReport.displayPopulationReports(populationByCountry);
        // Issue 33
        //Report 29
        // The population of a country (Report 29)
        System.out.println("\n#33 Total population by country");
        reports.displayPopulationReports(reports.getTotalPopulationByCountry(populationReportConnect));

        // Issue 34
        //Report 30
        // The population of a district (Report 30)
         /* Issue 34
           The population of a district  (Report 30) */
        List<PopulationReport> populationByDistrict = reports.getPopulationByDistrict(populationReportConnect, "Addis Abeba");
        consoleReport.displayPopulationReports(populationByDistrict);

        /* Issue 35
           The population of a city (Report 31) */
        List<PopulationReport> populationByCity = reports.getPopulationByCity(populationReportConnect, "Edinburgh");
        consoleReport.displayPopulationReports(populationByCity);
        // Issue 35
        //Report 31
        // The population of a city (Report 31)

        /* Issue 36
           The number of people who speak Chinese, English, Hindi, Spanish,
           Arabic from greatest number to smallest, including the percentage
           of the world population (Report 32)
         */

        List<Language> languages = reports.getPopulationByLanguage(languageConnect);
        consoleReport.displayLanguageReports(languages);
        // Issue 36
        //Report 32
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
                languageConnect = new LanguageConnection(con);

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
