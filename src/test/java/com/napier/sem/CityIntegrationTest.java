package com.napier.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CityIntegrationTest {

    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    @AfterAll
    static void tearDown() {
        app.disconnect();
    }
    // REPORT 8/ISSUE14 - ALL THE CITIES IN A CONTINENT

    @Test
    void report8ReturnCitiesInContinent() {
        List<City> result = app.reports.getAllCitiesInContinent(app.cityConnect, "Europe");
        assertFalse(result.isEmpty());
    }

    @Test
    void report8InvalidContinentReturnsEmpty() {
        List<City> result = app.reports.getAllCitiesInContinent(app.cityConnect, "Narnia");
        assertTrue(result.isEmpty());
    }

    @Test
    void report8NullContinentReturnsEmpty() {
        List<City> result = app.reports.getAllCitiesInContinent(app.cityConnect, null);
        assertTrue(result.isEmpty());
    }

    @Test
    void report8CorrectColumns() {
        List<City> result = app.reports.getAllCitiesInContinent(app.cityConnect, "Europe");
        assertFalse(result.isEmpty());
        for (City c : result) {
            assertNotNull(c.getName());
            assertNotNull(c.getCountry());
            assertTrue(c.getPopulation() >= 0);
        }
    }

    /*
    Report 9
    Issue 17
    All the cities in a region organised by largest population to smallest
    */

    @Test
    void report9ReturnCitiesInRegion() {
        List<City> result = app.reports.getAllCitiesInRegion(app.cityConnect, "Southern and Central Asia");
        assertFalse(result.isEmpty());
    }

    @Test
    void report9InvalidRegionReturnsEmpty() {
        List<City> result = app.reports.getAllCitiesInRegion(app.cityConnect, "Narnia");
        assertTrue(result.isEmpty());
    }

    @Test
    void report9NullRegionReturnsEmpty() {
        List<City> result = app.reports.getAllCitiesInRegion(app.cityConnect, null);
        assertTrue(result.isEmpty());
    }

    @Test
    void report9CorrectColumns() {
        List<City> result = app.reports.getAllCitiesInRegion(app.cityConnect, "North America");
        assertFalse(result.isEmpty());
        for (City c : result) {
            assertNotNull(c.getName());
            assertNotNull(c.getCountry());
            assertNotNull(c.getDistrict());
            assertTrue(c.getPopulation() >= 0);
        }
    }


    //REPORT 10/ISSUE 15: ALL THE CITIES IN A COUNTRY

    @Test
    void report10ReturnCitiesInCountry() {
            List<City> result = app.reports.getAllCitiesInCountry(app.cityConnect, "United Kingdom");
            assertFalse(result.isEmpty());
        }

    @Test
    void report10NullCountryReturnsEmpty() {
            List<City> result = app.reports.getAllCitiesInCountry(app.cityConnect, null);
            assertNotNull(result);
            assertTrue(result.isEmpty());
        }

    @Test
    void report10CorrectColumns() {
        List<City> result = app.reports.getAllCitiesInCountry(app.cityConnect, "United Kingdom");
        assertFalse(result.isEmpty());
        for (City c : result) {
            assertNotNull(c.getName());
            assertNotNull(c.getCountry());
            assertTrue(c.getPopulation() >= 0 );
        }
    }

    @Test
    void report10BlankCountryReturnsEmpty(){
        List<City> result = app.reports.getAllCitiesInCountry(app.cityConnect, "");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void report10InvalidCountryReturnsEmpty(){
        List<City> result = app.reports.getAllCitiesInCountry(app.cityConnect, "Earthsea");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }


    /*
        Issue 16
        Report 11
        All the cities in a district organised by largest population to smallest
     */

    @Test
    void report11ReturnCitiesInDistrict() {
        List<City> result = app.reports.getAllCitiesInDistrict(app.cityConnect, "Polynesia");
        assertFalse(result.isEmpty());
    }

    @Test
    void report11NullDistrictReturnsEmpty() {
        List<City> result = app.reports.getAllCitiesInDistrict(app.cityConnect, null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }


    @Test
    void report11CorrectColumns() {
        List<City> result = app.reports.getAllCitiesInDistrict(app.cityConnect, "Eastern Europe");
        assertFalse(result.isEmpty());
        for (City c : result) {
            assertNotNull(c.getName());
            assertNotNull(c.getCountry());
            assertNotNull(c.getDistrict());
            assertTrue(c.getPopulation() >= 0 );
        }
    }

    @Test
    void report11BlankDistrictReturnsEmpty(){
        List<City> result = app.reports.getAllCitiesInDistrict(app.cityConnect, "");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void report11InvalidDistrictReturnsEmpty(){
        List<City> result = app.reports.getAllCitiesInDistrict(app.cityConnect, "Earthsea");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    /*
        Issue 18
        Report 12
        The top N populated cities in the world where N is provided by the user
     */

    // Test that lower bounds of n returns empty array
    @Test
    void report12InvalidNLowerBoundsReturnsEmpty(){
        int n = -1;
        List<City> result = app.reports.getNCitiesInWorld(app.cityConnect, n);
        assertTrue(result.isEmpty());
    }

    // Tests that asking for 5 cities returns exactly 5 cities
    @Test
    void report12ReturnsN() {
        int n = 5;
        List<City> result = app.reports.getNCitiesInWorld(app.cityConnect, n);
        assertEquals(n, result.size());
    }

    // Tests that results are ordered by population, largest first
    @Test
    void report12OrderedByPopDesc() {
        int n = 5;
        List<City> result = app.reports.getNCitiesInWorld(app.cityConnect, n);
        for (int i = 1; i < result.size(); i++) {
            assertTrue(result.get(i - 1).getPopulation() >= result.get(i).getPopulation());
        }
    }

    // Test that the report has the correct columns
    @Test
    void report12CorrectColumns(){
        int n = 10;
        List<City> result = app.reports.getNCitiesInWorld(app.cityConnect, n);
        assertFalse(result.isEmpty());
        for (City r : result){
            assertNotNull(r.getName());
            assertNotNull(r.getCountry());
            assertNotNull(r.getDistrict());
            assertTrue(r.getPopulation() >= 0);

        }
    }

    /*
        Issue 19
        Report 13
        The top N populated cities in a continent where N is provided by the user
     */
    // Test that lower bounds of n returns empty array
    @Test
    void report13InvalidNLowerBoundsReturnsEmpty(){
        int n = -1;
        String continent = "South America";
        List<City> result = app.reports.getNCitiesInContinent(app.cityConnect, continent, n);
        assertTrue(result.isEmpty());
    }

    // Tests that asking for 5 cities returns exactly 5 cities
    @Test
    void report13ReturnsN() {
        int n = 5;
        String continent = "South America";
        List<City> result = app.reports.getNCitiesInContinent(app.cityConnect, continent, n);
        assertEquals(n, result.size());
    }

    // Tests that results are ordered by population, largest first
    @Test
    void report13OrderedByPopDesc() {
        int n = 5;
        String continent = "South America";
        List<City> result = app.reports.getNCitiesInContinent(app.cityConnect, continent, n);
        for (int i = 1; i < result.size(); i++) {
            assertTrue(result.get(i - 1).getPopulation() >= result.get(i).getPopulation());
        }
    }

    // Test that the report has the correct columns
    @Test
    void report13CorrectColumns(){
        int n = 10;
        String continent = "South America";
        List<City> result = app.reports.getNCitiesInContinent(app.cityConnect, continent, n);
        assertFalse(result.isEmpty());
        for (City r : result){
            assertNotNull(r.getName());
            assertNotNull(r.getCountry());
            assertNotNull(r.getDistrict());
            assertTrue(r.getPopulation() >= 0);

        }
    }

    @Test
    void report13BlankContinentReturnsEmpty(){
        int n = 10;
        String continent = "";
        List<City> result = app.reports.getNCitiesInContinent(app.cityConnect, continent, n);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void report13InvalidContinentReturnsEmpty(){
        int n = 10;
        String continent = "Earthsea";
        List<City> result = app.reports.getNCitiesInContinent(app.cityConnect, continent, n);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
