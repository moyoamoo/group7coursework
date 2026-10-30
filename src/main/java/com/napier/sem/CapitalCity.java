package com.napier.sem;

/**
 * Represents a capital city from the world database
 */
public class CapitalCity {
     private String name;
     private String country;
     private int population;

     //Constructor
     public CapitalCity(String name, String country, int population){
         this.name = name;
         this.country = country;
         this.population = population;
     }

     //Getters
    public String getName(){
         return name;
    }
    public String getCountry(){
         return country;
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
                 "Population='" + population +
                 '}';
    }

}
