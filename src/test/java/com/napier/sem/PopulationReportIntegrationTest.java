package com.napier.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/** Database integration tests for issues #24 and #25. Requires docker-compose world DB. */
class PopulationReportIntegrationTest {
    static App app;
    static PopulationReportConnection populationConnection;

    @BeforeAll static void setUp() {
        app = new App();
        app.connect("localhost:33060", 30000);
        // Reuse the application's established JDBC connection through a small accessor-free setup
        // is not possible, so the integration tests use the report connection exposed by App below.
        populationConnection = app.populationReportConnect;
    }

    @AfterAll static void tearDown() { if (app != null) app.disconnect(); }

    @Test void issue24ReturnsCountriesForValidRegion() {
        List<PopulationReport> result = app.reports.getPopulationByRegion(populationConnection, "Western Europe");
        assertFalse(result.isEmpty());
        assertTrue(result.stream().anyMatch(r -> "France".equals(r.getCountryName())));
        assertTrue(result.stream().allMatch(r -> r.getTotalPopulation() >= r.getCityPopulation()));
    }

    @Test void issue24RejectsInvalidRegion() {
        assertTrue(app.reports.getPopulationByRegion(populationConnection, "Narnia").isEmpty());
    }

    @Test void issue25ReturnsSelectedCountry() {
        List<PopulationReport> result = app.reports.getPopulationByCountry(populationConnection, "France");
        assertEquals(1, result.size());
        assertEquals("France", result.get(0).getCountryName());
        assertTrue(result.get(0).getTotalPopulation() >= result.get(0).getCityPopulation());
    }

    @Test void issue25RejectsBlankCountry() {
        assertTrue(app.reports.getPopulationByCountry(populationConnection, " ").isEmpty());
    }
}
