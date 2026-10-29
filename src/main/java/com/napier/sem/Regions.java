package com.napier.sem;
/**
 * Represents regions from the world database
 */
public class Regions {
    public final String[] regions = {
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

    /** Get copy of regions array
     *
     * @return returns copy of regions array
     */
    public String[] getRegions() {
        return regions.clone();
    }

    /** Get region array length
     *
     * @return returns length
     */
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

    /** Display list of Regions
     *
     * @param prompt Text shown to user
     */
    public void displayRegions(String prompt){
        System.out.println(prompt);
        for (int i = 0; i < regions.length; i++){
            System.out.println((i + 1) + ". " + regions[i]);
        }
    }
}
