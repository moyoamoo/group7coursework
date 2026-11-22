package com.napier.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/** Database integration tests for issues #24 and #25. Requires docker-compose world DB. */
class PopulationReportIntegrationTests {
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

    // Report 23: The population distribution by continent (Issue #28)

    // Test that it returns population information
    @Test
    void report23ReturnPopulation(){
        List<PopulationReport> result = app.reports.getPopulationDistributionByContinent(populationConnection);
        assertFalse(result.isEmpty());
    }

    // Test that continents are returned
    @Test
    void report23ReturnContinents(){
        List<PopulationReport> result = app.reports.getPopulationDistributionByContinent(populationConnection);
        assertFalse(result.isEmpty());

        assertTrue(result.size() >= 5);
    }

    // Test that the report has the correct columns
    @Test
    void report23CorrectColumns() {
        List<PopulationReport> result =
                app.reports.getPopulationDistributionByContinent(populationConnection);

        assertFalse(result.isEmpty(), "Report should contain continents");

        for (PopulationReport report : result) {
            assertNotNull(report.getAreaName());
            assertTrue(report.getTotalPopulation() >= 0);
            assertTrue(report.hasCityBreakdown());
            assertTrue(report.getCityPopulation() >= 0);
            assertTrue(report.getNonCityPopulation() >= 0);

            assertEquals(
                    report.getTotalPopulation(),
                    report.getCityPopulation() + report.getNonCityPopulation()
            );
        }
    }

    @Test
    void report23CorrectPopulationPercentages() {
        List<PopulationReport> result =
                app.reports.getPopulationDistributionByContinent(populationConnection);

        assertFalse(result.isEmpty());

        for (PopulationReport report : result) {
            if (report.getTotalPopulation() == 0) {
                assertEquals(0.0, report.getCityPercentage());
                assertEquals(0.0, report.getNonCityPercentage());
            } else {
                assertEquals(
                        100.0,
                        report.getCityPercentage() + report.getNonCityPercentage(),
                        0.01
                );
            }
        }
    }

