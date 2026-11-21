package com.napier.sem;


public class Language {

    private String name;
    private long totalSpeakers;
    private double worldPercentage;

    // Constructor
    public Language(String name, long totalSpeakers, double worldPercentage) {
            this.name = name;
            this.totalSpeakers = totalSpeakers;
            this.worldPercentage = worldPercentage;
    }

    // Language Getters
    public String getName() {
        return name;
    }

    public long getTotalSpeakers() {
        return totalSpeakers;
    }

    public double getWorldPercentage() {
        return worldPercentage;
    }


    @Override
        public String toString() {
            return String.format(
                    "%s | Speakers: %,d | World population: %.2f%%",
                    name, totalSpeakers, worldPercentage
            );
        }
    }