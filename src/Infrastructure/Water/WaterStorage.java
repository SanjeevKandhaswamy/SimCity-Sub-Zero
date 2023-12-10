package Infrastructure.Water;

import Infrastructure.InfrastructureElement;

public class WaterStorage extends InfrastructureElement {
    private int capacity;
    private int currentWaterLevel;
    private boolean waterQualityMonitoring;
    private int contaminationLevel;

    public WaterStorage(String infraID, int level, int capacity) {
        super(infraID, "WaterStorage", level);
        this.capacity = (capacity > 0) ? capacity : 100; // Default capacity
        this.currentWaterLevel = 0; // Start with an empty water storage
        this.waterQualityMonitoring = false;
        this.contaminationLevel = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = (capacity > 0) ? capacity : 100; // Ensure a positive capacity
    }

    public int getCurrentWaterLevel() {
        return currentWaterLevel;
    }

    public void fillWater(int amount) {
        if (amount > 0) {
            int spaceLeft = capacity - currentWaterLevel;
            int actualFill = Math.min(amount, spaceLeft);
            currentWaterLevel += actualFill;
            System.out.println("Filled " + actualFill + " gallons of water. Current level: " + currentWaterLevel);
        } else {
            System.out.println("Invalid amount. Please provide a positive value.");
        }
    }

    public void consumeWater(int amount) {
        if (amount > 0) {
            int actualConsumption = Math.min(amount, currentWaterLevel);
            currentWaterLevel -= actualConsumption;
            System.out.println("Consumed " + actualConsumption + " gallons of water. Current level: " + currentWaterLevel);
        } else {
            System.out.println("Invalid amount. Please provide a positive value.");
        }
    }

    public void enableWaterQualityMonitoring() {
        this.waterQualityMonitoring = true;
        System.out.println("Water quality monitoring enabled.");
    }

    public void checkWaterQuality() {
        if (waterQualityMonitoring) {
            System.out.println("Checking water quality...");
            // Add your logic to check water quality based on current conditions, contamination level, etc.
            if (contaminationLevel > 50) {
                System.out.println("Water quality is poor. Contamination level: " + contaminationLevel);
            } else {
                System.out.println("Water quality is good. Contamination level: " + contaminationLevel);
            }
        } else {
            System.out.println("Water quality monitoring is not enabled.");
        }
    }

    public void setContaminationLevel(int contaminationLevel) {
        this.contaminationLevel = (contaminationLevel >= 0) ? contaminationLevel : 0;
        System.out.println("Contamination level set to: " + this.contaminationLevel);
    }

    public void filterWater() {
        if (contaminationLevel > 0) {
            System.out.println("Filtering water to reduce contamination...");
            // Add your logic to filter water based on current contamination level
            contaminationLevel = Math.max(contaminationLevel - 20, 0);
            System.out.println("Water filtered. New contamination level: " + contaminationLevel);
        } else {
            System.out.println("Water is already clean. No need for filtering.");
        }
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Capacity: " + capacity + " gallons");
        System.out.println("Current Water Level: " + currentWaterLevel + " gallons");
        System.out.println("Water Quality Monitoring: " + (waterQualityMonitoring ? "Yes" : "No"));
        System.out.println("Contamination Level: " + contaminationLevel);
    }
}
