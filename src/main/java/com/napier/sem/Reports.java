package com.napier.sem;

import java.util.List;

public class Reports {
    private final Continents continents = new Continents();
    private final Regions regions = new Regions();
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

;

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

    /** Get single report title from array
     *
     * @param prompt text shown to user
     */
    public void displayReports(String prompt){
        System.out.println(prompt);
        for (int i = 0; i < reports.length; i++){
            System.out.println((i + 1) + ". " + reports[i]);
        }
    }

    //Country Reports

    // All the countries in the world organised by largest population to smallest (Report 1)
    public void printAllCountries(CountryConnection countryConnect){
        // Run database query to get all countries
        List<Country> countries = countryConnect.runCountryQuery(CountryQueries.ALL_COUNTRIES);

        //Print Report Title
        System.out.println("All the countries in the world organised by largest population to smallest");

        // Display countries
        for(Country c : countries){
            System.out.println(c.toString());
        }
    }

    // All the countries in a continent organised by largest population to smallest (Report 2)
    public void printCountriesByContinent(CountryConnection countryConnect){
        // Get user section of continent as int
        int continentNumber = 2;
        // Get continent from array
        String continent = continents.getContinent(continentNumber);

        //Print Report Title
        System.out.println("All the countries in " + continent + " organised by largest population to smallest");

        // Run database query to get countries as continents
        List<Country> countries = countryConnect.runCountryQuery(CountryQueries.COUNTRIES_BY_CONTINENT, continent);

        // Display countries
        for(Country c : countries){
            System.out.println(c.toString());
        }
    }

    // All the countries in a region organised by largest population to smallest (Report 3)
    public void printCountriesByRegion(CountryConnection countryConnect){
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

    public void printNCountriesInWorld(CountryConnection countryConnect){
        int numberOfCountries = 10;
        // Print report name
        System.out.println("Top " + numberOfCountries + " populated countries in the world");

        // Run database query to get countries as region
        List<Country> countries = countryConnect.runCountryQuery(CountryQueries.N_COUNTRIES, numberOfCountries);

        // Display countries
        for(Country c : countries){
            System.out.println(c.toString());
        }
    }
    public void printNCountriesInContinent(CountryConnection countryConnect){
        int numberOfCountries = 10;
        int continentNumber = 5;

        // Get continent selection from array
        String continent = continents.getContinent(continentNumber);

        // Print report name
        System.out.println("Top " + numberOfCountries + " populated countries in " + continent);

        // Run database query to get countries as region
        List<Country> countries = countryConnect.runCountryQuery(CountryQueries.N_COUNTRIES_BY_CONTINENT, continent, numberOfCountries);

        // Display countries
        for(Country c : countries){
            System.out.println(c.toString());
        }
    }

    //City Reports

    // All the cities in the world organised by largest population to smallest. (Report 7)
    public void printAllCities(CityConnection cityConnect) {

        // Get all cities
        List<City> cities = cityConnect.runCityQuery(CityQueries.ALL_CITIES);

        //Print Report Title
        System.out.println("Report 7: All the cities in the world organised by largest population to smallest");

        //Print Report
        for (City c : cities) {
            System.out.println(c.toString());
        }
    }

    // Capital City Reports

    // All the capital cities in a continent organised by largest population to smallest (Report 18)
    public void printCapitalsByContinent(CapitalCityConnection capitalCityConnect, String continent) {

        // Get all capital cities in a continent
        List<CapitalCity> cities = capitalCityConnect.runCapitalCityQuery(CapitalCityQueries.CAPITALS_BY_CONTINENT, continent);

        //Print Report Title
        System.out.println("Capital Cities in " + continent + ":");

        // Print Capital Cities report
        for (CapitalCity c : cities) {
            System.out.println(c.toString());
        }
    }


    // The top N populated capital cities in the world where N is provided by the user (Report 20)
    public void printTopNCapitalsWorld(CapitalCityConnection capitalCityConnect, int n) {
        // Get Capital Cities
        List<CapitalCity> cities = capitalCityConnect.runCapitalCityQuery(CapitalCityQueries.TOP_N_CAPITALS_WORLD, n);

        // Print Report Title
        System.out.println("Top " + n + " Capital Cities in the World:");

        //Print Report
        for (CapitalCity c : cities) {
            System.out.println(c.toString());
        }
    }

    // The top N populated capital cities in a continent where N is provided by the user (Report 21)
    public void printTopNCapitalsByContinent(CapitalCityConnection capitalCityConnect, String continent, int n) {
        // Get Capital Cities
        List<CapitalCity> cities = capitalCityConnect.runCapitalCityQuery(CapitalCityQueries.TOP_N_CAPITALS_BY_CONTINENT, continent, n);

        // Print Report Title
        System.out.println("Top " + n + " Capital Cities in " + continent + ":");

        // Print Cities
        for (CapitalCity c : cities) {
            System.out.println(c.toString());
        }
    }
    //The top N populated capital cities in a region where N is provided by the user (Report 22)
    public void printTopNCapitalsByRegion(CapitalCityConnection capitalCityConnect, String region, int n) {
        // Get Capital Cities
        List<CapitalCity> cities = capitalCityConnect.runCapitalCityQuery(CapitalCityQueries.TOP_N_CAPITALS_BY_REGION, region, n);

        // Print Report Title
        System.out.println("Top " + n + " Capital Cities in " + region + ":");

        //Print Report
        for (CapitalCity c : cities) {
            System.out.println(c.toString());
        }
    }
}