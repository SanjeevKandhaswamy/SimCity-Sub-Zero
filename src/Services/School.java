package Services;

public class School extends Service {
    private int capacity;
    private int boostPercentage;

    public School(String serviceID, int level) {
        super(serviceID, level, "School");
        this.capacity = 100; // Default capacity
        this.boostPercentage = 12; // Default boost percentage
    }
}

