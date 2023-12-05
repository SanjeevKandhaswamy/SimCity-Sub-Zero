package Infrastructure.Power;
import Infrastructure.InfrastructureElement;

public class PowerGenerator extends Power {
    private int supply;

    public PowerGenerator(String infraID, int level, int demand, int supply) {
        super(infraID, level, demand);
        this.supply = supply;
    }

    // Method to check if the power supply is sufficient for a building
    public boolean isSupplySufficient(Building building) {
        if ("Power".equals(building.getType())) {
            int demand = getPowerDemand(building); // Assume a method to get demand from the building
            return supply >= demand;
        }
        return false;
    }

    // Method to expand power supply
    public void expandPowerSupply() {
        // Logic to expand power supply
        System.out.println("Expanding Power Supply for " + getInfraID());
        supply += 10; // For example, increase supply by 10 MW
    }

    // Method to get power demand from a building
    private int getPowerDemand(Building building) {
        // Placeholder logic, replace it with your actual logic to get demand from the building
        return 20; // Example demand value
    }

    // Override displayInfo to include generator-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Power Supply: " + supply + " MW");
    }

    // Function to update power supply
    public void updateSupply(int newSupply) {
        this.supply = newSupply;
        System.out.println("Power Supply Updated to: " + newSupply + " MW");
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
