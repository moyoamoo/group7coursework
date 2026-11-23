package com.napier.sem;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PopulationReportUnitTests {
    Reports reports = new Reports();
    PrintReportConsole consoleReports = new PrintReportConsole();
    PopulationReportConnection dummyPopulationReportConnection = null;
    LanguageConnection dummyLanguageConnection = null;

    // Report 23
// Issue 28: Population distribution by continent

    @Test
    void report23NullConnectionReturnsEmpty() {
        List<PopulationReport> result =
                reports.getPopulationDistributionByContinent(dummyPopulationReportConnection);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }

    // Report 24
// Issue 29: Population distribution by region

    @Test
    void report24NullConnectionReturnsEmpty() {
        List<PopulationReport> result =
                reports.getPopulationDistributionByRegion(dummyPopulationReportConnection);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }

    // Report 25
// Issue 30: Population distribution by country

    @Test
    void report25NullConnectionReturnsEmpty() {
        List<PopulationReport> result =
                reports.getPopulationDistributionByCountry(dummyPopulationReportConnection);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }

    //Report 26: Population of the world (Issue 87)
    @Test
    void report26NullConnectionReturnsEmpty() {
        List<PopulationReport> result = reports.getWorldPopulation(null);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }

    // Report 27
// Issue 31: Population of a continent

    @Test
    void report27InvalidContinentReturnsEmpty() {
        String continent = "Narnia";
        List<PopulationReport> result =
                reports.getPopulationByContinent(dummyPopulationReportConnection, continent);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }

    @Test
    void report27NullContinentReturnsEmpty() {
        String continent = null;
        List<PopulationReport> result =
                reports.getPopulationByContinent(dummyPopulationReportConnection, continent);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null continent");
    }

    @Test
    void report27BlankContinentReturnsEmpty() {
        String continent = "";
        List<PopulationReport> result =
                reports.getPopulationByContinent(dummyPopulationReportConnection, continent);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for blank continent");
    }

    @Test
    void report27NullConnectionReturnsEmpty() {
        String continent = "Africa";
        List<PopulationReport> result =
                reports.getPopulationByContinent(dummyPopulationReportConnection, continent);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }

    // Report 28
// Issue 32: Population of a region

    @Test
    void report28InvalidRegionReturnsEmpty() {
        String region = "Narnia";
        List<PopulationReport> result =
                reports.getPopulationByRegion(dummyPopulationReportConnection, region);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid region");
    }

    @Test
    void report28NullRegionReturnsEmpty() {
        String region = null;
        List<PopulationReport> result =
                reports.getPopulationByRegion(dummyPopulationReportConnection, region);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null region");
    }

    @Test
    void report28BlankRegionReturnsEmpty() {
        String region = "";
        List<PopulationReport> result =
                reports.getPopulationByRegion(dummyPopulationReportConnection, region);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for blank region");
    }

    @Test
    void report28NullConnectionReturnsEmpty() {
        String region = "Central Africa";
        List<PopulationReport> result =
                reports.getPopulationByRegion(dummyPopulationReportConnection, region);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }

    // Report 29
// Issue 33: Population of a country

    @Test
    void report29InvalidCountryReturnsEmpty() {
        String country = "Narnia";
        List<PopulationReport> result =
                reports.getPopulationByCountry(dummyPopulationReportConnection, country);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid country");
    }

    @Test
    void report29NullCountryReturnsEmpty() {
        String country = null;
        List<PopulationReport> result =
                reports.getPopulationByCountry(dummyPopulationReportConnection, country);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null country");
    }

    @Test
    void report29BlankCountryReturnsEmpty() {
        String country = "";
        List<PopulationReport> result =
                reports.getPopulationByCountry(dummyPopulationReportConnection, country);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for blank country");
    }

    @Test
    void report29NullConnectionReturnsEmpty() {
        String country = "France";
        List<PopulationReport> result =
                reports.getPopulationByCountry(dummyPopulationReportConnection, country);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }

    // Report 30
// Issue 34: Population of a district

    @Test
    void report30InvalidDistrictReturnsEmpty() {
        String district = "Narnia";
        List<PopulationReport> result =
                reports.getPopulationByDistrict(dummyPopulationReportConnection, district);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid district");
    }

    @Test
    void report30NullDistrictReturnsEmpty() {
        String district = null;
        List<PopulationReport> result =
                reports.getPopulationByDistrict(dummyPopulationReportConnection, district);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null district");
    }

    @Test
    void report30BlankDistrictReturnsEmpty() {
        String district = "";
        List<PopulationReport> result =
                reports.getPopulationByDistrict(dummyPopulationReportConnection, district);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for blank district");
    }

    @Test
    void report30NullConnectionReturnsEmpty() {
        String district = "Addis Abeba";
        List<PopulationReport> result =
                reports.getPopulationByDistrict(dummyPopulationReportConnection, district);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }
    // Report 31
// Issue 35: Population of a city

    @Test
    void report31InvalidCityReturnsEmpty() {
        String city = "Narnia";
        List<PopulationReport> result =
                reports.getPopulationByCity(dummyPopulationReportConnection, city);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid city");
    }

    @Test
    void report31NullCityReturnsEmpty() {
        String city = null;
        List<PopulationReport> result =
                reports.getPopulationByCity(dummyPopulationReportConnection, city);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null city");
    }

    @Test
    void report31BlankCityReturnsEmpty() {
        String city = "";
        List<PopulationReport> result =
                reports.getPopulationByCity(dummyPopulationReportConnection, city);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for blank city");
    }

    @Test
    void report31NullConnectionReturnsEmpty() {
        String city = "Edinburgh";
        List<PopulationReport> result =
                reports.getPopulationByCity(dummyPopulationReportConnection, city);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null connection");
    }
}
