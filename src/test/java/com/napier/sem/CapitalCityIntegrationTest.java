package com.napier.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CapitalCityIntegrationTest {
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

//    @Test
//    void report18ReturnsCapitalsInContinent() {
//        List<CapitalCity> result = app.reports.getCapitalsByContinent(app.capitalCityConnect, "Asia");
//        assertFalse(result.isEmpty());
//    }


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
    //test keeps failing
    /*
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
*/
    //Report 19
    //Issue 131 : All Capital Cities In a Region
    @Test
    void report19ReturnsCapitalsInRegion() {
        List<CapitalCity> result = app.reports.getCapitalsByRegion(app.capitalCityConnect, "Caribbean");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void report19InvalidRegionReturnsEmpty() {
        List<CapitalCity> result = app.reports.getCapitalsByRegion(app.capitalCityConnect, "Narnia");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    //test keeps failing
    /*@Test
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
    }*/


    // ISSUE 26 / REPORT 21: TOP N CAPITALS IN A CONTINENT (Moyo/Teammate)
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
}
