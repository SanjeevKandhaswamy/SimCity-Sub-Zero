package Services;

public class PublicTransport extends Service {
    private int capacity;
    private int trafficReducePercentage;

    public PublicTransport(String serviceID, int level) {
        super(serviceID, level, "PublicTransport");
        this.capacity = 100; // Default capacity
        this.trafficReducePercentage = 20; // Default traffic reduce percentage
    }

    public void reduceTraffic() {
         // Implementation to reduce traffic
    }
}