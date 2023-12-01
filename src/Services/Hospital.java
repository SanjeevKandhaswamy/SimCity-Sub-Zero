package Services;
import Util.Location;
import Buildings.ResidentialBuilding;

public class Hospital extends Service {
    private int healthcareCapacity;
    private int boostHealthcareCapacity;
    private Location location;

    public Hospital(String serviceID, int level, int healthcareCapacity, int x, int y) {
        super(serviceID, level, "Hospital");
        this.healthcareCapacity = healthcareCapacity;
        this.boostHealthcareCapacity = 10; // Default boost value for healthcare capacity
        setLocation(x, y);
    }

    // Set location coordinates of the hospital
    public void setLocation(int x, int y) {
        this.location.setLocation(x, y);
    }

    @Override
    public void performUpgrade() {
        super.performUpgrade(); // Optional

        this.healthcareCapacity += boostHealthcareCapacity; // Customizable boost value for healthcare capacity
        buildHospital(); // Updating the hospital after healthcare capacity is updated
    }

    public void buildHospital() {
        // Checks whether area is available
        if (!(GameMap.isAreaAvailable(location.getX(), location.getY(), this.healthcareCapacity))) {
            System.err.println("Selected Location is already occupied");
        }

        int side = (int) Math.sqrt(this.healthcareCapacity); // Calculating the length of the side of the hospital
        char[][] hospital = new char[side][side]; // Declaring a new hospital using size

        for (int i = 0; i <= hospital.length - 1; i++) {
            for (int j = 0; j <= hospital[i].length - 1; j++) {
                hospital[i][j] = ' ';
            }
        }

        // Filling the hospital borders with '+' and the inside area with 'H'.
        int hospitalSize = healthcareCapacity / 10;  // Adjust for the hospital size
        for (int i = 1; i <= hospitalSize; i++) {
            for (int j = 1; j <= hospitalSize; j++) {
                if (i == 1 || i == hospitalSize || j == 1 || j == hospitalSize) {
                    if (i < hospital.length && j < hospital[i].length) {
                        hospital[i][j] = '+';
                    }
                } else {
                    hospital[i][j] = 'H';
                }
            }
        }

        GameMap.placeObject(hospital, location.getX(), location.getY());
    }

    @Override
    public void performDestruction() {
        super.performDestruction();
        int size = (int) Math.sqrt(healthcareCapacity);
        GameMap.destroyObject(size, location.getX(), location.getY());
    }
}