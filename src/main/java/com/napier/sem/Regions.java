package com.napier.sem;

public class Regions {
    private final String[] regions = {
            "Antarctica",
            "Australia and New Zealand",
            "Baltic Countries",
            "British Islands",
            "Caribbean",
            "Central Africa",
            "Central America",
            "Eastern Africa",
            "Eastern Asia",
            "Eastern Europe",
            "Melanesia",
            "Micronesia",
            "Micronesia/Caribbean",
            "Middle East",
            "Nordic Countries",
            "North America",
            "Northern Africa",
            "Polynesia",
            "South America",
            "Southeast Asia",
            "Southern Africa",
            "Southern Europe",
            "Southern and Central Asia",
            "Western Africa",
            "Western Europe"
    };

    public String[] getRegions() {
        return regions.clone();
    }

    public int count() {
        return regions.length;
    }

    /** Get region name from array
     *
     * @param regionNumber Number shown to user, not region index in array
     * @return region name
     */
    public String getRegion(int regionNumber) {
        return regions[regionNumber - 1];
    }

    public void displayRegions(String prompt){
        System.out.println(prompt);
        for (int i = 0; i < regions.length; i++){
            System.out.println((i + 1) + ". " + regions[i]);
        }
    }
}
