package Infrastructure.Demand;
import Infrastructure.InfrastructureElement;

public class WaterSupply extends InfrastructureElement {
    private int demand;

    public WaterSupply(String infraID, int level) {
        super(infraID, "WaterSupply", level);
        this.demand = 40; // Default demand
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }
}
