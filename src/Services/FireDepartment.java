package Services;

public class FireDepartment extends Service {
    private int coverage;

    public FireDepartment(String serviceID, int level) {
        super(serviceID, level, "FireDepartment");
        this.coverage = 50; // Default coverage
    }
}
