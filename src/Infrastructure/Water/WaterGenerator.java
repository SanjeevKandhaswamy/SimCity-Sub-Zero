package Infrastructure.Water;
import Infrastructure.InfrastructureElement;

public class WaterGenerator extends InfrastructureElement {
    private int supply;

    public WaterGenerator(String infraID, int level) {
        super(infraID, "WaterGenerator", level);
        this.supply = 20; // Default supply
    }
}