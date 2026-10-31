package com.napier.sem;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationUnitTest {
    Reports reports = new Reports();

    CityConnection dummyCityConnect = null;
    CapitalCityConnection dummyCapitalConnection = null;

    //UNIT TESTS ISSUE 14: cities in a continent
    @Test
    void test14invalidContinentsReturnsEmpty() {
        List<City> result = reports.getAllCitiesInContinent(dummyCityConnect, "Narnia");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }

    @Test
    void test14NullContinentReturnsEmpty() {
        List<City> result = reports.getAllCitiesInContinent(dummyCityConnect, null);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for null continent");
    }

    //UNIT TESTS ISSUE 15: cities in a country
    @Test
    void test15InvalidCountryReturnsEmpty() {
        List<City> result = reports.getAllCitiesInCountry(dummyCityConnect, "XYZ");
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid country");
    }

    //UNTI TESTS ISSUE 26: Top N capitals in a continent
    @Test
    void test26InvalidContinentReturnsEmpty() {
        List<CapitalCity> result = reports.getTopNCapitalsByContinent(dummyCapitalConnection, "Narnia", 3);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list for invalid continent");
    }
}
