package com.napier.sem;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CapitalCityUnitTest {
    Reports reports = new Reports();
    PrintReportConsole consoleReports = new PrintReportConsole();

    CapitalCityConnection dummyCapitalConnection = null;

    //Report 17
    //All Capital Cities In The World
    @Test
    void report17NullConnectionReturnsEmpty(){
        List<CapitalCity> result = reports.getAllCapitals(dummyCapitalConnection);
        assertNotNull(result);
        assertTrue(result.isEmpty(),"Should return empty lists for null connection");
    }

    //report 18
    //UNIT TEST ISSUE 24: All capital  cities in  a continent
    @Test
    void report18InvalidContinentReturnsEmpty() {
        List<CapitalCity> result = reports.getCapitalsByContinent(dummyCapitalConnection, "Narnia");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }

    @Test
    void report18NullContinentReturnsEmpty(){
        List<CapitalCity> result = reports.getCapitalsByContinent(dummyCapitalConnection, null);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return an empty list for null continent");
    }

    @Test
    void report18BlankContinentReturnsEmpty() {
        List<CapitalCity> result = reports.getCapitalsByContinent(dummyCapitalConnection, "");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for blank continent");
    }

    //Report 19
    //Issue 131: All Capital Cities In a Region
    @Test
    void report19InvalidRegionReturnsEmpty() {
        List<CapitalCity> result = reports.getCapitalsByRegion(dummyCapitalConnection, "Narnia");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid region");
    }

    @Test
    void report19NullRegionReturnsEmpty(){
        List<CapitalCity> result = reports.getCapitalsByRegion(dummyCapitalConnection, null);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return an empty list for null region");
    }

    @Test
    void report19BlankRegionReturnsEmpty() {
        List<CapitalCity> result = reports.getCapitalsByRegion(dummyCapitalConnection, "");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for blank region");
    }

    //report 20
    //UNIT TESTS ISSUE 27: The top N populated capital cities in the world where N is provided by the user
    @Test
    void report20InvalidNReturnsEmpty() {
        int n = -1;
        List<CapitalCity> result = reports.getTopNCapitalsWorld(dummyCapitalConnection, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }

    // Report 21
    // UNIT TESTS ISSUE 26: Top N capitals in a continent
    @Test
    void report21InvalidContinentReturnsEmpty() {
        String continent = "Narnia";
        int n = 3;
        List<CapitalCity> result = reports.getTopNCapitalsByContinent(dummyCapitalConnection, continent, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }

    @Test
    void report21InvalidNReturnsEmpty() {
        String continent = "Africa";
        int n = -1;
        List<CapitalCity> result = reports.getTopNCapitalsByContinent(dummyCapitalConnection, continent, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }

    // Report 22
    // UNIT TESTS ISSUE 25: Top N capitals in a Region
    @Test
    void report22InvalidRegionReturnsEmpty() {
        String region = "Narnia";
        int n = 3;
        List<CapitalCity> result = reports.getTopNCapitalsByRegion(dummyCapitalConnection, region, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }

    @Test
    void report22InvalidNReturnsEmpty() {
        String region = "Central America";
        int n = -1;
        List<CapitalCity> result = reports.getTopNCapitalsByRegion(dummyCapitalConnection, region, n);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }
}