    // Test that null connection should return empty result
    @Test
    void report23NullConnectionReturnsEmpty(){
        List<PopulationReport> result = app.reports.getPopulationDistributionByContinent(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Report 24: The population distribution by region (Issue #29)

    // Test that it returns population information
    @Test
    void report24ReturnPopulation(){
        List<PopulationReport> result = app.reports.getPopulationDistributionByRegion(populationConnection);
        assertFalse(result.isEmpty());
    }

    // Test that regions are returned
    @Test
    void report24ReturnRegions(){
        List<PopulationReport> result = app.reports.getPopulationDistributionByRegion(populationConnection);
        assertFalse(result.isEmpty());

        assertTrue(result.size() > 1);
    }



    // Test that the report has the correct columns
    @Test
    void report24CorrectColumns() {
        List<PopulationReport> result =
                app.reports.getPopulationDistributionByRegion(populationConnection);

        assertFalse(result.isEmpty(), "Report should contain regions");

        for (PopulationReport report : result) {
            assertNotNull(report.getAreaName());
            assertTrue(report.getTotalPopulation() >= 0);
            assertTrue(report.hasCityBreakdown());
            assertTrue(report.getCityPopulation() >= 0);
            assertTrue(report.getNonCityPopulation() >= 0);

            assertEquals(
                    report.getTotalPopulation(),
                    report.getCityPopulation() + report.getNonCityPopulation()
            );
        }
    }

    // Test that null connection should return empty result
    @Test
    void report24NullConnectionReturnsEmpty(){
        List<PopulationReport> result = app.reports.getPopulationDistributionByRegion(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Report 25: The population distribution by country (Issue #30)

    // Test that it returns population information
    @Test
    void report25ReturnPopulation(){
        List<PopulationReport> result = app.reports.getPopulationDistributionByCountry(populationConnection);
        assertFalse(result.isEmpty());
    }

    // Test that countries are returned
    @Test
    void report25ReturnCountries(){
        List<PopulationReport> result = app.reports.getPopulationDistributionByCountry(populationConnection);
        assertFalse(result.isEmpty());

        assertTrue(result.size() > 1);
    }

    // Test that the report has the correct columns
    @Test
    void report25CorrectColumns() {
        List<PopulationReport> result =
                app.reports.getPopulationDistributionByCountry(populationConnection);

        assertFalse(result.isEmpty(), "Report should contain countries");

        for (PopulationReport report : result) {
            assertNotNull(report.getAreaName());
            assertTrue(report.getTotalPopulation() >= 0);
            assertTrue(report.hasCityBreakdown());
            assertTrue(report.getCityPopulation() >= 0);

            assertEquals(
                    Math.max(0L, report.getTotalPopulation() - report.getCityPopulation()),
                    report.getNonCityPopulation()
            );
        }
    }

    // Test that the population percentages add up to approximately 100
    @Test
    void report25CorrectPopulationPercentages() {
        List<PopulationReport> result =
                app.reports.getPopulationDistributionByCountry(populationConnection);

        assertFalse(result.isEmpty());

        for (PopulationReport r : result) {
            assertTrue(r.getTotalPopulation() >= 0);
            assertTrue(r.hasCityBreakdown());

            if (r.getTotalPopulation() == 0) {
                assertEquals(0.0, r.getCityPercentage());
                assertEquals(0.0, r.getNonCityPercentage());
            } else if (r.getCityPopulation() <= r.getTotalPopulation()) {
                assertEquals(
                        100.0,
                        r.getCityPercentage() + r.getNonCityPercentage(),
                        0.01
                );
            } else {
                assertTrue(r.getCityPercentage() > 100.0);
                assertEquals(0.0, r.getNonCityPercentage());
            }
        }
    }

    // Test that null connection should return empty result
    @Test
    void report25NullConnectionReturnsEmpty(){
        List<PopulationReport> result = app.reports.getPopulationDistributionByCountry(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }


    // Report 27: The population of a continent (Issue #31)

    // Test that it returns population information
    @Test
    void report27ReturnPopulation(){
        String continent = "Asia";
        List<PopulationReport> result = app.reports.getPopulationByContinent(populationConnection, continent);
        assertFalse(result.isEmpty());
    }

    // Test that the continent has the correct total population
    @Test
    void report27CorrectPopulation(){
        String continent = "Asia";
        List<PopulationReport> result = app.reports.getPopulationByContinent(populationConnection, continent);
        assertFalse(result.isEmpty());

        assertTrue(result.get(0).getTotalPopulation() > 0);
    }

    // Test that invalid continent should return empty result
    @Test
    void report27InvalidContinentReturnsEmpty(){
        String continent = "Earthsea";
        List<PopulationReport> result = app.reports.getPopulationByContinent(populationConnection, continent);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Test that null continent should return empty result
    @Test
    void report27NullContinentReturnsEmpty(){
        String continent = null;
        List<PopulationReport> result = app.reports.getPopulationByContinent(populationConnection, continent);
        assertTrue(result.isEmpty());
    }

    // Test that empty continent should return empty result
    @Test
    void report27EmptyContinentReturnsEmpty(){
        String continent = "";
        List<PopulationReport> result = app.reports.getPopulationByContinent(populationConnection, continent);
        assertTrue(result.isEmpty());
    }

    // Test that the report has the correct columns
    @Test
    void report27CorrectColumns(){
        String continent = "Asia";
        List<PopulationReport> result = app.reports.getPopulationByContinent(populationConnection, continent);
        assertFalse(result.isEmpty());

        for (PopulationReport r : result){
            assertNotNull(r.getAreaName());
            assertTrue(r.getTotalPopulation() > 0);
        }
    }

    // Test that null connection should return empty result
    @Test
    void report27NullConnectionReturnsEmpty(){
        String continent = "Asia";
        List<PopulationReport> result = app.reports.getPopulationByContinent(null, continent);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Report 28: The population of a region (Issue #32)

    // Test that it returns population information
    @Test
    void report28ReturnPopulation(){
        String region = "Middle East";
        List<PopulationReport> result = app.reports.getPopulationByRegion(populationConnection, region);
        assertFalse(result.isEmpty());
    }

    // Test that the region has the correct total population
    @Test
    void report28CorrectPopulation(){
        String region = "Middle East";
        List<PopulationReport> result = app.reports.getPopulationByRegion(populationConnection, region);
        assertFalse(result.isEmpty());

        assertTrue(result.get(0).getTotalPopulation() > 0);
    }

    // Test that invalid region should return empty result
    @Test
    void report28InvalidRegionReturnsEmpty(){
        String region = "Atlantis";
        List<PopulationReport> result = app.reports.getPopulationByRegion(populationConnection, region);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Test that null region should return empty result
    @Test
    void report28NullRegionReturnsEmpty(){
        String region = null;
        List<PopulationReport> result = app.reports.getPopulationByRegion(populationConnection, region);
        assertTrue(result.isEmpty());
    }

    // Test that empty region should return empty result
    @Test
    void report28EmptyRegionReturnsEmpty(){
        String region = "";
        List<PopulationReport> result = app.reports.getPopulationByRegion(populationConnection, region);
        assertTrue(result.isEmpty());
    }

    // Test that the report has the correct columns
    @Test
    void report28CorrectColumns(){
        String region = "Middle East";
        List<PopulationReport> result = app.reports.getPopulationByRegion(populationConnection, region);
        assertFalse(result.isEmpty());

        for (PopulationReport r : result){
            assertNotNull(r.getAreaName());
            assertTrue(r.getTotalPopulation() > 0);
            assertTrue(r.getCityPopulation() >= 0);
            assertTrue(r.hasCityBreakdown());
        }
    }

    // Test that null connection should return empty result
    @Test
    void report28NullConnectionReturnsEmpty(){
        String region = "Middle East";
        List<PopulationReport> result = app.reports.getPopulationByRegion(null, region);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Report 29: The population of a country (Issue #33)

    // Test that it returns population information
    @Test
    void report29ReturnPopulation(){
        String country = "United Kingdom";
        List<PopulationReport> result = app.reports.getPopulationByCountry(populationConnection, country);
        assertFalse(result.isEmpty());
    }

    // Test that the country has the correct total population
    @Test
    void report29CorrectPopulation(){
        String country = "United Kingdom";
        List<PopulationReport> result = app.reports.getPopulationByCountry(populationConnection, country);
        assertFalse(result.isEmpty());

        assertTrue(result.get(0).getTotalPopulation() > 0);
    }

    // Test that invalid country should return empty result
    @Test
    void report29InvalidCountryReturnsEmpty(){
        String country = "Atlantis";
        List<PopulationReport> result = app.reports.getPopulationByCountry(populationConnection, country);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Test that null country should return empty result
    @Test
    void report29NullCountryReturnsEmpty(){
        String country = null;
        List<PopulationReport> result = app.reports.getPopulationByCountry(populationConnection, country);
        assertTrue(result.isEmpty());
    }

    // Test that empty country should return empty result
    @Test
    void report29EmptyCountryReturnsEmpty(){
        String country = "";
        List<PopulationReport> result = app.reports.getPopulationByCountry(populationConnection, country);
        assertTrue(result.isEmpty());
    }

    // Test that the report has the correct columns
    @Test
    void report29CorrectColumns(){
        String country = "United Kingdom";
        List<PopulationReport> result = app.reports.getPopulationByCountry(populationConnection, country);
        assertFalse(result.isEmpty());

        for (PopulationReport r : result){
            assertNotNull(r.getAreaName());
            assertTrue(r.getTotalPopulation() > 0);
            assertTrue(r.getCityPopulation() >= 0);
            assertTrue(r.hasCityBreakdown());
        }
    }

    // Test that null connection should return empty result
    @Test
    void report29NullConnectionReturnsEmpty(){
        String country = "United Kingdom";
        List<PopulationReport> result = app.reports.getPopulationByCountry(null, country);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Report 30: The population of a district (Issue #34)

    // Test that it returns population information
    @Test
    void report30ReturnPopulation(){
        String district = "Maharashtra";
        List<PopulationReport> result = app.reports.getPopulationByDistrict(populationConnection, district);
        assertFalse(result.isEmpty());
    }

    // Test that the district has the correct total population
    @Test
    void report30CorrectPopulation(){
        String district = "Maharashtra";
        List<PopulationReport> result = app.reports.getPopulationByDistrict(populationConnection, district);
        assertFalse(result.isEmpty());

        assertTrue(result.get(0).getTotalPopulation() > 0);
    }

    // Test that invalid district should return empty result
    @Test
    void report30InvalidDistrictReturnsEmpty(){
        String district = "Atlantis";
        List<PopulationReport> result = app.reports.getPopulationByDistrict(populationConnection, district);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Test that null district should return empty result
    @Test
    void report30NullDistrictReturnsEmpty(){
        String district = null;
        List<PopulationReport> result = app.reports.getPopulationByDistrict(populationConnection, district);
        assertTrue(result.isEmpty());
    }

    // Test that empty district should return empty result
    @Test
    void report30EmptyDistrictReturnsEmpty(){
        String district = "";
        List<PopulationReport> result = app.reports.getPopulationByDistrict(populationConnection, district);
        assertTrue(result.isEmpty());
    }

    // Test that the report has the correct columns
    @Test
    void report30CorrectColumns(){
        String district = "Maharashtra";
        List<PopulationReport> result = app.reports.getPopulationByDistrict(populationConnection, district);
        assertFalse(result.isEmpty());

        for (PopulationReport r : result){
            assertNotNull(r.getAreaName());
            assertTrue(r.getTotalPopulation() > 0);
            assertTrue(r.getCityPopulation() >= 0);
            assertTrue(r.hasCityBreakdown());
        }
    }

    // Test that null connection should return empty result
    @Test
    void report30NullConnectionReturnsEmpty(){
        String district = "Maharashtra";
        List<PopulationReport> result = app.reports.getPopulationByDistrict(null, district);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }


    // Issue 35: The population of a city (Report 31)

    //Test that it returns a population report
    @Test
    void report31ReturnsPopulation(){
        String city = "London";
        List <PopulationReport> result = app.reports.getPopulationByCity(populationConnection, city);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    // Test that the city has the correct total population
    @Test
    void report31CorrectPopulation(){
        String city = "London";
        List<PopulationReport> result = app.reports.getPopulationByCity(populationConnection, city);
        assertFalse(result.isEmpty());

        assertTrue(result.get(0).getTotalPopulation() > 0);
    }

    // Test that invalid city should return empty result
    @Test
    void report31InvalidCityReturnsEmpty(){
        String city = "Atlantis";
        List<PopulationReport> result = app.reports.getPopulationByCity(populationConnection, city);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Test that null city should return empty result
    @Test
    void report31NullCityReturnsEmpty(){
        String city = null;
        List<PopulationReport> result = app.reports.getPopulationByCity(populationConnection, city);
        assertTrue(result.isEmpty());
    }

    // Test that empty city should return empty result
    @Test
    void report31EmptyCityReturnsEmpty(){
        String city = "";
        List<PopulationReport> result = app.reports.getPopulationByCity(populationConnection, city);
        assertTrue(result.isEmpty());
    }

    // Test that the report has the correct columns
    @Test
    void report31CorrectColumns(){
        String city = "London";
        List<PopulationReport> result = app.reports.getPopulationByCity(populationConnection, city);
        assertFalse(result.isEmpty());

        for (PopulationReport r : result){
            assertNotNull(r.getAreaName());
            assertTrue(r.getTotalPopulation() > 0);
            assertTrue(r.getCityPopulation() > 0);
            assertTrue(r.hasCityBreakdown());
        }
    }

    // Test that null connection should return empty result
    @Test
    void report31NullConnectionReturnsEmpty(){
        String city = "London";
        List<PopulationReport> result = app.reports.getPopulationByCity(null, city);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }


}
