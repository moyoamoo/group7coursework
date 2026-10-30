package com.napier.sem;

public class City {

    /**
     * Represents a city from the world database
     */

    private String name;
    private String district;
    private String country;
    private int population;

    //Constructor
    public City(String name, String district, String country, int population) {
        this.name = name;
        this.district = district;
        this.country = country;
        this.population = population;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getDistrict() {return district;}

    public String getCountry() {return country;}

    public int getPopulation() {
        return population;
    }

    //Return City class contents as a string
    @Override
    public String toString() {
        return "City{" +
                "Name='" + name + '\'' +
                "Country='" + country + '\'' +
                "District='" + district + '\'' +
                "Population='" + population +
                '}';
    }
}
