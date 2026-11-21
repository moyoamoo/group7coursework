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

    //ISSUE 24/ REPORT 18: ALL CAPITAL CITIES IN A CONTINENT
    @Test
    void test24ReturnsCapitalsInContinent() {
        List<CapitalCity> result = app.reports.getCapitalsByContinent(app.capitalCityConnect, "Europe");
        assertFalse(result.isEmpty());
    }

    @Test
    void test24InvalidContinentReturnsEmpty(){
        List<CapitalCity> result = app.reports.getCapitalsByContinent(app.capitalCityConnect, "Narnia");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void test24NullContinentReturnsEmpty(){
        List<CapitalCity> result = app.reports.getCapitalsByContinent(app.capitalCityConnect, null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }


    @Test
    void test24OrderedByPopDesc() {
        List<CapitalCity> result = app.reports.getCapitalsByContinent(app.capitalCityConnect, "Europe");
        assertFalse(result.isEmpty());
        for (int i = 1; i < result.size(); i++){
            assertTrue(result.get(i - 1).getPopulation() >= result.get(i).getPopulation());
        }
    }
        @Test
    void test24CorrectColumn() {
        List<CapitalCity> result = app.reports.getCapitalsByContinent(app.capitalCityConnect, "Europe");
        assertFalse(result.isEmpty());
        for (CapitalCity c : result){
            assertNotNull(c.getName());
            assertNotNull(c.getName());
            assertTrue(c.getPopulation() >= 0);
        }
    }

        //ISSUE 26/REPORT 21 : TOP N CAPITALS IN A CONTINENT

    @Test
    void test26TopNCapitalsReturnsData() {
        List<CapitalCity> result = app.reports.getTopNCapitalsByContinent(app.capitalCityConnect, "Europe" , 3);
        assertFalse(result.isEmpty());
        assertTrue(result.size() <= 3);
    }

    @Test
    void test26InvalidContinentReturnsEmpty() {
        List<CapitalCity> result = app.reports.getTopNCapitalsByContinent(app.capitalCityConnect, "Narnia" , 3);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void test26InvalidNReturnsEmpty() {
        int n = -1;
        List<CapitalCity> result = app.reports.getTopNCapitalsByContinent(app.capitalCityConnect, "Europe" , n);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
