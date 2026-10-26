package com.napier.sem;

import java.util.List;

public class Reports {

    private static final String[] reports  = {
            "All the countries in the world organised by largest population to smallest",
            "All the countries in a continent organised by largest population to smallest",
            "All the countries in a region organised by largest population to smallest"
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

    //City Reports

    //public void printAllCities(CityConnection cityConnect) {
    // List<CapitalCity> cities = cityConnect.runCityQuery(CapitalCityQueries.ALL_CITIES);
    // System.out.println("City Report:");
    // for (CapitalCity c : cities) {
    //     System.out.println(c.getName() + ", " + c.getCountry() + " (" + c.getPopulation() + ")");
    // }
    //   }

    //public void printCapitalsByContinent(CityConnection cityConnect, String continent) {

    // List<CapitalCity> cities = cityConnect.runCityQuery(CapitalCityQueries.CAPITALS_BY_CONTINENT, continent);

    // System.out.println("Capital Cities in " + continent + ":");

    // Print Cities
    //  for (CapitalCity c : cities) {
    // System.out.println(c.toString());
    // }
    //  }

    // Capital City Reports

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