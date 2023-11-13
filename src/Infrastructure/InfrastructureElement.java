package Infrastructure;

public class InfrastructureElement {
    private String infraID;
    private String type;
    private int level;

    public InfrastructureElement(String infraID, String type, int level) {
        this.infraID = infraID;
        this.type = type;
        this.level = level;
    }

    // Add any other methods or attributes common to all infrastructure elements

    public String getInfraID() {
        return infraID;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }
}
