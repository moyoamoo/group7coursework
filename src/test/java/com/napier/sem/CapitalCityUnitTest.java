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

    //report 21
    //UNIT TESTS ISSUE 26: Top N capitals in a continent
    @Test
    void report21InvalidContinentReturnsEmpty() {
        List<CapitalCity> result = reports.getTopNCapitalsByContinent(dummyCapitalConnection, "Narnia", 3);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }
}
