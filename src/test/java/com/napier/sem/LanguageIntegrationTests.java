package com.napier.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LanguageIntegrationTests {
    static App app;
    Reports reports = new Reports();

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @AfterAll
    static void tearDown()
    {
        app.disconnect();
    }

    /** Issue 36
     * The number of people who speak Chinese, English, Hindi,
     * Spanish, Arabic from greatest number to smallest,
     * including the percentage of the world population  (Report 32) */

    // Test that language report is returned from db
    @Test
    void report32ReturnLanguages(){
        List<Language> result = app.reports.getPopulationByLanguage(app.languageConnect);
        assertEquals(5, result.size());
    }


    // Test that languages are in ascending order
    @Test
    void report32OrderedByPopDesc(){
        List<Language> result = app.reports.getPopulationByLanguage(app.languageConnect);
        assertFalse(result.isEmpty());
        for (int i = 1; i < result.size(); i++){
            assertTrue(result.get(i - 1).getTotalSpeakers() >= result.get(i).getTotalSpeakers());
        }
    }

}
