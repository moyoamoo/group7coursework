package com.napier.sem;

import java.io.File;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ProduceMarkdownUnitTests {

    static PrintReportMarkdown reports;

    @BeforeAll
    static void init() {
        reports = new PrintReportMarkdown();
    }

    // Dummy Country
    private List<Country> countryList(int size)
    {
        List<Country> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            list.add(new Country("C" + i, "Country" + i, "Europe", "Western Europe", 1000 - i, "Capital" + i));
        }
        return list;
    }


    // Dummy City
    private List<City> cityList(int size)
    {
        List<City> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            list.add(new City("City" + i, "Country" + i, "District" + i, 1000 - i));
        }
        return list;
    }

    //Dummy Capital City
    private List<CapitalCity> capitalCityList(int size)
    {
        List<CapitalCity> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            list.add(new CapitalCity("Capital" + i, "Country" + i, 1000 - i));
        }
        return list;
    }

    // Country Report

    // Test that a country report is created
    @Test
    void outputCountryReportProducesMarkdownFile(){
        List<Country> countries = countryList(10);
        String filename = "test1.md";
        String reportName = "test";
        File file = new File("./reports/" + filename);

        try{
            reports.outputCountryReport(countries, filename, reportName);
            assertTrue(file.exists(), "Markdown file should have been created");

        } finally {
            file.delete();
        }
    }

    // Test that a null report prints console message
    @Test
    void outputCountryReportNullPrintsMessage(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String filename = "nulltest.md";
        String reportName = "test";


        try {
            reports.outputCountryReport(null, filename, reportName);
        } finally {
            System.setOut(originalOut);   // always restore, or later tests lose their output
        }

        assertTrue(output.toString().contains("No Countries"));
    }

    // Test that a report is created if .md is not added
    @Test
    void outputCountryReportAddMDToFilename(){
        List<Country> countries = countryList(10);
        String filename = "test2";
        String reportName = "test";

        File file = new File("./reports/" + filename + ".md");

        try{
            reports.outputCountryReport(countries, filename + ".md", reportName);
            assertTrue(file.exists(), "Markdown file should have been created");
        } finally {
            file.delete();
        }

    }

    // City Report

    // Test that a report is created
    @Test
    void outputCityReportProducesMarkdownFile(){
        List<City> cities = cityList(10);
        String filename = "test3.md";
        String reportName = "test";

        File file = new File("./reports/" + filename);

        try{
            reports.outputCityReport(cities, filename, reportName);
            assertTrue(file.exists(), "Markdown file should have been created");

        } finally {
            file.delete();
        }
    }

    // Test that a null report prints console message
    @Test
    void outputCityReportNullPrintsMessage(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String filename = "nulltest.md";
        String reportName = "test";


        try {
            reports.outputCityReport(null, filename, reportName);
        } finally {
            System.setOut(originalOut);   // always restore, or later tests lose their output
        }

        assertTrue(output.toString().contains("No Cities"));
    }

    // Test that a report is created if .md is not added
    @Test
    void outputCityReportAddMDToFilname(){
        List<City> cities = cityList(10);
        String filename = "test4";
        String reportName = "test";
        File file = new File("./reports/" + filename + ".md");

        try{
            reports.outputCityReport(cities, filename + ".md", reportName);
            assertTrue(file.exists(), "Markdown file should have been created");
        } finally {
            file.delete();
        }
    }

    // Capital City Report

    // Test that a report is created
    @Test
    void outputCapitalCityReportProducesMarkdownFile(){
        List<CapitalCity> capitalCities = capitalCityList(10);
        String filename = "test5.md";
        String reportName = "test";
        File file = new File("./reports/" + filename);

        try{
            reports.outputCapitalCityReport(capitalCities, filename, reportName);
            assertTrue(file.exists(), "Markdown file should have been created");

        } finally {
            file.delete();
        }
    }

    // Test that a null report prints console message
    @Test
    void outputCapitalCityReportNullPrintsMessage(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String filename = "nulltest.md";
        String reportName = "test";


        try {
            reports.outputCapitalCityReport(null, filename, reportName);
        } finally {
            System.setOut(originalOut);   // always restore, or later tests lose their output
        }

        assertTrue(output.toString().contains("No Capital Cities"));
    }

    // Test that a report is created if .md is not added
    @Test
    void outputCaptialCityReportAddMDToFilname(){
        List<CapitalCity> capitalCities = capitalCityList(10);
        String filename = "test6";
        File file = new File("./reports/" + filename + ".md");
        String reportName = "test";


        try{
            reports.outputCapitalCityReport(capitalCities, filename + ".md", reportName);
            assertTrue(file.exists(), "Markdown file should have been created");
        } finally {
            file.delete();
        }

    }


    // Test that a report is created
    @Test
    void outputPopulationReportProducesMarkdownFile(){
        List<PopulationReport> populationReports = List.of(
                new PopulationReport("France", 59225700L, 9244494L),
                new PopulationReport("Germany", 82164700L, 50000000L)
        );
        String filename = "test9.md";
        String reportName = "test";
        File file = new File("./reports/" + filename);

        try{
            reports.outputPopulationReport(populationReports, filename, reportName);
            assertTrue(file.exists(), "Markdown file should have been created");

        } finally {
            file.delete();
        }
    }

    // Test that a null report prints console message
    @Test
    void outputPopulationReportNullPrintsMessage(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String filename = "nulltest.md";
        String reportName = "test";

        try {
            reports.outputPopulationReport(null, filename, reportName);
        } finally {
            System.setOut(originalOut);   // always restore, or later tests lose their output
        }

        assertTrue(output.toString().contains("No Population Reports"));
    }

    // Test that a report is created if .md is not added
    @Test
    void outputPopulationReportAddMDToFilename(){
        List<PopulationReport> populationReports = List.of(
                new PopulationReport("France", 59225700L, 9244494L)
        );
        String filename = "test10";
        File file = new File("./reports/" + filename + ".md");
        String reportName = "test";

        try{
            reports.outputPopulationReport(populationReports, filename, reportName);
            assertTrue(file.exists(), "Markdown file should have been created");
        } finally {
            file.delete();
        }
    }

}
