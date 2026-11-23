package com.napier.sem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountryUnitTest {
    Reports reports = new Reports();
    PrintReportConsole consoleReports = new PrintReportConsole();

    CountryConnection dummyCountryConnect = null;

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
}
