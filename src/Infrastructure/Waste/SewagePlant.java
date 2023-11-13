package Infrastructure.Waste;
import Infrastructure.InfrastructureElement;

public class SewagePlant extends InfrastructureElement {
    private int capacity;

    public SewagePlant(String infraID, int level) {
        super(infraID, "SewagePlant", level);
        this.capacity = 70; // Default capacity
    }
}
