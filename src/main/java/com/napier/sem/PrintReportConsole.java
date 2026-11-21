package com.napier.sem;

import java.util.List;

public class PrintReportConsole {

    /** Display country reports
     *
     * @param countries list of countries
     */
    public void displayCountryReports(List<Country> countries){

        // If null, or empty return
        if (countries == null || countries.isEmpty()) {
            System.out.println("No population report data found.");
            return;
        }

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

        // If null, or empty return
        if (cities == null || cities.isEmpty()) {
            System.out.println("No population report data found.");
            return;
        }

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
     * Display language population reports
     *
     * @param languages list of languages
     */
    public void displayLanguageReports(List<Language> languages) {

        // If null, or empty return
        if (languages == null || languages.isEmpty()) {
            System.out.println("No language population report data found.");
            return;
        }

        // Display languages
        for (Language language : languages) {
            System.out.println(language.toString());
        }
    }
}
