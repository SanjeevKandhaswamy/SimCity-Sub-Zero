package Infrastructure.Water;

import Infrastructure.InfrastructureElement;
import Buildings.Building;
import Util.Location;
import Main.GameMap;

public class WaterGenerator extends WaterManagement {
    private static int noOfGenerators = 0;
    private int waterSupply; // in gallons per day
    private Location location;
    private Map gameMap;
    private int size;
    private boolean advancedPurification;

    public WaterGenerator(String infraID, int level, int demand, int waterSupply, int x, int y, int size) {
        super(infraID, level, demand);
        this.location = new Location(x, y);
        this.waterSupply = (waterSupply > 0) ? waterSupply : 10000; // Default water supply
        this.size = (size > 0) ? size : 50; // Default size of Water Generator
        this.advancedPurification = false;
        WaterGenerator.noOfGenerators++;
    }

    public boolean buildGenerator() {
        int side = this.size; // default
        String[][] waterGeneratorStructure = new String[side][side];

        // Checks whether the area is available
        if (!(gameMap.isAreaAvailable(location.getX(), location.getY(), side, side))) {
            return false;
        }

        for (int i = 0; i < waterGeneratorStructure.length; i++) {
            for (int j = 0; j < waterGeneratorStructure[i].length; j++) {
                waterGeneratorStructure[i][j] = " ";
            }
        }

        // Filling the water generator borders with '+' and the inside area with 'W'.
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                if (i == 0 || i == side - 1 || j == 0 || j == side - 1) {
                    if (i < waterGeneratorStructure.length && j < waterGeneratorStructure[i].length) {
                        waterGeneratorStructure[i][j] = " +";
                    }
                } else {
                    waterGeneratorStructure[i][j] = "W";
                }
            }
        }

        if (gameMap.placeObject(waterGeneratorStructure, location.getX(), location.getY())) {
            return true;
        }
        return false;
    }

    // Function to simulate water consumption by buildings
    public void simulateWaterConsumption(Building building, int days) {
        int waterDemand = calculateWaterDemand(building) * days;
        if (waterSupply >= waterDemand) {
            waterSupply -= waterDemand;
            System.out.println(building.getType() + " consumed " + waterDemand + " gallons of water.");
        } else {
            System.out.println("Insufficient water supply. " + building.getType() + " could not get enough water.");
        }
    }

    // Function to perform regular maintenance
    public void performMaintenance() {
        System.out.println("Performing regular maintenance on the Water Generator.");
        // Add maintenance logic as needed
    }

    // Override displayInfo to include generator-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Total Water Supply Storage: " + this.waterSupply + " gallons per day");
        System.out.println("Advanced Purification: " + (advancedPurification ? "Enabled" : "Disabled"));
    }

    // Function to enable advanced water purification
    public void enableAdvancedPurification() {
        this.advancedPurification = true;
        System.out.println("Advanced water purification enabled.");
    }

    // Function to upgrade water generator
    public void upgradeGenerator(int size, int waterSupply) {
        this.size += (size > 0) ? size : 20; // Increase size by default of 20
        this.waterSupply += (waterSupply > 0) ? waterSupply : 4000; // Increase water supply by default of 4000
        int status = super.upgradeInfrastructure();
        if (status == 0) {
            System.out.println("Not Enough Capital Balance!!");
        } else if (status == -1) {
            System.out.println("Water Infrastructure is already at maximum level..");
        } else if (buildGenerator()) {
            System.out.println("Water Generator Upgraded :)");
        } else {
            System.out.println("Selected area is already occupied!!");
        }
    }

    // Function to destroy water generator
    public void destroyGenerator() {
        int side = this.size; // Default
        if (gameMap.destroyObject(side, side, location.getX(), location.getY())) {
            System.out.println("Water Generator Destroyed :(");
        } else {
            System.out.println("Unable to destroy water generator. Area may be occupied.");
        }
    }
}
