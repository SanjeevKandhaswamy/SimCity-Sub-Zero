package Infrastructure.Demand;
import Infrastructure.InfrastructureElement;

public class PowerSupply extends InfrastructureElement {
    private int demand;

    public PowerSupply(String infraID, int level) {
        super(infraID, "PowerSupply", level);
        this.demand = 50; // Default demand
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }
}
