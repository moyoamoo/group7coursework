package com.napier.sem;

/**
 * Represents a country from the world database
 */
public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;
    private int population;
    private String capital;

    // Constructor
    public Country(String code, String name, String continent, String region, int population, String capital){
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }

    // Getters
    public String getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    public String getContinent(){
        return continent;
    }

    public String getRegion(){
        return region;
    }

    public int getPopulation(){
        return population;
    }

    public String getCapital(){
        return capital;
    }

    // Return Country class contents as string
    @Override
        public String toString(){
            return "Country{" +
                    "Code=" + code +
                    ", Name='" + name + '\'' +
                    ", Continent='" + continent + '\'' +
                    ", Region='" + region + '\'' +
                    ", Capital='" + capital + '\'' +
                    ", Population=" + population +
                    '}';
        }

}
