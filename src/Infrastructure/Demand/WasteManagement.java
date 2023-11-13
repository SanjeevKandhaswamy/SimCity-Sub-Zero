package Infrastructure.Demand;

import Infrastructure.InfrastructureElement;

public class WasteManagement extends InfrastructureElement {
    private int demand;

    public WasteManagement(String infraID, int level) {
        super(infraID, "WasteManagement", level);
        this.demand = 30; // Default demand
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }
}
