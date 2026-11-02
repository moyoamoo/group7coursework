package com.napier.sem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Unit tests for population calculations used by issues #24 and #25. */
class PopulationReportUnitTest {
    @Test void issue24CalculatesCityAndNonCityPopulationForRegionCountryRow() {
        PopulationReport report = new PopulationReport("France", 1000, 600);
        assertEquals(1000, report.getTotalPopulation());
        assertEquals(600, report.getCityPopulation());
        assertEquals(400, report.getNonCityPopulation());
        assertEquals(60.0, report.getCityPercentage(), 0.001);
        assertEquals(40.0, report.getNonCityPercentage(), 0.001);
    }

    @Test void issue25CalculatesCountryPopulationPercentages() {
        PopulationReport report = new PopulationReport("Example", 250, 125);
        assertEquals(50.0, report.getCityPercentage(), 0.001);
        assertEquals(50.0, report.getNonCityPercentage(), 0.001);
    }

    @Test void zeroPopulationDoesNotDivideByZero() {
        PopulationReport report = new PopulationReport("Empty", 0, 0);
        assertEquals(0.0, report.getCityPercentage());
        assertEquals(0.0, report.getNonCityPercentage());
    }

    @Test void issue24RejectsInvalidAndNullRegionWithoutDatabase() {
        Reports reports = new Reports();
        assertTrue(reports.getPopulationByRegion(null, "Narnia").isEmpty());
        assertTrue(reports.getPopulationByRegion(null, null).isEmpty());
        assertTrue(reports.getPopulationByRegion(null, "").isEmpty());
    }

    @Test void issue25RejectsNullOrBlankCountryWithoutDatabase() {
        Reports reports = new Reports();
        assertTrue(reports.getPopulationByCountry(null, null).isEmpty());
        assertTrue(reports.getPopulationByCountry(null, " ").isEmpty());
    }

    @Test void nullConnectionOrParameterReturnsEmptyList() {
        PopulationReportConnection connection = new PopulationReportConnection(null);
        assertTrue(connection.run(PopulationReportQueries.BY_COUNTRY, "France").isEmpty());
        assertTrue(connection.run(PopulationReportQueries.BY_COUNTRY, null).isEmpty());
    }
}
