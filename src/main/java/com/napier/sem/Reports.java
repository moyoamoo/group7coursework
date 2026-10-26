package com.napier.sem;

import java.util.List;

public class Reports {
    private static final String[] reports  = {"All the countries in the world organised by largest population to smallest",
                                                "All the countries in a continent organised by largest population to smallest",
                                "All the countries in a region organised by largest population to smallest"};


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
    //CITY REPORTS (Khadijah)

    public void printAllCities(CityConnection cityConnect) {
        List<City> cities = cityConnect.runCityQuery(CityQueries.ALL_CITIES);
        System.out.println("City Report:");
        for (City c : cities) {
            System.out.println(c.getName() + ", " + c.getCountry() + " (" + c.getPopulation() + ")");
        }
    }

    public void printTopNCapitalsWorld(CityConnection cityConnect, int n) {
        List<City> cities = cityConnect.runCityQuery(CityQueries.TOP_N_CAPITALS_WORLD, n);
        System.out.println("Top " + n + " Capital Cities in the World:");
        for (City c : cities) {
            System.out.println(c.getName() + ", " + c.getCountry() + " (" + c.getPopulation() + ")");
        }
    }

    public void printCapitalsByContinent(CityConnection cityConnect, String continent) {
        List<City> cities = cityConnect.runCityQuery(CityQueries.CAPITALS_BY_CONTINENT, continent);
        System.out.println("Capital Cities in " + continent + ":");
        for (City c : cities) {
            System.out.println(c.getName() + ", " + c.getCountry() + " (" + c.getPopulation() + ")");
        }
    }

    public void printTopNCapitalsByContinent(CityConnection cityConnect, String continent, int n) {
        List<City> cities = cityConnect.runCityQuery(CityQueries.TOP_N_CAPITALS_BY_CONTINENT, continent, n);
        System.out.println("Top " + n + " Capital Cities in " + continent + ":");
        for (City c : cities) {
            System.out.println(c.getName() + ", " + c.getCountry() + " (" + c.getPopulation() + ")");
        }
    }

    public void printTopNCapitalsByRegion(CityConnection cityConnect, String region, int n) {
        List<City> cities = cityConnect.runCityQuery(CityQueries.TOP_N_CAPITALS_BY_REGION, region, n);
        System.out.println("Top " + n + " Capital Cities in " + region + ":");
        for (City c : cities) {
            System.out.println(c.getName() + ", " + c.getCountry() + " (" + c.getPopulation() + ")");
        }
    }
}
