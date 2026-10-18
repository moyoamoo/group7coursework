package com.napier.sem;

public class CountryQueries {

    //  SQL Query for all the countries in the world organised by largest population to smallest (Report 1)
    public static final String ALL_COUNTRIES =
            "SELECT c.Name, c.Continent, c.Region, c.Population, c.Code, ci.Name AS CapitalName "
                    + "FROM country c "
                    + "LEFT JOIN city ci ON c.Capital = ci.ID "
                    + "ORDER BY c.Population DESC";

    // SQL Query for all the countries in a continent organised by largest population to smallest (Report 2)
    public static final String COUNTRIES_BY_CONTINENT =
            "SELECT c.Name, c.Continent, c.Region, c.Population, c.Code, ci.Name AS CapitalName "
                    + "FROM country c "
                    + "LEFT JOIN city ci ON c.Capital = ci.ID "
                    + "WHERE c.Continent = ?"
                    + "ORDER BY c.Population DESC";

    // SQL Query for all the countries in a region organised by largest population to smallest (Report 3)
    public static final String COUNTRIES_BY_REGION =
            "SELECT c.Name, c.Continent, c.Region, c.Population, c.Code, ci.Name AS CapitalName "
                    + "FROM country c "
                    + "LEFT JOIN city ci ON c.Capital = ci.ID "
                    + "WHERE c.Region = ? "
                    + "ORDER BY c.Population DESC";

    //SQL Query for the most N populated countries in the world (Report 4)
    public static final String N_COUNTRIES =
            "SELECT c.Name, c.Continent, c.Region, c.Population, c.Code, ci.Name AS CapitalName "
            + "FROM country c "
            + "LEFT JOIN city ci ON c.Capital = ci.ID "
            + "ORDER BY c.Population DESC "
            + "LIMIT ?";

}
