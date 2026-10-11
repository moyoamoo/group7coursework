package com.napier.sem;

public class Continents {
    private final String[] continents = {
            "Africa",
            "Antarctica",
            "Asia",
            "Europe",
            "North America",
            "Oceania",
            "South America"
    };

    public String[] getRegions() {
        return continents.clone();
    }

    public int count() {
        return continents.length;
    }

    /** Get continent name from array
     *
     * @param continentNumber Number shown to user, not continent index in array
     * @return continent name
     */
    public String getContinent(int continentNumber) {
        return continents[continentNumber - 1];
    }

    /** Display list of Continents
     *
     * @param prompt Text shown to user
     */
    public void displayContinents(String prompt){
        System.out.println(prompt);
        for (int i = 0; i < continents.length; i++){
            System.out.println((i + 1) + ". " + continents[i]);
        }
    }
}
