package com.napier.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PrintReportUnitTest {

    static Reports reports;

    @BeforeAll
    static void init() {
        reports = new Reports();
    }


    // Dummy Country
    private List<Country> countryList(int size)
    {
        List<Country> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            list.add(new Country("C" + i, "Country" + i, "Europe", "Western Europe", 1000 - i, "Capital" + i));
        }
        return list;
    }

    // Dummy City
    private List<City> cityList(int size)
    {
        List<City> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            list.add(new City("City" + i, "Country" + i, "District" + i, 1000 - i));
        }
        return list;
    }

    //Dummy Capital City
    private List<CapitalCity> capitalCityList(int size)
    {
        List<CapitalCity> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            list.add(new CapitalCity("Capital" + i, "Country" + i, 1000 - i));
        }
        return list;
    }

    // Country

    // Test that country reports empty does not throw
    @Test
    void displayCountryReportsEmptyListDoesNotThrow()
    {
        reports.displayCountryReports(countryList(0));
    }

    @Test
    void displayCountryReportsEmptyListStaysEmpty()
    {
        List<Country> countries = countryList(0);
        reports.displayCountryReports(countries);
        assertTrue(countries.isEmpty());
    }

    // Test that list stays the same size
    @Test
    void displayCountryReportsKeepsSize()
    {
        List<Country> countries = countryList(2);
        reports.displayCountryReports(countries);
        assertEquals(2, countries.size());
    }

    // Test that list is in the same order
    @Test
    void displayCountryReportsKeepsOrder()
    {
        List<Country> countries = countryList(2);
        Country first = countries.get(0);
        Country second = countries.get(1);

        reports.displayCountryReports(countries);

        assertSame(first, countries.get(0));
        assertSame(second, countries.get(1));
    }

    // Test toString method
    @Test
    void displayCountryReportsToStringWorks()
    {
        for (Country c : countryList(2))
        {
            assertNotNull(c.toString());
        }
    }

    @Test
    void displayCountryReportsNullThrows()
    {
        assertThrows(NullPointerException.class, () -> reports.displayCountryReports(null));
    }

    // City


    // Test that country reports empty does not throw
    @Test
    void displayCityReportsEmptyListDoesNotThrow()
    {
        reports.displayCityReports(cityList(0));
    }

    // Test that list keeps its size
    @Test
    void displayCityReportsKeepsSize()
    {
        List<City> cities = cityList(2);
        reports.displayCityReports(cities);
        assertEquals(2, cities.size());
    }

    // Test that list stays in same order
    @Test
    void displayCityReportsKeepsOrder()
    {
        List<City> cities = cityList(2);
        City first = cities.get(0);
        City second = cities.get(1);

        reports.displayCityReports(cities);

        assertSame(first, cities.get(0));
        assertSame(second, cities.get(1));
    }


    @Test
    void displayCityReportsToStringWorks()
    {
        for (City c : cityList(2))
        {
            assertNotNull(c.toString());
        }
    }

    @Test
    void displayCityReportsNullThrows()
    {
        assertThrows(NullPointerException.class, () -> reports.displayCityReports(null));
    }

    // Capital City

    @Test
    void displayCapitalCityReportsEmptyListDoesNotThrow()
    {
        reports.displayCapitalCityReports(capitalCityList(0));
    }

    @Test
    void displayCapitalCityReportsEmptyListStaysEmpty()
    {
        List<CapitalCity> capitals = capitalCityList(0);
        reports.displayCapitalCityReports(capitals);
        assertTrue(capitals.isEmpty());
    }

    @Test
    void displayCapitalCityReportsKeepsSize()
    {
        List<CapitalCity> capitals = capitalCityList(2);
        reports.displayCapitalCityReports(capitals);
        assertEquals(2, capitals.size());
    }

    @Test
    void displayCapitalCityReportsKeepsOrder()
    {
        List<CapitalCity> capitals = capitalCityList(2);
        CapitalCity first = capitals.get(0);
        CapitalCity second = capitals.get(1);

        reports.displayCapitalCityReports(capitals);

        assertSame(first, capitals.get(0));
        assertSame(second, capitals.get(1));
    }

    @Test
    void displayCapitalCityReportsToStringWorks()
    {
        for (CapitalCity c : capitalCityList(2))
        {
            assertNotNull(c.toString());
        }
    }

    @Test
    void displayCapitalCityReportsNullThrows()
    {
        assertThrows(NullPointerException.class, () -> reports.displayCapitalCityReports(null));
    }
}
