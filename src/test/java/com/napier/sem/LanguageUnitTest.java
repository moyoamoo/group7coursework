package com.napier.sem;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LanguageUnitTest {
    Reports reports = new Reports();
    PrintReportConsole consoleReports = new PrintReportConsole();

    /** Issue 36
     * The number of people who speak Chinese, English, Hindi,
     * Spanish, Arabic from greatest number to smallest,
     * including the percentage of the world population  (Report 32) */

    @Test
    void report32NullConnectionReturnsEmpty(){
        List<Language> result = reports.getPopulationByLanguage(null);
        assertTrue(result.isEmpty());
    }
}
