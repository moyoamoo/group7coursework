package com.napier.sem;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CityUnitTest {
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
}
