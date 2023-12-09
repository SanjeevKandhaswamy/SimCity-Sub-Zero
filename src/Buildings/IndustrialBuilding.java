package Buildings;
import Main.Map;
import Util.Location;

public class IndustrialBuilding extends Building{
    private int income;
    private Map GameMap;
    private Location location;
    private String id;
    private int level;

    public IndustrialBuilding(String id, Location location, int level, Map gameMap) {
      this.id = id;
      this.location = location;
      this.level = level;
      this.GameMap = gameMap;
    }
    
    @Override
    public Boolean buildBuilding() {
      int side = 1;

      // Checks whether the area is available
      if (!(GameMap.isAreaAvailable(location.getX(), location.getY(), side, side))) {
          return false;
      }

      String[][] residentialBuilding = new String[side][side]; // Declaring a new residential building using size

      for (int i = 0; i < residentialBuilding.length; i++) {
          for (int j = 0; j < residentialBuilding[i].length; j++) {
              residentialBuilding[i][j] = "L";
          }
      }

      if (GameMap.placeObject(residentialBuilding, location.getX(), location.getY())) {
          return true;
      } else {
          return false;
      }
    }

}
