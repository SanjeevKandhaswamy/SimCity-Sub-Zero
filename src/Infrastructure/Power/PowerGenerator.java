package Infrastructure.Power;
import Infrastructure.InfrastructureElement;

public class PowerGenerator extends Power {
    private int supply;

    public PowerGenerator(String infraID, int level, int demand, int supply) {
        super(infraID, level, demand);
        this.supply = supply;
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
}
