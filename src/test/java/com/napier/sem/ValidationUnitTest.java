package com.napier.sem;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationUnitTest {
    Reports reports = new Reports();

    CountryConnection dummyCountryConnect = null;
    CityConnection dummyCityConnect = null;
    CapitalCityConnection dummyCapitalConnection = null;

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

    // Test that invalid n return empty list
    @Test
    void report4InvalidNReturnEmpty(){
        int n = -1;
        List<Country> result = reports.getNCountriesInWorld(dummyCountryConnect, n);
        assertTrue(result.isEmpty(), "Should return empty list for invalid n");
    }

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
        reports.displayCountryReports(new ArrayList<>());
    }

    // UNIT TEST ISSUE 13: All the cities in the world, largest to smallest

    @Test
    void displayCityReportsEmptyList() {
        reports.displayCityReports(new ArrayList<>());
    }

    @Test
    void report7TitleCorrect() {
        assertEquals("All the cities in the world organised by largest population to smallest",
        reports.getReports(7));
    }

    //UNIT TESTS ISSUE 14: cities in a continent
    @Test
    void test14invalidContinentsReturnsEmpty() {
        List<City> result = reports.getAllCitiesInContinent(dummyCityConnect, "Narnia");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }

    @Test
    void test14NullContinentReturnsEmpty() {
        List<City> result = reports.getAllCitiesInContinent(dummyCityConnect, null);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null continent");
    }

    //UNIT TESTS ISSUE 15: cities in a country
    @Test
    void test15InvalidCountryReturnsEmpty() {
        List<City> result = reports.getAllCitiesInCountry(dummyCityConnect, "XYZ");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid country");
    }

    //UNTI TESTS ISSUE 26: Top N capitals in a continent
    @Test
    void test26InvalidContinentReturnsEmpty() {
        List<CapitalCity> result = reports.getTopNCapitalsByContinent(dummyCapitalConnection, "Narnia", 3);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }
}
