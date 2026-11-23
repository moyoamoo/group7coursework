package com.napier.sem;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LanguageUnitTest {
    Reports reports = new Reports();
    PrintReportConsole consoleReports = new PrintReportConsole();

    @Test
    void report32NullConnectionReturnsEmpty(){
        List<Language> result = reports.getPopulationByLanguage(null);
        assertTrue(result.isEmpty());
    }
}
