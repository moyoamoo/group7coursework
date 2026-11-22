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

        // Issue 7
        // All the countries in the world organised by largest population to smallest (Report 1)
        List<Country> allCountries = reports.getAllCountries(countryConnect);
        consoleReport.displayCountryReports(allCountries);
        markdownReport.outputCountryReport(allCountries, "Report_1.md", reports.getReports(1));

        // Issue 8
        // All the countries in a continent organised by largest population to smallest (Report 2)
        List<Country> countriesByContinent = reports.getCountriesByContinent(countryConnect,"South America");
        consoleReport.displayCountryReports(countriesByContinent);
        markdownReport.outputCountryReport(countriesByContinent, "Report_2.md", reports.getReports(2));

        // Issue 9
        // All the countries in a region organised by largest population to smallest (Report 3)
        List<Country> countriesByRegion = reports.getCountriesByRegion(countryConnect, "Polynesia");
        consoleReport.displayCountryReports(countriesByRegion);
        markdownReport.outputCountryReport(countriesByRegion, "Report_3.md", reports.getReports(3));


        // Issue 10
        // The top N populated countries in the world (Report 4)
        List<Country> nCountriesInWorld = reports.getNCountriesInWorld(countryConnect, 3);
        consoleReport.displayCountryReports(nCountriesInWorld);
        markdownReport.outputCountryReport(nCountriesInWorld, "Report_4.md", reports.getReports(4));

        //Issue 11
        // The top N populated countries in a continent (Report 5)
        List<Country> nCountriesInContinent = reports.getNCountriesInContinent(countryConnect, "Europe", 3);
        consoleReport.displayCountryReports(nCountriesInContinent);
        markdownReport.outputCountryReport(nCountriesInContinent, "Report_5.md", reports.getReports(5));

        //Issue 12
        // The top N populated countries in a region (Report 6)
        List<Country> nCountriesInRegion = reports.getNCountriesInRegion(countryConnect, "Nordic Countries", 3);
        consoleReport.displayCountryReports(nCountriesInRegion);
        markdownReport.outputCountryReport(nCountriesInRegion, "Report_6.md", reports.getReports(6));


        // City Reports

        // Issue 13
        // All the cities in the world organised by largest population to smallest (Report 7)
        List <City> allCities = reports.getAllCities(cityConnect);
        consoleReport.displayCityReports(allCities);
        markdownReport.outputCityReport(allCities, "Report_7.md", reports.getReports(7));

        // Issue 14
        // All the cities in a continent organised by largest population to smallest (Report 8)
        List <City> allCitiesInContinent = reports.getAllCitiesInContinent(cityConnect, "Oceania");
        consoleReport.displayCityReports(allCitiesInContinent);
        markdownReport.outputCityReport(allCitiesInContinent, "Report_8.md", reports.getReports(8));

        // Issue 17
        // All the cities in a region organised by largest population to smallest (Report 9)
        List<City> allCitiesInRegion = reports.getAllCitiesInRegion(cityConnect, "Polynesia");
        consoleReport.displayCityReports(allCitiesInRegion);
        markdownReport.outputCityReport(allCitiesInRegion, "Report_8.md", reports.getReports(9));

        //Issue 15
        // All the cities in a country organised by largest population to smallest (Report 10)
        List <City> allCitiesInCountry = reports.getAllCitiesInCountry(cityConnect, "France");
        consoleReport.displayCityReports(allCitiesInCountry);
        markdownReport.outputCityReport(allCitiesInCountry, "Report_10.md", reports.getReports(10));

        // Issue 16
        // All the cities in a district organised by largest population to smallest (Report 11)
        List <City> allCitiesInDistrict = reports.getAllCitiesInCountry(cityConnect, "Baltic Countries");
        consoleReport.displayCityReports(allCitiesInDistrict);
        markdownReport.outputCityReport(allCitiesInDistrict, "Report_11.md", reports.getReports(11));

        // Issue 18
        //All the cities in the world organised by largest population to smallest (Report 12)
        List <City> nCitiesInWorld = reports.getNCitiesInWorld(cityConnect, 10);
        consoleReport.displayCityReports(nCitiesInWorld);
        markdownReport.outputCityReport(nCitiesInWorld, "Report_12.md", reports.getReports(12));

        // Issue 19
        // The top N populated cities in a continent where N is provided by the user (Report 13)
        List <City> nCitiesInContinent = reports.getNCitiesInContinent(cityConnect, "South America", 5);
        consoleReport.displayCityReports(nCitiesInContinent);
        markdownReport.outputCityReport(nCitiesInContinent, "Report_13.md", reports.getReports(13));

        //Issue 20
        //The top N populated cities in a region where N is provided by the user (Report 14)
        List <City> nCitiesInRegion = reports.getNCitiesInRegion(cityConnect, "Eastern Asia", 3);
        consoleReport.displayCityReports(nCitiesInRegion);
        markdownReport.outputCityReport(nCitiesInRegion, "Report_14.md", reports.getReports(14));

        // Issue 21
        // The top N populated cities in a country where N is provided by the user (Report 15)
        List <City> nCitiesInCountry = reports.getNCitiesInCountry(cityConnect, "France", 3);
        consoleReport.displayCityReports(nCitiesInCountry);
        markdownReport.outputCityReport(nCitiesInCountry, "Report_15.md", reports.getReports(15));

        // Issue 22
        // The top N populated cities in a district where N is provided by the user (Report 16)
        List <City> nCitiesInDistrict = reports.getNCitiesInDistrict(cityConnect, "Bali", 3);
        consoleReport.displayCityReports(nCitiesInDistrict);
        markdownReport.outputCityReport(nCitiesInDistrict, "Report_16.md", reports.getReports(16));

        // Capital City Reports

        //Issue 130
        // All the capital cities in the world organised by largest population to smallest (Report 17)
        List <CapitalCity> allCapitals  = reports.getAllCapitals(capitalCityConnect);
        consoleReport.displayCapitalCityReports(allCapitals);
        markdownReport.outputCapitalCityReport(allCapitals, "Report_17.md",  reports.getReports(17));


        // Issue 24
        //All the capital cities in a continent organised by largest population to smallest (Report 18)
        List <CapitalCity> capitalCitiesByContinent = reports.getCapitalsByContinent(capitalCityConnect, "Asia");
        consoleReport.displayCapitalCityReports(capitalCitiesByContinent);
        markdownReport.outputCapitalCityReport(capitalCitiesByContinent, "Report_18.md", reports.getReports(18));

        //Issue 131
        //Report 19
        // All the capital cities in a region organised by largest to smallest (Report 19)
        List <CapitalCity> capitalCitiesByRegion = reports.getCapitalsByRegion(capitalCityConnect, "Caribbean");
        consoleReport.displayCapitalCityReports(capitalCitiesByRegion);
        markdownReport.outputCapitalCityReport(capitalCitiesByRegion, "Report_19.md", reports.getReports(19));

        // All the capital cities in a region organised by largest to smallest (Report 19)

        // Issue 27
        // The top N populated capital cities in the world where N is provided by the user (Report 20)
        List <CapitalCity> topNCapitalsWorld = reports.getTopNCapitalsWorld(capitalCityConnect, 3);
        consoleReport.displayCapitalCityReports(topNCapitalsWorld);
        markdownReport.outputCapitalCityReport(topNCapitalsWorld, "Report_20.md", reports.getReports(20));


        // Issue 26
        // The top N populated capital cities in a continent where N is provided by the user (Report 21)
        List <CapitalCity> topNCapitalsByContinent = reports.getTopNCapitalsByContinent(capitalCityConnect, "Africa", 3);
        consoleReport.displayCapitalCityReports(topNCapitalsByContinent);
        markdownReport.outputCapitalCityReport(topNCapitalsByContinent, "Report_21.md", reports.getReports(21));


        // Issue 25
        //The top N populated capital cities in a region where N is provided by the user (Report 22)
        List <CapitalCity> topNCapitalsByRegion = reports.getTopNCapitalsByRegion(capitalCityConnect, "Caribbean", 3);
        consoleReport.displayCapitalCityReports(topNCapitalsByRegion);
        markdownReport.outputCapitalCityReport(topNCapitalsByRegion, "Report_22.md", reports.getReports(22));


        // Population Reports

        //Issue 28
        // The population of people, people living in cities, and people not living in cities in each continent (Report 23)
        List <PopulationReport> populationDistributionByContinent = reports.getPopulationDistributionByContinent(populationReportConnect);
        consoleReport.displayPopulationReports(populationDistributionByContinent);
        markdownReport.outputPopulationReport(populationDistributionByContinent, "Report_23.md", reports.getReports(23));

        // Issue 29
        // The population of people, people living in cities, and people not living in cities in each region (Report 24)
        List <PopulationReport> populationDistributionByRegion = reports.getPopulationDistributionByRegion(populationReportConnect);
        consoleReport.displayPopulationReports(populationDistributionByRegion);
        markdownReport.outputPopulationReport(populationDistributionByRegion, "Report_24.md", reports.getReports(24));

        // Issue 30
        // The population of people, people living in cities, and people not living in cities in each country (Report 25)
        List <PopulationReport> populationDistributionByCountry = reports.getPopulationDistributionByCountry(populationReportConnect);
        consoleReport.displayPopulationReports(populationDistributionByCountry);
        markdownReport.outputPopulationReport(populationDistributionByCountry, "Report_25.md", reports.getReports(25));

        // Issue 87
        // The population of the world (Report 26)
        List<PopulationReport> worldPopulation = reports.getWorldPopulation(populationReportConnect);
        consoleReport.displayPopulationReports(worldPopulation);
        markdownReport.outputPopulationReport(worldPopulation, "Report_26.md", reports.getReports(26));

        // Issue 31
        // The population of a continent (Report 27)
        List<PopulationReport> populationByContinent = reports.getPopulationByContinent(populationReportConnect, "Africa");
        consoleReport.displayPopulationReports(populationByContinent);
        markdownReport.outputPopulationReport(populationByContinent, "Report_27.md", reports.getReports(27));

        // Issue 32
        // The population of a region (Report 28)
        List<PopulationReport> populationByRegion = reports.getPopulationByRegion(populationReportConnect, "Central Africa");
        consoleReport.displayPopulationReports(populationByRegion);
        markdownReport.outputPopulationReport(populationByRegion, "Report_28.md", reports.getReports(28));

        // Issue 33
        // The population of a country (Report 29)
        List<PopulationReport> populationByCountry = reports.getPopulationByCountry(populationReportConnect, "France");
        consoleReport.displayPopulationReports(populationByCountry);
        markdownReport.outputPopulationReport(populationByRegion, "Report_29.md", reports.getReports(29));

        // Issue 34
        // The population of a district  (Report 30)
        List<PopulationReport> populationByDistrict = reports.getPopulationByDistrict(populationReportConnect, "Addis Abeba");
        consoleReport.displayPopulationReports(populationByDistrict);
        markdownReport.outputPopulationReport(populationByDistrict, "Report_30.md", reports.getReports(30));

        // Issue 35
        // The population of a city (Report 31)
        List<PopulationReport> populationByCity = reports.getPopulationByCity(populationReportConnect, "Edinburgh");
        consoleReport.displayPopulationReports(populationByCity);
        markdownReport.outputPopulationReport(populationByDistrict, "Report_31.md", reports.getReports(31));

        /* Issue 36
           The number of people who speak Chinese, English, Hindi, Spanish,
           Arabic from greatest number to smallest, including the percentage
           of the world population (Report 32)
         */

        List<Language> languages = reports.getPopulationByLanguage(languageConnect);
        consoleReport.displayLanguageReports(languages);
        markdownReport.outputLanguageReport(languages, "Report_32.md", reports.getReports(32));
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
