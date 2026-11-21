
package com.napier.sem;

// Represents a population report from world db
public class PopulationReport {
    private final String areaName;
    private final long totalPopulation;
    private final long cityPopulation;
    private final boolean includesCityBreakdown;

    // Population Report Constructors
    public PopulationReport(String areaName, long totalPopulation, long cityPopulation) {
        this(areaName, totalPopulation, cityPopulation, true);
    }

    public PopulationReport(String areaName, long totalPopulation) {
        this(areaName, totalPopulation, 0L, false);
    }

    private PopulationReport(String areaName, long totalPopulation, long cityPopulation, boolean includesCityBreakdown) {
        this.areaName = areaName;
        this.totalPopulation = totalPopulation;
        this.cityPopulation = cityPopulation;
        this.includesCityBreakdown = includesCityBreakdown;
    }

    // Population Report Getters
    public String getAreaName() { return areaName; }
    public String getCountryName() { return areaName; }
    public long getTotalPopulation() { return totalPopulation; }
    public long getCityPopulation() { return cityPopulation; }
    public long getNonCityPopulation() { return Math.max(0L, totalPopulation - cityPopulation); }
    public boolean hasCityBreakdown() { return includesCityBreakdown; }
    public double getCityPercentage() { return totalPopulation <= 0 ? 0.0 : cityPopulation * 100.0 / totalPopulation; }
    public double getNonCityPercentage() { return totalPopulation <= 0 ? 0.0 : getNonCityPopulation() * 100.0 / totalPopulation; }

    @Override
    public String toString() {
        if (!includesCityBreakdown) {
            return String.format("%s | Total population: %,d", areaName, totalPopulation);
        }

        return String.format("%s | Total: %,d | In cities: %,d (%.2f%%) | Outside cities: %,d (%.2f%%)",
                areaName, totalPopulation, cityPopulation, getCityPercentage(),
                getNonCityPopulation(), getNonCityPercentage());
    }
}
