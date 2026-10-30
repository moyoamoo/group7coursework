package com.napier.sem;


public class UserInput {
    private final Continents continents = new Continents();
    private final Regions regions = new Regions();

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

}
