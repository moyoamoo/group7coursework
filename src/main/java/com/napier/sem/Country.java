package com.napier.sem;

/**
 * Represents a city from the world database
 */
public class Country {
    private long code;
    private String name;
    private String continent;
    private String region;
    private long population;
    private String capital;

    public Country(long code, String name, String continent, String region, long population, String capital){
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }
}
