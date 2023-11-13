package Services;

public class Service {
    private String serviceID;
    private int level;
    private String type;

    public Service(String serviceID, int level, String type) {
        this.serviceID = serviceID;
        this.level = level;
        this.type = type;
    }

    public void upgradeService() {
            // Implementation to upgrade the service
    }

    public void destroyService() {
            // Implementation to destroy the service
    }
    }
