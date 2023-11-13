package Services;

public class PoliceDepartment extends Service {
    private int coverage;

    public PoliceDepartment(String serviceID, int level) {
        super(serviceID, level, "PoliceDepartment");
        this.coverage = 50; // Default coverage
    }
}
