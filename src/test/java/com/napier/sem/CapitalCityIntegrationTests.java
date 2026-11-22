package com.napier.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CapitalCityIntegrationTests {
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

    // ISSUE 130 / REPORT 17: ALL CAPITAL CITIES IN THE WORLD
    @Test
    void report17ReturnsAllCapitals() {
        List<CapitalCity> result = app.reports.getAllCapitals(app.capitalCityConnect);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void report17OrderedByPopDesc() {
        List<CapitalCity> result = app.reports.getAllCapitals(app.capitalCityConnect);
        assertFalse(result.isEmpty());
        for (int i = 1; i < result.size(); i++) {
            assertTrue(result.get(i - 1).getPopulation() >= result.get(i).getPopulation());
        }
    }

    @Test
    void report17CorrectColumns() {
        List<CapitalCity> result = app.reports.getAllCapitals(app.capitalCityConnect);
        assertFalse(result.isEmpty());
        for (CapitalCity c : result) {
            assertNotNull(c.getName());
            assertNotNull(c.getCountry());
            assertTrue(c.getPopulation() >= 0);
        }
    }

    // ISSUE 24 / REPORT 18: ALL CAPITAL CITIES IN A CONTINENT (Khadijah)
    @Test
    void report18ReturnsCapitalsInContinent() {
        List<CapitalCity> result = app.reports.getCapitalsByContinent(app.capitalCityConnect, "Asia");
        assertFalse(result.isEmpty());
    }


    @Test
    void report18InvalidContinentReturnsEmpty() {
        List<CapitalCity> result = app.reports.getCapitalsByContinent(app.capitalCityConnect, "Narnia");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void report18NullContinentReturnsEmpty() {
        List<CapitalCity> result = app.reports.getCapitalsByContinent(app.capitalCityConnect, null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void report18OrderedByPopDesc() {
        List<CapitalCity> result = app.reports.getCapitalsByContinent(app.capitalCityConnect, "Europe");
        assertFalse(result.isEmpty());
        for (int i = 1; i < result.size(); i++) {
            assertTrue(result.get(i - 1).getPopulation() >= result.get(i).getPopulation());
        }
    }

    @Test
    void report18CorrectColumns() {
        List<CapitalCity> result = app.reports.getCapitalsByContinent(app.capitalCityConnect, "Europe");
        assertFalse(result.isEmpty());
        for (CapitalCity c : result) {
            assertNotNull(c.getName());
            assertNotNull(c.getCountry());
            assertTrue(c.getPopulation() >= 0);
        }
    }

    //Issue 131 /Report 19 : All Capital Cities In a Region

    @Test
    void report19ReturnsCapitalsInRegion() {
        List<CapitalCity> result = app.reports.getCapitalsByRegion(app.capitalCityConnect, "Caribbean");
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void report19InvalidRegionReturnsEmpty() {
        List<CapitalCity> result = app.reports.getCapitalsByRegion(app.capitalCityConnect, "Narnia");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void report19OrderedByPopDesc() {
        List<CapitalCity> result = app.reports.getCapitalsByRegion(app.capitalCityConnect, "Caribbean");
        assertFalse(result.isEmpty());
        for (int i = 1; i < result.size(); i++) {
            assertTrue(result.get(i - 1).getPopulation() >= result.get(i).getPopulation(), "Capitals should be ordered from largest to smallest population");
        }
    }

    @Test
    void report19CorrectColumns() {
        List<CapitalCity> result = app.reports.getCapitalsByRegion(app.capitalCityConnect, "Middle East");
        assertFalse(result.isEmpty());
        for (CapitalCity c : result) {
            assertNotNull(c.getName());
            assertNotNull(c.getCountry());
            assertTrue(c.getPopulation() >= 0);
        }
    }

    // ISSUE 20 / REPORT 20: TOP N CAPITALS IN WORLD

    // Test that it returns results from database
    @Test
    void report20ReturnsCapitalsInWorld() {
        int n = 10;
        List<CapitalCity> result = app.reports.getTopNCapitalsWorld(app.capitalCityConnect, n);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    // Test that it returns n number of capitals
    @Test
    void report20ReturnsNCapitalsInWorld() {
        int n = 10;
        List<CapitalCity> result = app.reports.getTopNCapitalsWorld(app.capitalCityConnect, n);
        assertEquals(n, result.size());
    }

    // Test that it is ordered desc
    @Test
    void report20OrderedByPopDesc() {
        int n = 10;
        List<CapitalCity> result = app.reports.getTopNCapitalsWorld(app.capitalCityConnect, n);
        assertFalse(result.isEmpty());
        for (int i = 1; i < result.size(); i++) {
            assertTrue(result.get(i - 1).getPopulation() >= result.get(i).getPopulation(), "Capitals should be ordered from largest to smallest population");
        }
    }

    // Test that it prints the correct columns
    @Test
    void report20CorrectColumns() {
        int n = 10;
        List<CapitalCity> result = app.reports.getTopNCapitalsWorld(app.capitalCityConnect, n);
        assertFalse(result.isEmpty());
        for (CapitalCity c : result) {
            assertNotNull(c.getName());
            assertNotNull(c.getCountry());
            assertTrue(c.getPopulation() >= 0);
        }
    }

    // ISSUE 26 / REPORT 21: TOP N CAPITALS IN A CONTINENT (Moyo)
    @Test
    void report21TopNCapitalsReturnsData() {
        List<CapitalCity> result = app.reports.getTopNCapitalsByContinent(app.capitalCityConnect, "Europe", 3);
        assertFalse(result.isEmpty());
        assertTrue(result.size() <= 3);
    }

    @Test
    void report21InvalidContinentReturnsEmpty() {
        List<CapitalCity> result = app.reports.getTopNCapitalsByContinent(app.capitalCityConnect, "Narnia", 3);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void report21InvalidNReturnsEmpty() {
        int n = -1;
        List<CapitalCity> result = app.reports.getTopNCapitalsByContinent(app.capitalCityConnect, "Europe", n);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void report21BlankContinentReturnsEmpty() {
        int n = 3;
        String continent = "";
        List<CapitalCity> result = app.reports.getTopNCapitalsByContinent(app.capitalCityConnect, continent, n);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Test that it is ordered desc
    @Test
    void report21OrderedByPopDesc() {
        int n = 10;
        String continent = "Europe";
        List<CapitalCity> result = app.reports.getTopNCapitalsByContinent(app.capitalCityConnect, continent, n);
        assertFalse(result.isEmpty());
        for (int i = 1; i < result.size(); i++) {
            assertTrue(result.get(i - 1).getPopulation() >= result.get(i).getPopulation(), "Capitals should be ordered from largest to smallest population");
        }
    }

    // Test that it prints the correct columns
    @Test
    void report21CorrectColumns() {
        int n = 10;
        String continent = "Europe";
        List<CapitalCity> result = app.reports.getTopNCapitalsByContinent(app.capitalCityConnect,continent,  n);
        assertFalse(result.isEmpty());
        for (CapitalCity c : result) {
            assertNotNull(c.getName());
            assertNotNull(c.getCountry());
            assertTrue(c.getPopulation() >= 0);
        }
    }

    // ISSUE 25 / REPORT 22: TOP N CAPITALS IN A REGION
    @Test
    void report22TopNCapitalsReturnsData() {
        int n = 3;
        String region = "Caribbean";
        List<CapitalCity> result = app.reports.getTopNCapitalsByRegion(app.capitalCityConnect, region, n);
        assertFalse(result.isEmpty());
        assertTrue(result.size() <= n);
    }

    @Test
    void report22InvalidRegionReturnsEmpty() {
        int n = 3;
        String region = "Narnia";
        List<CapitalCity> result = app.reports.getTopNCapitalsByRegion(app.capitalCityConnect, region, n);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void report22BlankRegionReturnsEmpty() {
        int n = 3;
        String region = "";
        List<CapitalCity> result = app.reports.getTopNCapitalsByContinent(app.capitalCityConnect, region, n);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}


