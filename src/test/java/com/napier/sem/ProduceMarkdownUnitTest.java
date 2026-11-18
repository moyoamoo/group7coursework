package com.napier.sem;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ProduceMarkdownUnitTest {

    static Reports reports;

    @BeforeAll
    static void init() {
        reports = new Reports();
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

    // Test that a report is created
    @Test
    void outputCountryReportProducesMarkdownFile(){
        List<Country> countries = countryList(10);
        String filename = "test1.md";
        File file = new File("./reports/" + filename);

        try{
            reports.outputCountryReport(countries, filename);
            assertTrue(file.exists(), "Markdown file should have been created");

        } finally {
            file.delete();
        }
    }

    // Test that a report is created if .md is not added
    @Test
    void outputCountryReportAddMDToFileanme(){
        List<Country> countries = countryList(10);
        String filename = "test2";
        File file = new File("./reports/" + filename + ".md");

        try{
            reports.outputCountryReport(countries, filename + ".md");
            assertTrue(file.exists(), "Markdown file should have been created");
        } finally {
            file.delete();
        }

    }
}
