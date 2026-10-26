package com.napier.sem;

/**
 * Represents a city from the world database
 */
public class City {
     private String name;
     private String country;
     private String district;
     private int population;

     //Constructor
     public City(String name, String country, String district, int population){
         this.name = name;
         this.country = country;
         this.district = district;
         this.population = population;
     }
     //Getters
    public String getName(){
         return name;
    }

    public String getCountry(){
         return country;
    }

    public String getDistrict(){
         return district;
    }

    public int getPopulation(){
         return population;
    }

    //Return City class contents as a string
    @Override
    public String toString(){
         return "City{" +
                 "Name='" + name + '\'' +
                 "Country='" + country +'\''+
                 "District='" + district + '\''+
                 "Population='" + population +
                 '}';
    }

}
