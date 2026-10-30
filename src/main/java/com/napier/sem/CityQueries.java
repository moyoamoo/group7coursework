package com.napier.sem;

public class CityQueries {

    // Issue #22: All cities with Name, Country, District, Population

    public static final String ALL_CITIES =
            "SELECT ci.Name,c.Name AS Country, ci.District, ci.Population " +
            "FROM  city ci " +
            "JOIN country c ON ci.CountryCode = c.Code " +
            "ORDER BY  ci.Population DESC";

    // Issue #23: Top N capital cities in the world
    public static final String TOP_N_CAPITALS_WORLD=
            "SELECT ci.name, c.Name AS Country, ci.Population " +
            "FROM city ci " +
            "Join country c ON ci.ID = c.Capital "+
            "ORDER BY ci.Population DESC " +
            "LIMIT ?";

    // Issue #24: All capitals cities in a continent
    public static final String CAPITALS_BY_CONTINENT =
            "SELECT ci.Name, c.Name AS country, ci.Population " +
            "FROM city ci " +
            "JOIN country c ON ci.ID = c.Capital " +
            "WHERE c.Continent = ? " +
            "ORDER BY ci.Population DESC";

    // Issue #26: Top N capital cities in a continent
    public static final String TOP_N_CAPITALS_BY_CONTINENT=
            "SELECT ci.Name, c.Name AS Country, ci.Population " +
            "FROM city ci " +
            "JOIN country c ON ci.ID = c.Capital " +
            "WHERE c.Continent = ? " +
            "ORDER BY ci.Population DESC " +
            "LIMIT ?";

    // Issue #25 & 27: Top N capital Cities in a region
    public static final String TOP_N_CAPITALS_BY_REGION =
            "SELECT ci.Name, c.Name AS Country, ci.Population " +
            "FROM city ci " +
            "JOIN country c ON ci.ID = c.Capital " +
            "WHERE c.Region = ? " +
            "ORDER BY ci.Population DESC " +
            "LIMIT ?";
}


