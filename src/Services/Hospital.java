package Services;

public class Hospital extends Service {
    private int capacity;
    private int boostPercentage;

    public Hospital(String serviceID, int level) {
        super(serviceID, level, "Hospital");
        this.capacity = 100; // Default capacity
        this.boostPercentage = 15; // Default boost percentage
    }
}
