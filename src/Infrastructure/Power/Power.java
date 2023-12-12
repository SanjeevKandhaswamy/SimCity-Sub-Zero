package Infrastructure.Power;
import Infrastructure.InfrastructureElement;

public class Power extends InfrastructureElement {
    private int demand = 40000; // Default customizable value

    public Power(String infraID, int level, int demand) {
        super(infraID, "Power", level);
        this.demand = demand;
    }

    public int getDemand() {
        return demand;
    }

    // Override displayInfo to include power-specific information.
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Power Demand: " + demand + " MW");
    }

    // Function to upgrade the infrastructure
    public int upgradeInfrastructure() {
        return super.upgradeInfrastructure();
    }

    // Function to destroy the infrastructure
    public String destroyInfrastructure() {
        return super.destroyInfrastructure();
    }

    // Method to expand power supply
    public void expandPowerSupply(int expandSupply) {
        // Logic to expand power supply
        this.demand+= expandSupply ; // For example, increase supply by expandSupply in MW
    }

    @Override
    public boolean performDestruction() {
        return true;
    }
//
//    // Method to get power demand from a building
//    private int getPowerDemand(Building building) {
//        // Placeholder logic, replace it with your actual logic to get demand from the building
//        return 20; // Example demand value
//    }

}
