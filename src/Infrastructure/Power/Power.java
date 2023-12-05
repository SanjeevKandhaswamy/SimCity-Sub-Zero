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


}
