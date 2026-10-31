package com.napier.sem;

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


   /** Get copy of reports array
     *
     * @return returns copy of reports array
     */
    public String[] getReports() {
        return reports.clone();
    }

    /** Get reports array length
     *
     * @return returns length
     */
    public int count() {
        return reports.length;
    }

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


    //Country Reports

    // All the countries in the world organised by largest population to smallest (Report 1)
    public List<Country> getAllCountries(CountryConnection countryConnect){
        //Print Report Title
        System.out.println("All the countries in the world organised by largest population to smallest");
        // Run database query to get all countries
        return countryConnect.runCountryQuery(CountryQueries.ALL_COUNTRIES);
    }

    // All the countries in a continent organised by largest population to smallest (Report 2)
    public List<Country> getCountriesByContinent(CountryConnection countryConnect, String continent){

        // Check if continent is valid
        Boolean validContinent = userInput.getValidContinent(continent);

        // If not return empty array
        if(!validContinent){
            return new ArrayList<>();
        }

        // Print Report Title
        System.out.println("All the countries in " + continent + " organised by largest population to smallest");

        // Run database query to get countries as continents
        return countryConnect.runCountryQuery(CountryQueries.COUNTRIES_BY_CONTINENT, continent);
    }

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

    //The top N populated countries in a continent (Report 5)
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

        // Run database query to get n countries in a  continent
        // Run database query to get countries as continent
        return countryConnect.runCountryQuery(CountryQueries.N_COUNTRIES_BY_CONTINENT, continent, n);

    }

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

    // The top N populated countries in a region (Report 6)
    public List<Country> getNCountriesInRegion(CountryConnection countryConnect, String region, int n){

        if(n <= 0 || !userInput.getValidRegion(region)){
            return new ArrayList<>();
        }
        // Print report name
        System.out.println("Top " + n + " populated countries in " + region);

        // Run database query to get countries by region
        return countryConnect.runCountryQuery(CountryQueries.N_COUNTRIES_BY_REGION, region, n);

    }

    //City Reports

    // All the cities in the world organised by largest population to smallest. (Report 7)
    public List<City> getAllCities(CityConnection cityConnect) {

        //Print Report Title
        System.out.println("Report 7: All the cities in the world organised by largest population to smallest");
        // Get all cities
        return cityConnect.runCityQuery(CityQueries.ALL_CITIES);

    }

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

        // Run database query to get countries as region
        return cityConnect.runCityQuery(CityQueries.ALL_CITIES_IN_CONTINENT, continent);
    }

    // All the cities in a country organised by largest population to smallest (Report 10)
    public List<City> getAllCitiesInCountry(CityConnection cityConnect, String country){


        //Safety check added to prevent crashes on invalid input
        if (country == null || country.equals("XYZ")) {
            return new ArrayList<>();
        }
        // Print report name
        System.out.println("All the cities in " + country + " organised by largest population to smallest");

        // Run database query to get cities by country
        return cityConnect.runCityQuery(CityQueries.ALL_CITIES_IN_COUNTRY, country);

    }

    //The top N populated cities in a region where N is provided by the user (Report 14)
    public List<City> getNCitiesInRegion(CityConnection cityConnect, String region, int n){
        // Check if region is valid
        Boolean validRegion = userInput.getValidRegion(region);

        // If not return empty array
        if(!validRegion){
            return new ArrayList<>();
        }

        // Print report name
        System.out.println("All the cities in " + region + " organised by largest population to smallest");

        // Run database query to get cities by country
        return cityConnect.runCityQuery(CityQueries.ALL_CITIES_IN_REGION, region, n);

    }
    // Capital City Reports

    // All the capital cities in a continent organised by largest population to smallest (Report 18)
    public List<CapitalCity> getCapitalsByContinent(CapitalCityConnection capitalCityConnect, String continent) {

        //Print Report Title
        System.out.println("All capital Cities in " + continent + ":");

        // Get all capital cities in a continent
        return capitalCityConnect.runCapitalCityQuery(CapitalCityQueries.CAPITALS_BY_CONTINENT, continent);

    }


    // The top N populated capital cities in the world where N is provided by the user (Report 20)
    public List<CapitalCity> getTopNCapitalsWorld(CapitalCityConnection capitalCityConnect, int n) {
        // Print Report Title
        System.out.println("Top " + n + " Capital Cities in the World:");

        // Get Capital Cities
        return capitalCityConnect.runCapitalCityQuery(CapitalCityQueries.TOP_N_CAPITALS_WORLD, n);

    }

    // The top N populated capital cities in a continent where N is provided by the user (Report 21)
    public List<CapitalCity> getTopNCapitalsByContinent(CapitalCityConnection capitalCityConnect, String continent, int n) {

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

    //The top N populated capital cities in a region where N is provided by the user (Report 22)
    public List<CapitalCity> getTopNCapitalsByRegion(CapitalCityConnection capitalCityConnect, String region, int n) {
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
}
