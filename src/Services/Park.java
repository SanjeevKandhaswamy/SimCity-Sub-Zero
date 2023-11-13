package Services;

public class Park extends Service {
    private int boostPercentage;

    public Park(String serviceID, int level) {
        super(serviceID, level, "Park");
        this.boostPercentage = 10; // Default boost percentage
    }

    public int getBoostPercentage() {
        return boostPercentage;
       }
}
