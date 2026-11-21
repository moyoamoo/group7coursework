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
    // Population Reports

    /*
     Issue 28
     Report 23
     The population of people, people living in cities, and people not living in cities in each continent
     */
    public List<PopulationReport> getPopulationDistributionByContinent(PopulationReportConnection connection) {
        return connection == null ? new ArrayList<>() : connection.run(PopulationReportQueries.DISTRIBUTION_BY_CONTINENT);
    }

    /*
    Issue 29
    Report 24
    The population of people, people living in cities, and people not living in cities in each region
    */
    public List<PopulationReport> getPopulationDistributionByRegion(PopulationReportConnection connection) {
        return connection == null ? new ArrayList<>() : connection.run(PopulationReportQueries.DISTRIBUTION_BY_REGION);
    }

    /* Issue 30
       The population of people, people living in cities, and people not living in cities in each country (Report 25)
    */
    public List<PopulationReport> getPopulationDistributionByCountry(PopulationReportConnection connection) {
        return connection == null ? new ArrayList<>() : connection.run(PopulationReportQueries.DISTRIBUTION_BY_COUNTRY);
    }

    /* Issue 31
       The population of a continent (Report 27) */
    public List<PopulationReport> getPopulationByContinent(PopulationReportConnection connection, String continent) {

        // Check for invalid parameters
        if (connection == null || continent == null || continent.isBlank()) {
            return new ArrayList<>();
        }

        // Check if continent is valid
        Boolean validContinent = userInput.getValidContinent(continent);

        // If not return empty array
        if(!validContinent){
            return new ArrayList<>();
        }

        // Print Report Title
        System.out.println("Total population of " + continent);

        // Return information for report from world db
        return connection.run(PopulationReportQueries.POPULATION_BY_CONTINENT, continent);
    }


    /* Issue 32
    The population of a region (Report 28) */
    public List<PopulationReport> getPopulationByRegion(PopulationReportConnection connection, String region) {

        // Check for invalid parameters
        if (connection == null || region == null || region.isBlank()) {
            return new ArrayList<>();
        }

        // Check if region is valid
        Boolean validRegion = userInput.getValidRegion(region);

        // If not return empty array
        if(!validRegion){
            return new ArrayList<>();
        }

        // Print Report Title
        System.out.println("Total population of " + region);

        // Return information for report from world db
        return connection.run(PopulationReportQueries.POPULATION_BY_REGION, region);
    }

    /* Issue 33
       The population of a country (Report 29) */
    public List<PopulationReport> getPopulationByCountry(PopulationReportConnection connection, String country) {

        // Check for invalid parameters
        if (connection == null || country == null || country.isBlank()) {
            return new ArrayList<>();
        }

        // Check if country is valid
        Boolean validCountry = userInput.getValidCountry(country);

        // If not return empty array
        if(!validCountry){
            return new ArrayList<>();
        }

        // Print Report Title
        System.out.println("Total population of " + country);

        return connection.run(PopulationReportQueries.POPULATION_BY_COUNTRY, country);
    }

    /** Issue 34
       The population of a district (Report 30) */
    public List<PopulationReport> getPopulationByDistrict(PopulationReportConnection connection, String district) {

        // Check for invalid parameters
        if (connection == null || district == null || district.isBlank()) {
            return new ArrayList<>();
        }

        // Print Report Title
        System.out.println("Total population of " + district);

        return connection.run(PopulationReportQueries.POPULATION_BY_DISTRICT, district);
    }


    /** Issue 35
       The population of a city (Report 31) */
    public List<PopulationReport> getPopulationByCity(PopulationReportConnection connection, String city) {

        // Check for invalid parameters
        if (connection == null || city == null || city.isBlank()) {
            return new ArrayList<>();
        }

        // Print Report Title
        System.out.println("Total population of " + city);

        return connection.run(PopulationReportQueries.POPULATION_BY_CITY, city);
    }


      /** Issue 36
       The number of people who speak Chinese, English, Hindi,
       Spanish, Arabic from greatest number to smallest,
       including the percentage of the world population  (Report 32) */
      public List<Language> getPopulationByLanguage(LanguageConnection connection) {

          // Check for invalid parameters
          if (connection == null) {
              return new ArrayList<>();
          }

          // Print Report Title
          System.out.println("The number of people who speak Chinese, English, Hindi,\n" +
                  "       Spanish, Arabic from greatest number to smallest,\n" +
                  "       including the percentage of the world population");

          return connection.runLanguageQuery(PopulationReportQueries.POPULATION_BY_LANGUAGE);
      }


}
