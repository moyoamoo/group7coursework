package com.napier.sem;

public class Reports {
    private static final String[] reports  = {"All the countries in the world organised by largest population to smallest",
                                                "All the countries in a continent organised by largest population to smallest",
                                "All the countries in a region organised by largest population to smallest"};


    public String[] getReports() {
        return reports.clone();
    }

    public int count() {
        return reports.length;
    }

    /** Get single report title from array
     *
     * @param reportNumber Number shown to user, not reports index in array
     * @return reports Title of report
     */
    public String getReports(int reportNumber) {
        return reports[reportNumber - 1];
    }

    public void displayReports(String prompt){
        System.out.println(prompt);
        for (int i = 0; i < reports.length; i++){
            System.out.println((i + 1) + ". " + reports[i]);
        }
    }
}
