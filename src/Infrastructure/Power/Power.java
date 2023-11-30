package Infrastructure.Power;

import Infrastructure.InfrastructureElement;

public class Power extends InfrastructureElement {
    private int demand;

    public Power(String infraID, int level, int demand) {
        super(infraID, "Power", level);
        this.demand = demand;
    }

    // Override displayInfo to include power-specific information.
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Power Demand: " + demand + " MW");
    }

    // Function to build power supply.
    public void buildPowerSupply() {
        // Implement build logic
        System.out.println("Building Power Supply for: " + getInfraID());
    }

    // Function to destroy power supply
    public void destroyPowerSupply() {
        // Implement destroy logic
        System.out.println("Destroying Power Supply for: " + getInfraID());
    }

    // Function to check power demand
    public void checkDemand() {
        System.out.println("Checking Power Demand for: " + getInfraID());
        // Implement demand check logic
    }
}
