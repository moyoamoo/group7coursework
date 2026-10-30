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

    //Report 1

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

    // Report 2
    // Test that is returns a list of countries
    @Test
    void report2ReturnCountries(){
        List<Country> result = app.reports.getCountriesByContinent(app.countryConnect, "South America");
        assertFalse(result.isEmpty());
    }


}
