package com.napier.sem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PrintReportMarkdown {
    /**
     * Outputs City Report as Markdown file in folder
     *
     * @param cities list of cities
     * @param filename name of Markdown file
     */
    public void outputCityReport(List<City> cities, String filename){

        // If countries is null, return
        if (cities == null){
            System.out.println("No Cities");
            return;
        }

        // If the file name does end with .md, add
        if (!filename.endsWith(".md")){
            filename += ".md";
        }

        //New String builder
        StringBuilder sb = new StringBuilder();

        // Print header
        sb.append("| Name | Country | District | Population | \r\n");
        sb.append("| --- | --- | --- | --- |\r\n");

        // Loop the through countries in the list and add to string builder
        for (City c : cities){
            if(c == null) continue;
            sb.append("| " + c.getName() + " | " + c.getCountry() +  " | " + c.getDistrict() + " | " + c.getPopulation() + " |\r\n");
        }
        try {
            // Create new folder
            new File("./reports/").mkdir();
            // Create new file
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));
            // Add
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Outputs Country Report as Markdown file in folder
     *
     * @param countries list of countries
     * @param filename name of Markdown file
     */
    public void outputCountryReport(List<Country> countries, String filename){

        // If countries is null, return
        if (countries == null){
            System.out.println("No Countries");
            return;
        }

        // If the file name does end with .md, add
        if (!filename.endsWith(".md")){
            filename += ".md";
        }

        //New String builder
        StringBuilder sb = new StringBuilder();

        //
        // Print header
        sb.append("| Code | Name | Continent | Region | Population | Capital | \r\n");
        sb.append("| --- | --- | --- | --- | --- | --- |\r\n");

        // Loop the through countries in the list and add to string builder
        for (Country c : countries){
            if(c == null) continue;
            sb.append("| " + c.getCode() + " | " + c.getName() +  " | " + c.getContinent() + " | " + c.getRegion() + " | " + c.getPopulation() + " |\r\n");
        }
        try {
            // Create new folder
            new File("./reports/").mkdir();
            // Create new file
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));
            // Add
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Outputs Capital Cities Report as Markdown file in folder
     *
     * @param capitalCities list of countries
     * @param filename name of Markdown file
     */
    public void outputCapitalCityReport(List<CapitalCity> capitalCities, String filename){

        // If countries is null, return
        if (capitalCities == null){
            System.out.println("No Capital Cities");
            return;
        }

        // If the file name does end with .md, add
        if (!filename.endsWith(".md")){
            filename += ".md";
        }

        //New String builder
        StringBuilder sb = new StringBuilder();

        // Print header
        sb.append("| Name | Country | Population |\r\n");
        sb.append("| --- | --- | --- |\r\n");

        // Loop the through countries in the list and add to string builder
        for (CapitalCity c : capitalCities){
            if(c == null) continue;
            sb.append("| " + c.getName() + " | " + c.getCountry() +  c.getPopulation() + " |\r\n");
        }
        try {
            // Create new folder
            new File("./reports/").mkdir();
            // Create new file
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));
            // Add
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Outputs Population Report as Markdown file in folder
     *
     * @param populationReports list of population reports
     * @param filename name of Markdown file
     */
    public void outputPopulationReport(List<PopulationReport> populationReports, String filename){

        // If population reports is null, return
        if (populationReports == null){
            System.out.println("No Population Reports");
            return;
        }

        // If the file name does not end with .md, add
        if (!filename.endsWith(".md")){
            filename += ".md";
        }

        // New String builder
        StringBuilder sb = new StringBuilder();

        // Check if the report includes a city breakdown
        boolean includesCityBreakdown = !populationReports.isEmpty()
                && populationReports.get(0) != null
                && populationReports.get(0).hasCityBreakdown();

        // Print header
        if (includesCityBreakdown) {
            sb.append("| Area | Total | In cities | Outside cities |\r\n");
            sb.append("| --- | ---: | ---: | ---: |\r\n");
        } else {
            sb.append("| Area | Total population |\r\n");
            sb.append("| --- | ---: |\r\n");
        }

        // Loop through population reports and add to string builder
        for (PopulationReport p : populationReports){
            if (p == null) continue;

            if (p.hasCityBreakdown()) {
                sb.append(String.format(
                        "| %s | %,d | %,d (%.2f%%) | %,d (%.2f%%) |\r\n",
                        p.getAreaName(),
                        p.getTotalPopulation(),
                        p.getCityPopulation(),
                        p.getCityPercentage(),
                        p.getNonCityPopulation(),
                        p.getNonCityPercentage()
                ));
            } else {
                sb.append(String.format(
                        "| %s | %,d |\r\n",
                        p.getAreaName(),
                        p.getTotalPopulation()
                ));
            }
        }

        try {
            // Create new folder
            new File("./reports/").mkdir();

            // Create new file
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));

            // Add
            writer.write(sb.toString());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Outputs Language Report as Markdown file in folder
     *
     * @param languages list of languages
     * @param filename name of Markdown file
     */
    public void outputLanguageReport(List<Language> languages, String filename){

        // If languages is null, return
        if (languages == null){
            System.out.println("No Language Reports");
            return;
        }

        // If the file name does not end with .md, add
        if (!filename.endsWith(".md")){
            filename += ".md";
        }

        // New String builder
        StringBuilder sb = new StringBuilder();

        // Print header
        sb.append("| Language | Speakers | World population |\r\n");
        sb.append("| --- | ---: | ---: |\r\n");

        // Loop through languages and add to string builder
        for (Language l : languages){
            if (l == null) continue;

            sb.append(String.format(
                    "| %s | %,d | %.2f%% |\r\n",
                    l.getName(),
                    l.getTotalSpeakers(),
                    l.getWorldPercentage()
            ));
        }

        try {
            // Create new folder
            new File("./reports/").mkdir();

            // Create new file
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));

            // Add
            writer.write(sb.toString());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
