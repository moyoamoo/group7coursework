package com.napier.sem;

public class CityQueries {

    // All the cities in the world organised by largest population to smallest (Report 7)
    public static final String ALL_CITIES =
            "SELECT ci.Name,c.Name AS Country, ci.District, ci.Population " +
                    "FROM  city ci " +
                    "JOIN country c ON ci.CountryCode = c.Code " +
                    "ORDER BY  ci.Population DESC";

    // All the cities in a continent organised by largest population to smallest (Report 8)
    public static final String CAPITALS_BY_CONTINENT =
            "SELECT ci.Name, c.Name AS Country, ci.Population " +
                    "FROM city ci " +
                    "JOIN country c ON ci.ID = c.Capital " +
                    "WHERE c.Continent = ? " +
                    "ORDER BY ci.Population DESC";
}
