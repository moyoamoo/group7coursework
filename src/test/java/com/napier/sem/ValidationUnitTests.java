package com.napier.sem;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationUnitTests {
    Reports reports = new Reports();
    PrintReportConsole consoleReports = new PrintReportConsole();

    CountryConnection dummyCountryConnect = null;
    CityConnection dummyCityConnect = null;
    CapitalCityConnection dummyCapitalConnection = null;

    //report 2
    // Test that invalid continents return empty list
    @Test
    void report2InvalidContinentsReturnEmpty(){
        List<Country> result = reports.getCountriesByContinent(dummyCountryConnect, "Earthsea");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }

    // Test that null continents return empty list
    @Test
    void report2NullContinentReturnsEmpty(){
        List<Country> result = reports.getCountriesByContinent(dummyCountryConnect, null);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null continent");

    }
    //report 3
    // Test that invalid region return empty list
    @Test
    void report3InvalidRegionReturnEmpty(){
        List<Country> result = reports.getCountriesByRegion(dummyCountryConnect, "Gotham");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid region");
    }

    // Test that null region return empty list
    @Test
    void report3NullRegionReturnsEmpty(){
        List<Country> result = reports.getCountriesByRegion(dummyCountryConnect, null);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null region");

    }
    // report 4
    // Test that invalid n return empty list
    @Test
    void report4InvalidNReturnEmpty(){
        int n = -1;
        List<Country> result = reports.getNCountriesInWorld(dummyCountryConnect, n);
        assertTrue(result.isEmpty(), "Should return empty list for invalid n");
    }
    //report 5
    // Test that invalid n return empty list
    @Test
    void report5InvalidNReturnEmpty(){
        int n = -1;
        List<Country> result = reports.getNCountriesInContinent(dummyCountryConnect, "Spain", n);
        assertTrue(result.isEmpty(), "Should return empty list for invalid n");
    }

    // Test that null continent return empty
    @Test
    void report5NullContinentReturnEmpty(){
        int n = -1;
        List<Country> result = reports.getNCountriesInContinent(dummyCountryConnect, null, n);
        assertTrue(result.isEmpty(), "Should return empty list for invalid n");
    }
    //REPORT 6
    // UNIT TEST ISSUE 12: The top N populated countries in a region
    @Test
    void report6InvalidRegionReturnsEmpty() {
        assertTrue(reports.getNCountriesInRegion(null, "Narnia", 5).isEmpty());
    }
    
    @Test
        void report6ZeroNReturnsEmpty() {
        assertTrue(reports.getNCountriesInRegion(null, "Caribbean", 0).isEmpty());
    }

    @Test
    void report6NegativeNReturnsEmpty() {
        assertTrue(reports.getNCountriesInRegion(null, "Caribbean", -1).isEmpty());
    }

    @Test
    void displayCountryReportsEmptyList() {
       consoleReports.displayCountryReports(new ArrayList<>());
    }

    // UNIT TEST ISSUE 13: All the cities in the world, largest to smallest

    @Test
    void displayCityReportsEmptyList() {

        consoleReports.displayCityReports(new ArrayList<>());
    }

    //report 7
    @Test
    void report7TitleCorrect() {
        assertEquals("All the cities in the world organised by largest population to smallest",
        reports.getReports(7));
    }
    //report8
    //UNIT TESTS ISSUE 14: cities in a continent
    @Test
    void report8invalidContinentsReturnsEmpty() {
        List<City> result = reports.getAllCitiesInContinent(dummyCityConnect, "Narnia");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }

    @Test
    void report8NullContinentReturnsEmpty() {
        List<City> result = reports.getAllCitiesInContinent(dummyCityConnect, null);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null continent");
    }

    //UNIT TESTS ISSUE 15: cities in a country
    @Test
    void report10InvalidCountryReturnsEmpty() {
        List<City> result = reports.getAllCitiesInCountry(dummyCityConnect, "XYZ");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid country");
    }

    /*
        Issue 18
        Report 12
        The top N populated cities in the world where N is provided by the user
     */

    // Test that invalid n return empty list
    @Test
    void report12InvalidNReturnEmpty(){
        int n = -1;
        List<City> result = reports.getNCitiesInWorld(dummyCityConnect, n);
        assertTrue(result.isEmpty(), "Should return empty list for invalid n");
    }


      /*
        Issue 19
        Report 13
        The top N populated cities in a continent where N is provided by the user
     */

    // Test that invalid n return empty list
    @Test
    void report13InvalidNReturnEmpty(){
        int n = -1;
        String continent = "South America";
        List<City> result = reports.getNCitiesInContinent(dummyCityConnect, continent, n);
        assertTrue(result.isEmpty(), "Should return empty list for invalid n");
    }

    // Test that null continent return empty list
    @Test
    void report13NullContinentReturnsEmpty(){
        int n = -1;
        String continent = null;
        List<City> result = reports.getNCitiesInContinent(dummyCityConnect, continent, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null continent");

    }

    // Test that blank continent return empty list
    @Test
    void report13BlankContinentReturnsEmpty(){
        int n = -1;
        String continent = "";
        List<City> result = reports.getNCitiesInContinent(dummyCityConnect, continent, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null continent");
    }

    // Test that invalid continent return empty list
    @Test
    void report13InvalidContinentReturnsEmpty(){
        int n = -1;
        String continent = "Narnia";
        List<City> result = reports.getNCitiesInContinent(dummyCityConnect, continent, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null continent");
    }

    /*
        Issue 20
        Report 14
        The top N populated cities in a region where N is provided by the user
     */

    // Test that invalid n return empty list
    @Test
    void report14InvalidNReturnEmpty(){
        int n = -1;
        String region = "Nordic Countries";
        List<City> result = reports.getNCitiesInRegion(dummyCityConnect, region, n);
        assertTrue(result.isEmpty(), "Should return empty list for invalid n");
    }

    // Test that null region return empty list
    @Test
    void report14NullRegionReturnsEmpty(){
        int n = -1;
        String region = null;
        List<City> result = reports.getNCitiesInRegion(dummyCityConnect, region, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null region");

    }

    // Test that blank region return empty list
    @Test
    void report14BlankRegionReturnsEmpty(){
        int n = -1;
        String region = "";
        List<City> result = reports.getNCitiesInRegion(dummyCityConnect, region, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null region");
    }

    // Test that invalid region return empty list
    @Test
    void report14InvalidRegionReturnsEmpty(){
        int n = -1;
        String region = "Narnia";
        List<City> result = reports.getNCitiesInRegion(dummyCityConnect, region, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null region");
    }


    /*
        Issue 21
        Report 15
        The top N populated cities in a country where N is provided by the user.
     */

    // Test that invalid n return empty list
    @Test
    void report15InvalidNReturnEmpty(){
        int n = -1;
        String country = "France";
        List<City> result = reports.getNCitiesInCountry(dummyCityConnect, country, n);
        assertTrue(result.isEmpty(), "Should return empty list for invalid n");
    }

    // Test that null country return empty list
    @Test
    void report15NullCountryReturnsEmpty(){
        int n = -1;
        String country = null;
        List<City> result = reports.getNCitiesInCountry(dummyCityConnect, country, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null country");

    }

    // Test that blank country return empty list
    @Test
    void report15BlankCountryReturnsEmpty(){
        int n = -1;
        String country = "";
        List<City> result = reports.getNCitiesInCountry(dummyCityConnect, country, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null country");
    }

    // Test that invalid country return empty list
    @Test
    void report15InvalidCountryReturnsEmpty(){
        int n = -1;
        String country = "Narnia";
        List<City> result = reports.getNCitiesInCountry(dummyCityConnect, country, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null country");
    }

     /*
        Issue 22
        Report 16
        The top N populated cities in a district where N is provided by the user.
     */

    // Test that invalid n return empty list
    @Test
    void report16InvalidNReturnEmpty(){
        int n = -1;
        String district = "California";
        List<City> result = reports.getNCitiesInDistrict(dummyCityConnect, district, n);
        assertTrue(result.isEmpty(), "Should return empty list for invalid n");
    }

    // Test that null district return empty list
    @Test
    void report16NullDistrictReturnsEmpty(){
        int n = -1;
        String district = null;
        List<City> result = reports.getNCitiesInDistrict(dummyCityConnect, district, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null district");

    }

    // Test that blank district return empty list
    @Test
    void report15BlankDistrictReturnsEmpty(){
        int n = -1;
        String district = "";
        List<City> result = reports.getNCitiesInDistrict(dummyCityConnect, district, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null district");
    }

    // Test that invalid district return empty list
    @Test
    void report15InvalidDistrictReturnsEmpty(){
        int n = -1;
        String district = "Narnia";
        List<City> result = reports.getNCitiesInDistrict(dummyCityConnect, district, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null district");
    }

    //Report 17
    //All Capital Cities In The World
    @Test
    void report17NullConnectionReturnsEmpty(){
        List<CapitalCity> result = reports.getAllCapitals(dummyCapitalConnection);
        assertNotNull(result);
        assertTrue(result.isEmpty(),"Should return empty lists for null connection");
    }

    //report 18
    //UNIT TEST ISSUE 24: All capital  cities in  a continent
    @Test
    void report18InvalidContinentReturnsEmpty() {
        List<CapitalCity> result = reports.getCapitalsByContinent(dummyCapitalConnection, "Narnia");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }

    @Test
    void report18NullContinentReturnsEmpty(){
        List<CapitalCity> result = reports.getCapitalsByContinent(dummyCapitalConnection, null);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return an empty list for null continent");
    }

    @Test
    void report18BlankContinentReturnsEmpty() {
        List<CapitalCity> result = reports.getCapitalsByContinent(dummyCapitalConnection, "");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for blank continent");
    }

    //Report 19
    //Issue 131: All Capital Cities In a Region
    @Test
    void report19InvalidRegionReturnsEmpty() {
        List<CapitalCity> result = reports.getCapitalsByRegion(dummyCapitalConnection, "Narnia");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid region");
    }

    @Test
    void report19NullRegionReturnsEmpty(){
        List<CapitalCity> result = reports.getCapitalsByRegion(dummyCapitalConnection, null);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return an empty list for null region");
    }

    @Test
    void report19BlankRegionReturnsEmpty() {
        List<CapitalCity> result = reports.getCapitalsByRegion(dummyCapitalConnection, "");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for blank region");
    }

    //report 21
    //UNIT TESTS ISSUE 26: Top N capitals in a continent
    @Test
    void report21InvalidContinentReturnsEmpty() {
        List<CapitalCity> result = reports.getTopNCapitalsByContinent(dummyCapitalConnection, "Narnia", 3);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }

    //Population reports

    //Report 26: Population of the world (Issue 87)
    @Test
    void report26NullConnectionReturnsEmpty() {
        List<PopulationReport> result = reports.getWorldPopulation(null);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }


    // Report 23
// Issue 28: Population distribution by continent

    @Test
    void report23NullConnectionReturnsEmpty() {
        List<PopulationReport> result =
                reports.getPopulationDistributionByContinent(dummyPopulationReportConnection);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }

    // Report 24
// Issue 29: Population distribution by region

    @Test
    void report24NullConnectionReturnsEmpty() {
        List<PopulationReport> result =
                reports.getPopulationDistributionByRegion(dummyPopulationReportConnection);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }

    // Report 25
// Issue 30: Population distribution by country

    @Test
    void report25NullConnectionReturnsEmpty() {
        List<PopulationReport> result =
                reports.getPopulationDistributionByCountry(dummyPopulationReportConnection);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }

    // Report 27
// Issue 31: Population of a continent

    @Test
    void report27InvalidContinentReturnsEmpty() {
        String continent = "Narnia";
        List<PopulationReport> result =
                reports.getPopulationByContinent(dummyPopulationReportConnection, continent);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }

    @Test
    void report27NullContinentReturnsEmpty() {
        String continent = null;
        List<PopulationReport> result =
                reports.getPopulationByContinent(dummyPopulationReportConnection, continent);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null continent");
    }

    @Test
    void report27BlankContinentReturnsEmpty() {
        String continent = "";
        List<PopulationReport> result =
                reports.getPopulationByContinent(dummyPopulationReportConnection, continent);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for blank continent");
    }

    @Test
    void report27NullConnectionReturnsEmpty() {
        String continent = "Africa";
        List<PopulationReport> result =
                reports.getPopulationByContinent(dummyPopulationReportConnection, continent);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }

    // Report 28
// Issue 32: Population of a region

    @Test
    void report28InvalidRegionReturnsEmpty() {
        String region = "Narnia";
        List<PopulationReport> result =
                reports.getPopulationByRegion(dummyPopulationReportConnection, region);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid region");
    }

    @Test
    void report28NullRegionReturnsEmpty() {
        String region = null;
        List<PopulationReport> result =
                reports.getPopulationByRegion(dummyPopulationReportConnection, region);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null region");
    }

    @Test
    void report28BlankRegionReturnsEmpty() {
        String region = "";
        List<PopulationReport> result =
                reports.getPopulationByRegion(dummyPopulationReportConnection, region);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for blank region");
    }

    @Test
    void report28NullConnectionReturnsEmpty() {
        String region = "Central Africa";
        List<PopulationReport> result =
                reports.getPopulationByRegion(dummyPopulationReportConnection, region);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }

    // Report 29
// Issue 33: Population of a country

    @Test
    void report29InvalidCountryReturnsEmpty() {
        String country = "Narnia";
        List<PopulationReport> result =
                reports.getPopulationByCountry(dummyPopulationReportConnection, country);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid country");
    }

    @Test
    void report29NullCountryReturnsEmpty() {
        String country = null;
        List<PopulationReport> result =
                reports.getPopulationByCountry(dummyPopulationReportConnection, country);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null country");
    }

    @Test
    void report29BlankCountryReturnsEmpty() {
        String country = "";
        List<PopulationReport> result =
                reports.getPopulationByCountry(dummyPopulationReportConnection, country);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for blank country");
    }

    @Test
    void report29NullConnectionReturnsEmpty() {
        String country = "France";
        List<PopulationReport> result =
                reports.getPopulationByCountry(dummyPopulationReportConnection, country);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }

    // Report 30
// Issue 34: Population of a district

    @Test
    void report30InvalidDistrictReturnsEmpty() {
        String district = "Narnia";
        List<PopulationReport> result =
                reports.getPopulationByDistrict(dummyPopulationReportConnection, district);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid district");
    }

    @Test
    void report30NullDistrictReturnsEmpty() {
        String district = null;
        List<PopulationReport> result =
                reports.getPopulationByDistrict(dummyPopulationReportConnection, district);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null district");
    }

    @Test
    void report30BlankDistrictReturnsEmpty() {
        String district = "";
        List<PopulationReport> result =
                reports.getPopulationByDistrict(dummyPopulationReportConnection, district);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for blank district");
    }

}
