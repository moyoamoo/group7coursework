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
    //REPORT 10/ISSUE 15: ALL THE CITIES IN A COUNTRY

    @Test
    void report10ReturnCitiesInCountry() {
            List<City> result = app.reports.getAllCitiesInCountry(app.cityConnect, "United Kingdom");
            assertFalse(result.isEmpty());
        }

    @Test
    void report10InvalidCountryReturnsEmpty() {
            List<City> result = app.reports.getAllCitiesInCountry(app.cityConnect, "XYZ");
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
}
