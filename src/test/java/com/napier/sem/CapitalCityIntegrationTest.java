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

    //ISSUE 26/REPORT 26 : TOP N CAPITALS IN A CONTINENT

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
}
