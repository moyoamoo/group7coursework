package com.napier.sem;

/** SQL for issues #28-#33. */
public final class PopulationReportQueries {
    private PopulationReportQueries() { }

    // Aggregate city population per country first, so country population is not multiplied by city count.
    private static final String CITY_POPULATION_JOIN =
            " FROM country c LEFT JOIN (SELECT CountryCode, SUM(Population) AS CityPopulation " +
            "FROM city GROUP BY CountryCode) cp ON cp.CountryCode = c.Code ";

    public static final String DISTRIBUTION_BY_CONTINENT =
            "SELECT c.Continent AS AreaName, SUM(c.Population) AS TotalPopulation, " +
            "SUM(COALESCE(cp.CityPopulation, 0)) AS CityPopulation " + CITY_POPULATION_JOIN +
            "GROUP BY c.Continent ORDER BY c.Continent";

    public static final String DISTRIBUTION_BY_REGION =
            "SELECT c.Region AS AreaName, SUM(c.Population) AS TotalPopulation, " +
            "SUM(COALESCE(cp.CityPopulation, 0)) AS CityPopulation " + CITY_POPULATION_JOIN +
            "GROUP BY c.Region ORDER BY c.Region";

    public static final String DISTRIBUTION_BY_COUNTRY =
            "SELECT c.Name AS AreaName, c.Population AS TotalPopulation, " +
            "COALESCE(cp.CityPopulation, 0) AS CityPopulation " + CITY_POPULATION_JOIN +
            "ORDER BY c.Name";

    public static final String TOTAL_BY_CONTINENT =
            "SELECT Continent AS AreaName, SUM(Population) AS TotalPopulation " +
            "FROM country GROUP BY Continent ORDER BY Continent";

    public static final String TOTAL_BY_REGION =
            "SELECT Region AS AreaName, SUM(Population) AS TotalPopulation " +
            "FROM country GROUP BY Region ORDER BY Region";

    public static final String TOTAL_BY_COUNTRY =
            "SELECT Name AS AreaName, Population AS TotalPopulation " +
            "FROM country ORDER BY Population DESC";

    // Backwards-compatible names used by the earlier implementation.
    public static final String BY_REGION =
            "SELECT c.Name AS AreaName, c.Population AS TotalPopulation, " +
            "COALESCE(cp.CityPopulation, 0) AS CityPopulation " + CITY_POPULATION_JOIN +
            "WHERE c.Region = ? ORDER BY c.Name";
    public static final String BY_COUNTRY =
            "SELECT c.Name AS AreaName, c.Population AS TotalPopulation, " +
            "COALESCE(cp.CityPopulation, 0) AS CityPopulation " + CITY_POPULATION_JOIN +
            "WHERE c.Name = ?";
}
