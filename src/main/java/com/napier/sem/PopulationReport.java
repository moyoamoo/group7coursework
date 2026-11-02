package com.napier.sem;

/** One row in a population report. */
public class PopulationReport {
    private final String areaName;
    private final int totalPopulation;
    private final int cityPopulation;
    private final boolean includesCityBreakdown;

    public PopulationReport(String areaName, int totalPopulation, int cityPopulation) {
        this(areaName, totalPopulation, cityPopulation, true);
    }

    public PopulationReport(String areaName, int totalPopulation) {
        this(areaName, totalPopulation, 0, false);
    }

    private PopulationReport(String areaName, int totalPopulation, int cityPopulation, boolean includesCityBreakdown) {
        this.areaName = areaName;
        this.totalPopulation = totalPopulation;
        this.cityPopulation = cityPopulation;
        this.includesCityBreakdown = includesCityBreakdown;
    }

    public String getAreaName() { return areaName; }
    /** Kept for compatibility with the earlier country-level implementation. */
    public String getCountryName() { return areaName; }
    public int getTotalPopulation() { return totalPopulation; }
    public int getCityPopulation() { return cityPopulation; }
    public int getNonCityPopulation() { return Math.max(0, totalPopulation - cityPopulation); }
    public boolean hasCityBreakdown() { return includesCityBreakdown; }
    public double getCityPercentage() { return totalPopulation <= 0 ? 0.0 : cityPopulation * 100.0 / totalPopulation; }
    public double getNonCityPercentage() { return totalPopulation <= 0 ? 0.0 : getNonCityPopulation() * 100.0 / totalPopulation; }

    @Override public String toString() {
        if (!includesCityBreakdown) return String.format("%s | Total population: %d", areaName, totalPopulation);
        return String.format("%s | Total: %d | In cities: %d (%.2f%%) | Outside cities: %d (%.2f%%)",
                areaName, totalPopulation, cityPopulation, getCityPercentage(),
                getNonCityPopulation(), getNonCityPercentage());
    }
}
