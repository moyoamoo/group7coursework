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
}
