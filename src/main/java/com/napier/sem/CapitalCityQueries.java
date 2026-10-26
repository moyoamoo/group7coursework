package com.napier.sem;

public class CapitalCityQueries {
    // The top N populated capital cities in the world where N is provided by the user (Report 20)
    public static final String TOP_N_CAPITALS_WORLD=
            "SELECT ci.name, c.Name AS Country, ci.Population " +
            "FROM city ci " +
            "Join country c ON ci.ID = c.Capital "+
            "ORDER BY ci.Population DESC " +
            "LIMIT ?";


    // The top N populated capital cities in a continent where N is provided by the user (Report 21)
    public static final String TOP_N_CAPITALS_BY_CONTINENT =
            "SELECT ci.Name, c.Name AS Country, ci.Population " +
            "FROM city ci " +
            "JOIN country c ON ci.ID = c.Capital " +
            "WHERE c.Continent = ? " +
            "ORDER BY ci.Population DESC " +
            "LIMIT ?";

    // The top N populated capital cities in a region where N is provided by the user (Report 22)
    public static final String TOP_N_CAPITALS_BY_REGION =
            "SELECT ci.Name, c.Name AS Country, ci.Population " +
            "FROM city ci " +
            "JOIN country c ON ci.ID = c.Capital " +
            "WHERE c.Region = ? " +
            "ORDER BY ci.Population DESC " +
            "LIMIT ?";
}


