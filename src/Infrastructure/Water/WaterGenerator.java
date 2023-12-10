package Infrastructure.Water;

import Infrastructure.InfrastructureElement;

// Custom exception class for maximum level reached
class MaxLevelReachedException extends Exception {
    public MaxLevelReachedException(String message) {
        super(message);
    }
}

public class WaterGenerator extends InfrastructureElement {
    private int supply;
    private int efficiencyLevel;
    private boolean upgradedFilters;
    private boolean smartControlEnabled;
    private boolean waterQualityMonitoring;

    public WaterGenerator(String infraID, int level, int supply, int efficiencyLevel) {
        super(infraID, "WaterGenerator", level);
        this.supply = supply;
        this.efficiencyLevel = efficiencyLevel;
        this.upgradedFilters = false;
        this.smartControlEnabled = false;
        this.waterQualityMonitoring = false;
    }

    public int getSupply() {
        return supply;
    }

    public int getEfficiencyLevel() {
        return efficiencyLevel;
    }

    public boolean hasUpgradedFilters() {
        return upgradedFilters;
    }

    public boolean isSmartControlEnabled() {
        return smartControlEnabled;
    }

    public boolean isWaterQualityMonitoring() {
        return waterQualityMonitoring;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Water Supply: " + supply + " gallons per day");
        System.out.println("Efficiency Level: " + efficiencyLevel);
        System.out.println("Upgraded Filters: " + (upgradedFilters ? "Yes" : "No"));
        System.out.println("Smart Control Enabled: " + (smartControlEnabled ? "Yes" : "No"));
        System.out.println("Water Quality Monitoring: " + (waterQualityMonitoring ? "Yes" : "No"));
    }

    public void upgradeInfrastructure() throws MaxLevelReachedException {
        int status = super.upgradeInfrastructure();
        if (status == -1) {
            throw new MaxLevelReachedException("Water Infrastructure is already at maximum level.");
        }
        this.efficiencyLevel++;
    }

    public void installUpgradedFilters() {
        this.upgradedFilters = true;
    }

    public void enableSmartControl() {
        this.smartControlEnabled = true;
    }

    public void enableWaterQualityMonitoring() {
        this.waterQualityMonitoring = true;
        System.out.println("Water quality monitoring enabled.");
    }

    public void monitorWaterQuality() {
        if (waterQualityMonitoring) {
            System.out.println("Monitoring water quality. No issues detected.");
        } else {
            System.out.println("Water quality monitoring is not enabled.");
        }
    }

    public void emergencyShutdown() {
        System.out.println("Emergency water shutdown initiated. Stopping water generation.");
        // Add logic for emergency shutdown as needed
    }

    public void generateWater() {
        double generationRate = supply * (efficiencyLevel / 10.0);

        if (upgradedFilters) {
            generationRate *= 1.2;
        }

        if (smartControlEnabled) {
            int currentDemand = getCurrentWaterDemand(); // Replace with your actual method to get demand

            // Adjust generation based on demand
            if (currentDemand > generationRate) {
                generationRate = currentDemand;
                System.out.println("Adjusting generation rate to meet demand.");
            } else {
                generationRate *= 0.8; // For example, reduce generation by 20%
                System.out.println("Adjusting generation rate to conserve water.");
            }
        }

        System.out.println("Generating " + generationRate + " gallons of water per day.");
    }

    // Replace this method with your actual method to get water demand
    private int getCurrentWaterDemand() {
        // Example: Return a placeholder value
        return 5000; // gallons per day
    }
}
