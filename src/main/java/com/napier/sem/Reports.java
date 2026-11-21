package com.napier.sem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reports {
    private final Continents continents = new Continents();
    private final Regions regions = new Regions();
    private final UserInput userInput = new UserInput();
    private static final String[] reports = {
            "All the countries in the world organised by largest population to smallest",
            "All the countries in a continent organised by largest population to smallest",
            "All the countries in a region organised by largest population to smallest",
            "The top N populated countries in the world where N is provided by the user",
            "The top N populated countries in a continent where N is provided by the user",
            "The top N populated countries in a region where N is provided by the user",
            "All the cities in the world organised by largest population to smallest",
            "All the cities in a continent organised by largest population to smallest",
            "All the cities in a region organised by largest population to smallest",
            "All the cities in a country organised by largest population to smallest",
            "All the cities in a district organised by largest population to smallest",
            "The top N populated cities in the world where N is provided by the user",
            "The top N populated cities in a continent where N is provided by the user",
            "The top N populated cities in a region where N is provided by the user",
            "The top N populated cities in a country where N is provided by the user",
            "The top N populated cities in a district where N is provided by the user",
            "All the capital cities in the world organised by largest population to smallest",
            "All the capital cities in a continent organised by largest population to smallest",
            "All the capital cities in a region organised by largest to smallest",
            "The top N populated capital cities in the world where N is provided by the user",
            "The top N populated capital cities in a continent where N is provided by the user",
            "The top N populated capital cities in a region where N is provided by the user",
            "The population of people, people living in cities, and people not living in cities in each continent",
            "The population of people, people living in cities, and people not living in cities in each region",
            "The population of people, people living in cities, and people not living in cities in each country"
    };


    /** Get single report title from array
     *
     * @param reportNumber Number shown to user, not reports index in array
     * @return reports Title of report
     */
    public String getReports(int reportNumber) {
        return reports[reportNumber - 1];
    }

    /** Display country reports
     *
     * @param countries list of countries
     */
    public void displayCountryReports(List<Country> countries){
        // Display countries
        for(Country c : countries){
            System.out.println(c.toString());
        }
    }

    /** Display city reports
     *
     * @param cities list of countries
     */
    public void displayCityReports(List<City> cities){
        // Display city
        for(City c : cities){
            System.out.println(c.toString());
        }
    }

    /** Display Capital city reports
     *
     * @param capitalCities list of countries
     */
    public void displayCapitalCityReports(List<CapitalCity> capitalCities){
        // Display capital city
        for(CapitalCity c : capitalCities){
            System.out.println(c.toString());
        }
    }
    /**
     * Outputs City Report as Markdown file in folder
     *
     * @param cities list of cities
     * @param filename name of Markdown file
     */
    public void outputCityReport(List<City> cities, String filename){

        // If countries is null, return
        if (cities == null){
            System.out.println("No Cities");
            return;
        }

        // If the file name does end with .md, add
        if (!filename.endsWith(".md")){
            filename += ".md";
        }

        //New String builder
        StringBuilder sb = new StringBuilder();

        // Print header
        sb.append("| Name | Country | District | Population | \r\n");
        sb.append("| --- | --- | --- | --- |\r\n");

        // Loop the through countries in the list and add to string builder
        for (City c : cities){
            if(c == null) continue;
            sb.append("| " + c.getName() + " | " + c.getCountry() +  " | " + c.getDistrict() + " | " + c.getPopulation() + " |\r\n");
        }
        try {
            // Create new folder
            new File("./reports/").mkdir();
            // Create new file
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));
            // Add
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Outputs Country Report as Markdown file in folder
     *
     * @param countries list of countries
     * @param filename name of Markdown file
     */
    public void outputCountryReport(List<Country> countries, String filename){

        // If countries is null, return
        if (countries == null){
            System.out.println("No Countries");
            return;
        }

        // If the file name does end with .md, add
        if (!filename.endsWith(".md")){
            filename += ".md";
        }

        //New String builder
        StringBuilder sb = new StringBuilder();

        // Print header
        sb.append("| Code | Name | Continent | Region | Population | Capital | \r\n");
        sb.append("| --- | --- | --- | --- | --- | --- |\r\n");

        // Loop the through countries in the list and add to string builder
        for (Country c : countries){
            if(c == null) continue;
            sb.append("| " + c.getCode() + " | " + c.getName() +  " | " + c.getContinent() + " | " + c.getRegion() + " | " + c.getPopulation() + " |\r\n");
        }
        try {
            // Create new folder
            new File("./reports/").mkdir();
            // Create new file
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));
            // Add
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Display Population reports
     *
     * @param reports list for population reports
     */
    public void displayPopulationReports(List<PopulationReport> reports) {
        if (reports == null || reports.isEmpty()) {
            System.out.println("No population report data found.");
            return;
        }

        for (PopulationReport report : reports) {
            System.out.println(report);
        }
    }


    /**
     * Outputs Capital Cities Report as Markdown file in folder
     *
     * @param capitalCities list of countries
     * @param filename name of Markdown file
     */
    public void outputCapitalCityReport(List<CapitalCity> capitalCities, String filename){

        // If countries is null, return
        if (capitalCities == null){
            System.out.println("No Capital Cities");
            return;
        }

        // If the file name does end with .md, add
        if (!filename.endsWith(".md")){
            filename += ".md";
        }

        //New String builder
        StringBuilder sb = new StringBuilder();

        // Print header
        sb.append("| Name | Country | Population |\r\n");
        sb.append("| --- | --- | --- |\r\n");

        // Loop the through countries in the list and add to string builder
        for (CapitalCity c : capitalCities){
            if(c == null) continue;
            sb.append("| " + c.getName() + " | " + c.getCountry() +  c.getPopulation() + " |\r\n");
        }
        try {
            // Create new folder
            new File("./reports/").mkdir();
            // Create new file
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));
            // Add
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    //Country Reports

    // Issue 7
    // All the countries in the world organised by largest population to smallest (Report 1)
    public List<Country> getAllCountries(CountryConnection countryConnect){
        //Print Report Title
        System.out.println("All the countries in the world organised by largest population to smallest");
        // Run database query to get all countries
        return countryConnect.runCountryQuery(CountryQueries.ALL_COUNTRIES);
    }

    // Issue 8
    // All the countries in a continent organised by largest population to smallest (Report 2)
    public List<Country> getCountriesByContinent(CountryConnection countryConnect, String continent){

        List<Country> result;

        // Check if continent is valid
        Boolean validContinent = userInput.getValidContinent(continent);

        // If not return empty array
        if(!validContinent){
            result = new ArrayList<>();
        } else {// Print Report Title
            System.out.println("All the countries in " + continent + " organised by largest population to smallest");// Run database query to get countries as continents
            result = countryConnect.runCountryQuery(CountryQueries.COUNTRIES_BY_CONTINENT, continent);
        }

        return result;
    }

    // Issue 9
    // All the countries in a region organised by largest population to smallest (Report 3)
    public List<Country> getCountriesByRegion(CountryConnection countryConnect, String region){
        // Check if region is valid
        Boolean validRegion = userInput.getValidRegion(region);

        // If not return empty array
        if(!validRegion){
            return new ArrayList<>();
        }
        // Print Report Title
        System.out.println("All the countries in " + region + " organised by largest population to smallest");

        // Run database query to get countries as region
        return countryConnect.runCountryQuery(CountryQueries.COUNTRIES_BY_REGION, region);
    }

    //Issue 10
    //The top N populated countries in the world (Report 4)
    public List<Country> getNCountriesInWorld(CountryConnection countryConnect, int n){

        // Check if n is greater than 1
        if (n < 1){
            return new ArrayList<>();
        }

        // Print report name
        System.out.println("Top " + n + " populated countries in the world");

        // Run database query to get countries as region
        return countryConnect.runCountryQuery(CountryQueries.N_COUNTRIES, n);

    }

    //Issue 11
    // The top N populated countries in a continent (Report 5)
    public List<Country> getNCountriesInContinent(CountryConnection countryConnect, String continent, int n){

        // Check if n is greater than 1 and continent is not blank/null
        if (n < 1 || continent == null || continent.isBlank()){
            return new ArrayList<>();
        }

        // Check if continent is valid
        Boolean validContinent = userInput.getValidContinent(continent);

        // If not return empty array
        if(!validContinent){
            return new ArrayList<>();
        }

        // Print report name
        System.out.println("Top " + n + " populated countries in " + continent);

        // Run database query to get countries as continent
        return countryConnect.runCountryQuery(CountryQueries.N_COUNTRIES_BY_CONTINENT, continent, n);

    }

    // Issue 12
    //The top N populated countries in a region (Report 6)
    public List<Country> getNCountriesInRegion(CountryConnection countryConnect, String region, int n){

        // Check if n is greater than 1 and continent is not blank/null
        if (n < 1 || region == null || region.isBlank()){
            return new ArrayList<>();
        }

        // Check if continent is valid
        Boolean validRegion = userInput.getValidRegion(region);

        // If not return empty array
        if(!validRegion){
            return new ArrayList<>();
        }

        // Print report name
        System.out.println("Top " + n + " populated countries in " + region);

        // Run database query n countries in a region
        return countryConnect.runCountryQuery(CountryQueries.N_COUNTRIES_BY_REGION, region, n);

    }


    //City Reports

    // Issue 13
    // All the cities in the world organised by largest population to smallest. (Report 7)
    public List<City> getAllCities(CityConnection cityConnect) {

        //Print Report Title
        System.out.println("Report 7: All the cities in the world organised by largest population to smallest");
        // Get all cities
        return cityConnect.runCityQuery(CityQueries.ALL_CITIES);

    }

    // Issue 14
    // All the cities in a continent organised by largest population to smallest (Report 8)
    public List<City> getAllCitiesInContinent(CityConnection cityConnect, String continent){

        // Check if continent is valid
        Boolean validContinent = userInput.getValidContinent(continent);

        // If not return empty array
        if(!validContinent){
            return new ArrayList<>();
        }

        // Print report name
        System.out.println("All the cities in " + continent + "organised by largest population to smallest");

        // Run database query to get countries in continent
        return cityConnect.runCityQuery(CityQueries.ALL_CITIES_IN_CONTINENT, continent);
    }

    // Issue 17
    // All the cities in a region organised by largest population to smallest (Report 9)
    public List<City> getAllCitiesInRegion(CityConnection cityConnect, String region){
        // Check if region is valid
        Boolean validRegion = userInput.getValidRegion(region);

        // If not return empty array
        if(!validRegion){
            return new ArrayList<>();
        }

        // Print report name
        System.out.println("All the cities in " + region + "organised by largest population to smallest");

        // Run database query to get countries in region
        return cityConnect.runCityQuery(CityQueries.ALL_CITIES_IN_REGION, region);
    }

    // Issue 15
    // All the cities in a country organised by largest population to smallest (Report 10)
    public List<City> getAllCitiesInCountry(CityConnection cityConnect, String country){


        //Safety check added to prevent crashes on invalid input
        if (country == null || country.isBlank()) {
            return new ArrayList<>();
        }

        // Check if country is valid
        Boolean validCountry = userInput.getValidCountry(country);

        // If invalid return empty list
        if(!validCountry){
            return  new ArrayList<>();
        }

        // Print report name
        System.out.println("All the cities in " + country + " organised by largest population to smallest");

        // Run database query to get cities by country
        return cityConnect.runCityQuery(CityQueries.ALL_CITIES_IN_COUNTRY, country);

    }

    /*
        Issue 16
        Report 11
        All the cities in a district organised by largest population to smallest
     */
    public List<City> getAllCitiesInDistrict(CityConnection cityConnect, String district){

        //Safety check added to prevent crashes on invalid input
        if (district == null || district.isBlank()) {
            return new ArrayList<>();
        }

        // Print report name
        System.out.println("All the cities in " + district + " organised by largest population to smallest");

        // Run database query to get cities by country
        return cityConnect.runCityQuery(CityQueries.ALL_CITIES_IN_DISTRICT, district);

    }

    /*
    Issue 18
    Report 12
    The top N populated cities in the world where N is provided by the user
    */
    public List<City> getNCitiesInWorld(CityConnection cityConnect, int n){
        // Check if n is greater than 1
        if (n < 1){
            return new ArrayList<>();
        }

        // Print report name
        System.out.println(n + " cities in the world organised by largest population to smallest");

        // Run database query to get cities by country
        return cityConnect.runCityQuery(CityQueries.N_CITIES_IN_WORLD, n);

    }

    /*
    Issue 19
    Report 13
    The top N populated cities in a continent where N is provided by the user
    */
    public List<City> getNCitiesInContinent(CityConnection cityConnect, String continent, int n){
        // Check if n is greater than 1
        if (n < 1){
            return new ArrayList<>();
        }

        // Check if continent is valid
        Boolean validContinent = userInput.getValidContinent(continent);

        // If not return empty array
        if(!validContinent){
            return new ArrayList<>();
        }

        // Print report name
        System.out.println(n + " cities in " + continent + " organised by largest population to smallest");

        // Run database query to get cities by country
        return cityConnect.runCityQuery(CityQueries.N_CITIES_IN_CONTINENT, continent, n);

    }

    // Issue 20
    //The top N populated cities in a region where N is provided by the user (Report 14)
    public List<City> getNCitiesInRegion(CityConnection cityConnect, String region, int n){
        // Check if region is valid
        Boolean validRegion = userInput.getValidRegion(region);

        // If not return empty array
        if(!validRegion){
            return new ArrayList<>();
        }

        // Check if n is greater than 1
        if (n < 1){
            return new ArrayList<>();
        }

        // Print report name
        System.out.println(n + " cities in " + region + " organised by largest population to smallest");

        // Run database query to get cities by country
        return cityConnect.runCityQuery(CityQueries.N_CITIES_IN_REGION, region, n);

    }

    /*
    Issue 21
    Report 15
    The top N populated cities in a country where N is provided by the user
    */
    public List<City> getNCitiesInCountry(CityConnection cityConnect, String country, int n){
        // Check if n is greater than 1
        if (n < 1){
            return new ArrayList<>();
        }

        //Safety check added to prevent crashes on invalid input
        if (country == null || country.isBlank()) {
            return new ArrayList<>();
        }

        // Check if country is valid
        Boolean validCountry = userInput.getValidCountry(country);

        // If invalid return empty list
        if(!validCountry){
            return  new ArrayList<>();
        }

        // Print report name
        System.out.println(n + " cities in " + country + " organised by largest population to smallest");

        // Run database query to get cities by country
        return cityConnect.runCityQuery(CityQueries.N_CITIES_IN_COUNTRY, country, n);
    }

    /*
    Issue 22
    Report 16
    The top N populated cities in a district where N is provided by the user
    */
    public List<City> getNCitiesInDistrict(CityConnection cityConnect, String district, int n){
        // Check if n is greater than 1
        if (n < 1){
            return new ArrayList<>();
        }

        //Safety check added to prevent crashes on invalid input
        if (district == null || district.isBlank()) {
            return new ArrayList<>();
        }

        // Print report name
        System.out.println(n + " cities in " + district + " organised by largest population to smallest");

        // Run database query to get cities by country
        return cityConnect.runCityQuery(CityQueries.N_CITIES_IN_DISTRICT, district, n);
    }

    // Capital City Reports

    // Issue 24
    // All the capital cities in a continent organised by largest population to smallest (Report 18)
    public List<CapitalCity> getCapitalsByContinent(CapitalCityConnection capitalCityConnect, String continent) {

        // Check if continent is valid
        Boolean validContinent = userInput.getValidContinent(continent);

        // If not return empty array
        if(!validContinent){
            return new ArrayList<>();
        }

        //Print Report Title
        System.out.println("All capital Cities in " + continent + ":");

        // Get all capital cities in a continent
        return capitalCityConnect.runCapitalCityQuery(CapitalCityQueries.CAPITALS_BY_CONTINENT, continent);

    }

    // Issue 27
    // The top N populated capital cities in the world where N is provided by the user (Report 20)
    public List<CapitalCity> getTopNCapitalsWorld(CapitalCityConnection capitalCityConnect, int n) {
        // Check if n is greater than 1
        if (n < 1){
            return new ArrayList<>();
        }

        // Print Report Title
        System.out.println("Top " + n + " Capital Cities in the World:");

        // Get Capital Cities
        return capitalCityConnect.runCapitalCityQuery(CapitalCityQueries.TOP_N_CAPITALS_WORLD, n);

    }

    // Issue 26
    // The top N populated capital cities in a continent where N is provided by the user (Report 21)
    public List<CapitalCity> getTopNCapitalsByContinent(CapitalCityConnection capitalCityConnect, String continent, int n) {
        // Check if n is greater than 1
        if (n < 1){
            return new ArrayList<>();
        }
        // Check if continent is valid
        Boolean validContinent = userInput.getValidContinent(continent);

        // If not return empty array
        if(!validContinent){
            return new ArrayList<>();
        }

        // Print Report Title
        System.out.println("Top " + n + " Capital Cities in " + continent + ":");

        // Get Capital Cities
        return  capitalCityConnect.runCapitalCityQuery(CapitalCityQueries.TOP_N_CAPITALS_BY_CONTINENT, continent, n);
    }

    // Issue 25
    //The top N populated capital cities in a region where N is provided by the user (Report 22)
    public List<CapitalCity> getTopNCapitalsByRegion(CapitalCityConnection capitalCityConnect, String region, int n) {
        // Check if n is greater than 1
        if (n < 1){
            return new ArrayList<>();
        }

        // Check if region is valid
        Boolean validRegion = userInput.getValidRegion(region);

        // If not return empty array
        if(!validRegion){
            return new ArrayList<>();
        }

        // Print Report Title
        System.out.println("Top " + n + " Capital Cities in " + region + ":");
        // Get Capital Cities
       return capitalCityConnect.runCapitalCityQuery(CapitalCityQueries.TOP_N_CAPITALS_BY_REGION, region, n);

    }

    // Issue 31
    // The population of a country (Report 27)
    public List<PopulationReport> getTotalPopulationByContinent(PopulationReportConnection connection) {
        return connection == null ? new ArrayList<>() : connection.run(PopulationReportQueries.TOTAL_BY_CONTINENT);
    }

    // Issue 32
    // Population by region (Report 28)
    public List<PopulationReport> getPopulationByRegion(
            PopulationReportConnection connection, String region) {

        if (connection == null || region == null || region.isBlank()) {
            return new ArrayList<>();
        }

        if (!userInput.getValidRegion(region)) {
            return new ArrayList<>();
        }

        return connection.run(PopulationReportQueries.BY_REGION, region);
    }

    // Issue 33
    // Population by country (Issue #25)
    public List<PopulationReport> getPopulationByCountry(
            PopulationReportConnection connection, String country) {

        if (connection == null || country == null || country.isBlank()) {
            return new ArrayList<>();
        }

        return connection.run(PopulationReportQueries.BY_COUNTRY, country);
    }

    // Issue #28
    public List<PopulationReport> getPopulationDistributionByContinent(PopulationReportConnection connection) {
        return connection == null ? new ArrayList<>() : connection.run(PopulationReportQueries.DISTRIBUTION_BY_CONTINENT);
    }

    // Issue #29
    public List<PopulationReport> getPopulationDistributionByRegion(PopulationReportConnection connection) {
        return connection == null ? new ArrayList<>() : connection.run(PopulationReportQueries.DISTRIBUTION_BY_REGION);
    }

    // Issue #30
    public List<PopulationReport> getPopulationDistributionByCountry(PopulationReportConnection connection) {
        return connection == null ? new ArrayList<>() : connection.run(PopulationReportQueries.DISTRIBUTION_BY_COUNTRY);
    }

    // Issue #32
    public List<PopulationReport> getTotalPopulationByRegion(PopulationReportConnection connection) {
        return connection == null ? new ArrayList<>() : connection.run(PopulationReportQueries.TOTAL_BY_REGION);
    }

    // Issue #33
    public List<PopulationReport> getTotalPopulationByCountry(PopulationReportConnection connection) {
        return connection == null ? new ArrayList<>() : connection.run(PopulationReportQueries.TOTAL_BY_COUNTRY);
    }

}
