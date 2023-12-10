// Park.java
package Services;

import Util.Location;
import Main.GameMap;

public class Park extends Service {
    private int boostPercentage;
    private int greenSpace;
    private int boostgreenSpace;
    private Location location;
    private GameMap GameMap;

    public Park(String serviceID, int level, int greenSpace, Location location, GameMap gameMap) {
        super(serviceID, level, "Park");
        this.boostPercentage = 10;   // Default boost percentage
        this.greenSpace = greenSpace;
        this.boostgreenSpace = 5; // Default boost value for green space
        this.location = new Location(location.getX(), location.getY());
        this.GameMap = gameMap;
    }

    // Set location coordinates of the park
    public void setLocation(int x, int y) {
        this.location.setLocation(x, y);
    }

    // Setter method for boostPercentage
    public void setBoostPercentage(int boostPercentage) {
        this.boostPercentage = boostPercentage;
    }

    public boolean buildPark() {
        int side = (int) Math.sqrt(this.greenSpace);
        String[][] park = new String[side][side];

        // Checks whether the area is available
        if (!(GameMap.isAreaAvailable(location.getX(), location.getY(), side, side))) {
            return false;
        }

        for (int i = 0; i <= park.length - 1; i++) {
            for (int j = 0; j <= park[i].length - 1; j++) {
                park[i][j] = " ";
            }
        }

        int grass = 0x0001F33F;
        for (int i = 0; i <= side - 1; i++) {
            for (int j = 0; j <= side - 1; j++) {
                if (i == 0 || i == side - 1 || j == 0 || j == side - 1) {
                    if (i < park.length && j < park[i].length) {
                        park[i][j] = " +";
                    }
                } else {
                    park[i][j] = Character.toString(grass);
                }
            }
        }

        // Call placeObject and update the GameMap directly
        if (GameMap.placeObject(park, location.getX(), location.getY())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean performDestruction() {
        int size = (int) Math.sqrt(greenSpace);
        if (GameMap.destroyObject(size, size, location.getX(), location.getY())) {
            return true;
        }
        return false;
    }
}
