package com.napier.sem;


public class UserInput {
    private final Continents continents = new Continents();
    private final Regions regions = new Regions();
    private final Country countries = new Country("", "", "", "", 0, "");

    public int numberOfCountries = 239;

    public Boolean getValidContinent(String continent){

       //Check if continent is valid
       boolean validInput = false;
       for (String c : continents.continents){
           if(c.equals(continent)){
               validInput = true;
               break;
           }
       }

       return validInput;
    }

    public Boolean getValidRegion(String region){

        //Check if region is valid
        boolean validInput = false;
        for (String c : regions.regions){
            if(c.equals(region)){
                validInput = true;
                break;
            }
        }

        return validInput;
    }

    public Boolean getValidCountry(String country){

        //Check if country is valid
        boolean validInput = false;
        for (String c : countries.countries){
            if(c.equals(country)){
                validInput = true;
                break;
            }
        }

        return validInput;
    }




}
