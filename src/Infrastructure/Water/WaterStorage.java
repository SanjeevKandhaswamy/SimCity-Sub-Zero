package Infrastructure.Water;
import Infrastructure.InfrastructureElement;

public class WaterStorage extends InfrastructureElement {
    private int capacity;

    public WaterStorage(String infraID, int level) {
        super(infraID, "WaterStorage", level);
        this.capacity = 100; // Default capacity
    }
}
