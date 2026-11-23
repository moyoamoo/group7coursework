package com.napier.sem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LanguageUnitTest {
    Reports reports = new Reports();
    PrintReportConsole consoleReports = new PrintReportConsole();

    //Dummy Language
    private List<Language> languageList(int size)
    {
        List<Language> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            list.add(new Language("Name", i, 1000 - i));
        }
        return list;
    }

    @Test
    void languageClassGetName(){
        int n = 5;
        List<Language> list = languageList(n);
        String firstLanguage = list.get(0).getName();
        assertFalse(firstLanguage.isEmpty());
    }

    @Test
    void languageClassGetTotalSpeakers(){
        int n = 5;
        List<Language> list = languageList(n);
        Long firstTotalSpeakers = list.get(0).getTotalSpeakers();
        assertTrue(firstTotalSpeakers >= 0,
                "Total speakers should be zero or greater");
    }

    @Test
    void languageClassGetWorldPercetnage(){
        int n = 5;
        List<Language> list = languageList(n);
        double worldPercetange = list.get(0).getWorldPercentage();
        assertTrue(worldPercetange >= 0,
                "World Perecentage should be zero or greater");
    }

    @Test
    void report32NullConnectionReturnsEmpty(){
        List<Language> result = reports.getPopulationByLanguage(null);
        assertTrue(result.isEmpty());
    }
}
