package com.napier.sem;

/** SQL for issues #28-#33. */
public final class PopulationReportQueries {
    private PopulationReportQueries() { }

    // Aggregate city population per country first, so country population is not multiplied by city count.
    private static final String CITY_POPULATION_JOIN =
            "FROM country c LEFT JOIN (SELECT CountryCode, SUM(Population) AS CityPopulation " +
            "FROM city GROUP BY CountryCode) cp ON cp.CountryCode = c.Code ";

    // Report 23
    // The population of people, people living in cities, and people not living in cities in each continent (Issue 28)
    public static final String DISTRIBUTION_BY_CONTINENT =
            "SELECT c.Continent AS AreaName, SUM(c.Population) AS TotalPopulation, " +
            "SUM(COALESCE(cp.CityPopulation, 0)) AS CityPopulation " + CITY_POPULATION_JOIN +
            "GROUP BY c.Continent ORDER BY c.Continent";

    // Report 24
    // The population of people, people living in cities, and people not living in cities in each region (Issue 29)
    public static final String DISTRIBUTION_BY_REGION =
            "SELECT c.Region AS AreaName, SUM(c.Population) AS TotalPopulation, " +
            "SUM(COALESCE(cp.CityPopulation, 0)) AS CityPopulation " + CITY_POPULATION_JOIN +
            "GROUP BY c.Region ORDER BY c.Region";

    // Report 25
    // The population of people, people living in cities, and people not living in cities in each country (Issue 30)
    public static final String DISTRIBUTION_BY_COUNTRY =
            "SELECT c.Name AS AreaName, c.Population AS TotalPopulation, " +
            "COALESCE(cp.CityPopulation, 0) AS CityPopulation " + CITY_POPULATION_JOIN +
            "ORDER BY c.Name";

    // Report 27
    // The population of a continent (Issue 31)
    public static final String POPULATION_BY_CONTINENT =
            "SELECT c.Continent AS AreaName, " +
                    "SUM(c.Population) AS TotalPopulation, " +
                    "SUM(COALESCE(cp.CityPopulation, 0)) AS CityPopulation " +
                    CITY_POPULATION_JOIN +
                    "WHERE c.Continent = ? " +
                    "GROUP BY c.Continent";

    /* Report 28
   / The population of a region (Issue 32) */
    public static final String POPULATION_BY_REGION =
            "SELECT c.Region AS AreaName, " +
                    "SUM(c.Population) AS TotalPopulation, " +
                    "SUM(COALESCE(cp.CityPopulation, 0)) AS CityPopulation " +
                    CITY_POPULATION_JOIN +
                    "WHERE c.Region = ? " +
                    "GROUP BY c.Region";

    /* Report 29
   / The population of a country (Issue 33) */
    public static final String POPULATION_BY_COUNTRY =
            "SELECT c.Name AS AreaName, c.Population AS TotalPopulation, " +
                    "COALESCE(cp.CityPopulation, 0) AS CityPopulation " + CITY_POPULATION_JOIN +
                    "WHERE c.NAME = ?";

    /* Report 30
    / The population of a district (Issue 34) */
    public static final String POPULATION_BY_DISTRICT =
            "SELECT ci.District AS AreaName, " +
                    "SUM(ci.Population) AS TotalPopulation, " +
                    "SUM(ci.Population) AS CityPopulation " +
                    "FROM city ci " +
                    "WHERE ci.District = ? " +
                    "GROUP BY ci.District";

    /* Report 31
     * The population of a city (Issue 35) */
    public static final String POPULATION_BY_CITY =
            "SELECT ci.Name AS AreaName, " +
                    "c.Name AS Country, " +
                    "ci.Population AS TotalPopulation, " +
                    "ci.Population AS CityPopulation " +
                    "FROM city ci " +
                    "JOIN country c ON ci.CountryCode = c.Code " +
                    "WHERE ci.Name = ?";

    /* Report 32
     * Number of people who speak Chinese, English, Hindi,
     * Spanish and Arabic, from greatest to smallest,
     * including percentage of world population (Issue 36) */
    public static final String POPULATION_BY_LANGUAGE =
            "SELECT cl.Language AS AreaName, " +
                    "SUM(c.Population * cl.Percentage / 100) AS TotalSpeakers, " +
                    "ROUND(SUM(c.Population * cl.Percentage / 100) * 100 / " +
                    "(SELECT SUM(Population) FROM country), 2) AS WorldPercentage " +
                    "FROM countrylanguage cl " +
                    "JOIN country c ON cl.CountryCode = c.Code " +
                    "WHERE cl.Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') " +
                    "GROUP BY cl.Language " +
                    "ORDER BY TotalSpeakers DESC";

}
