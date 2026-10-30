package com.napier.sem;

public class CityQueries {

    // All the cities in the world organised by largest population to smallest (Report 7)
    public static final String ALL_CITIES =
            "SELECT ci.Name,c.Name AS Country, ci.District, ci.Population " +
                    "FROM  city ci " +
                    "JOIN country c ON ci.CountryCode = c.Code " +
                    "ORDER BY ci.Population DESC";


    // All the cities in a continent organised by largest population to smallest (Report 8)
    public static final String ALL_CITIES_IN_CONTINENT =
            "SELECT ci.Name,c.Name AS Country, ci.District, ci.Population " +
                    "FROM  city ci " +
                    "JOIN country c ON ci.CountryCode = c.Code " +
                    "WHERE c.Continent = ? " +
                    "ORDER BY ci.Population DESC";

    // All the cities in a country organised by largest population to smallest. (Report 10)
    public static final String ALL_CITIES_IN_COUNTRY =
            "SELECT ci.Name, c.Name AS Country, ci.District, ci.Population " +
                    "FROM  city ci " +
                    "JOIN country c ON ci.CountryCode = c.Code " +
                    "WHERE c.Name = ? " +
                    "ORDER BY ci.Population DESC";


    // The top N populated cities in a region where N is provided by the user (Report 14)
    public static final String ALL_CITIES_IN_REGION =
            "SELECT ci.Name, c.Name AS Country, ci.District, ci.Population " +
                    "FROM  city ci " +
                    "JOIN country c ON ci.CountryCode = c.Code " +
                    "WHERE c.Region = ? " +
                    "ORDER BY ci.Population DESC " +
                    "LIMIT ?";


}