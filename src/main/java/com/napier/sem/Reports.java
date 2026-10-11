package com.napier.sem;

public class Reports {
    private static final String[] reports  = {"All the countries in the world organised by largest population to smallest",
                                                "All the countries in a continent organised by largest population to smallest",
                                "All the countries in a region organised by largest population to smallest"};


    /** Get copy of reports array
     *
     * @return returns copy of reports array
     */
    public String[] getReports() {
        return reports.clone();
    }

    /** Get reports array length
     *
     * @return returns length
     */
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

    /** Get single report title from array
     *
     * @param prompt text shown to user
     */
    public void displayReports(String prompt){
        System.out.println(prompt);
        for (int i = 0; i < reports.length; i++){
            System.out.println((i + 1) + ". " + reports[i]);
        }
    }
}
