package com.napier.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @AfterAll
    static void tearDown()
    {
        app.disconnect();
    }

    //Report 1: All the countries in the world organised by largest population to smallest

    // Test to see if it returns all countries
    @Test
    void report1ReturnAllCountries(){
        List<Country> result = app.reports.getAllCountries(app.countryConnect);
        assertEquals(239, result.size());
    }

    // Test to see if countries are descending order
    @Test
    void report1OrderedByPopDesc(){
        List<Country> result = app.reports.getAllCountries(app.countryConnect);
        assertFalse(result.isEmpty());
        for (int i = 1; i < result.size(); i++){
            assertTrue(result.get(i - 1).getPopulation() >= result.get(i).getPopulation());
        }
    }

    // Test that first result is China
    @Test
    void report1FirstCountryChina(){
        List<Country> result = app.reports.getAllCountries(app.countryConnect);
        assertEquals("China", result.get(0).getName());
    }

    // Test that the report has the correct columns
    //@Test
    //void report1CorrectColumns(){
        //List<Country> result = app.reports.getAllCountries(app.countryConnect);
        //assertFalse(result.isEmpty());
        //for (Country r : result){
            //assertNotNull(r.getName());
           // assertNotNull(r.getContinent());
           // assertNotNull(r.getRegion());
           // assertTrue(r.getPopulation() >= 0);
           // assertNotNull(r.getCapital());
      //  }
   // }

    // Report 2: All the countries in a continent organised by largest population to smallest

    // Test that is returns a list of countries
    @Test
    void report2ReturnCountries(){
        List<Country> result = app.reports.getCountriesByContinent(app.countryConnect, "South America");
        assertFalse(result.isEmpty());
    }

    // Test that it returns the correct number of countries
    @Test
    void report2CorrectCount()
    {
        List<Country> result = app.reports.getCountriesByContinent(app.countryConnect, "South America");
        assertEquals(14, result.size());
    }

    // Test that countries are in descending order
    @Test
    void report2OrderedByPopDesc(){
        List<Country> result = app.reports.getCountriesByContinent(app.countryConnect, "South America");
        assertFalse(result.isEmpty());
        for (int i = 1; i < result.size(); i++){
            assertTrue(result.get(i - 1).getPopulation() >= result.get(i).getPopulation());
        }
    }


    // Test that invalid Continent should return empty result
    @Test
    void report2InvalidContinentReturnsEmpty()
    {
        List<Country> result = app.reports.getCountriesByContinent(app.countryConnect, "Narnia");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Test that null Continent should return empty result
    @Test
    void report2NullContinentReturnsEmpty(){
        List<Country> result = app.reports.getCountriesByContinent(app.countryConnect, null);
        assertTrue(result.isEmpty());
    }

    // Test that empty Continent should return empty result
    @Test
    void report2EmptyContinentReturnsEmpty(){
        List<Country> result = app.reports.getCountriesByContinent(app.countryConnect, "");
        assertTrue(result.isEmpty());
    }

    // Test that the report has the correct columns
    @Test
    void report2CorrectColumns(){
        List<Country> result = app.reports.getCountriesByContinent(app.countryConnect, "South America");
        assertFalse(result.isEmpty());
        for (Country r : result){
            assertNotNull(r.getName());
            assertNotNull(r.getContinent());
            assertNotNull(r.getRegion());
            assertTrue(r.getPopulation() >= 0);
            assertNotNull(r.getCapital());
        }
    }

    //Report 3: All the countries in a region organised by largest population to smallest

    //Test that it returns countries
    @Test
    void report3ReturnCountries(){
        List<Country> result = app.reports.getCountriesByRegion(app.countryConnect, "Middle East");
        assertFalse(result.isEmpty());
    }

    // Test that countries are in descending order
    @Test
    void report3OrderedByPopDesc(){
        List<Country> result = app.reports.getCountriesByRegion(app.countryConnect, "Middle East");
        assertFalse(result.isEmpty());
        for (int i = 1; i < result.size(); i++){
            assertTrue(result.get(i - 1).getPopulation() >= result.get(i).getPopulation());
        }
    }

    // Test that invalid region should return empty result
    @Test
    void report3InvalidContinentReturnsEmpty()
    {
        List<Country> result = app.reports.getCountriesByRegion(app.countryConnect, "Earthsea");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Test that null Continent should return empty result
    @Test
    void report3NullContinentReturnsEmpty(){
        List<Country> result = app.reports.getCountriesByRegion(app.countryConnect, null);
        assertTrue(result.isEmpty());
    }


    // Test that empty Continent should return empty result
    @Test
    void report3EmptyContinentReturnsEmpty(){
        List<Country> result = app.reports.getCountriesByRegion(app.countryConnect, "");
        assertTrue(result.isEmpty());
    }

    // Test that the report has the correct columns
    @Test
    void report3CorrectColumns(){
        List<Country> result = app.reports.getCountriesByRegion(app.countryConnect, "Middle East");
        assertFalse(result.isEmpty());
        for (Country r : result){
            assertNotNull(r.getName());
            assertNotNull(r.getContinent());
            assertNotNull(r.getRegion());
            assertTrue(r.getPopulation() >= 0);
            assertNotNull(r.getCapital());
        }
    }

    // Report 4: The top N populated countries in the world where N is provided by the user
    // Test that it returns countries
    @Test
    void report4ReturnCountries(){
        int n = 10;
        List<Country> result = app.reports.getNCountriesInWorld(app.countryConnect, n);
        assertFalse(result.isEmpty());
    }

    // Test that it returns N Countries
    @Test
    void report4ReturnNCountries(){
        int n = 10;
        List<Country> result = app.reports.getNCountriesInWorld(app.countryConnect, n);
        assertEquals(n, result.size());
    }

    // Test that the report has the correct columns
    @Test
    void report4CorrectColumns(){
        int n = 10;
        List<Country> result = app.reports.getNCountriesInWorld(app.countryConnect, n);
        assertFalse(result.isEmpty());
        for (Country r : result){
            assertNotNull(r.getName());
            assertNotNull(r.getContinent());
            assertNotNull(r.getRegion());
            assertTrue(r.getPopulation() >= 0);
            assertNotNull(r.getCapital());
        }
    }

    // Test that lower bounds of n returns empty array
    @Test
    void report4InvalidNLowerBoundsReturnsEmpty(){
        int n = -1;
        List<Country> result = app.reports.getNCountriesInWorld(app.countryConnect, n);
        assertTrue(result.isEmpty());
    }

    //Report 5: The top N populated countries in a continent where N is provided by the user.
    // Test that it returns countries
    @Test
    void report5ReturnCountries(){
        int n = 10;
        List<Country> result = app.reports.getNCountriesInContinent(app.countryConnect,  "Asia",  n);
        assertFalse(result.isEmpty());
    }

    // Test that it returns N Countries
    @Test
    void report5ReturnNCountries(){
        int n = 10;
        List<Country> result = app.reports.getNCountriesInContinent(app.countryConnect, "Asia", n);
        assertEquals(n, result.size());
    }

    // Test that the report has the correct columns
    @Test
    void report5CorrectColumns(){
        int n = 10;
        List<Country> result = app.reports.getNCountriesInContinent(app.countryConnect, "Asia", n);
        assertFalse(result.isEmpty());
        for (Country r : result){
            assertNotNull(r.getName());
            assertNotNull(r.getContinent());
            assertNotNull(r.getRegion());
            assertTrue(r.getPopulation() >= 0);
            assertNotNull(r.getCapital());
        }
    }

    // Test that lower bounds of n returns empty array
    @Test
    void report5InvalidNLowerBoundsReturnsEmpty(){
        int n = -1;
        List<Country> result = app.reports.getNCountriesInContinent(app.countryConnect, "Asia", n);
        assertTrue(result.isEmpty());
    }

    // Test that is continent is empty returns empty array
    @Test
    void report5ContinentEmptyReturnsEmpty(){
        int n = -1;
        List<Country> result = app.reports.getNCountriesInContinent(app.countryConnect, "", n);
        assertTrue(result.isEmpty());
    }

    // Continent null
    @Test
    void report5ContinentNullReturnsEmpty(){
        int n = -1;
        List<Country> result = app.reports.getNCountriesInContinent(app.countryConnect, null, n);
        assertTrue(result.isEmpty());
    }

}
