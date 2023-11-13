package Infrastructure.Waste;
import Infrastructure.InfrastructureElement;

public class DumpYard extends InfrastructureElement {
    private int capacity;

    public DumpYard(String infraID, int level) {
        super(infraID, "WasteDumpYard", level);
        this.capacity = 80; // Default capacity
    }
}
