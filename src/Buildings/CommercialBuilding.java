package Buildings;
import Main.Map;
import Util.Location;

public class CommercialBuilding extends Building{
	
	private int income;
  private Map GameMap;
  private Location location;
  private String id;
  private int level;
	
  public CommercialBuilding(String id, Location location, int level, Map gameMap) {
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
  
      String[][] commercialBuilding = new String[side][side]; // Declaring a new commercial building using size
  
      for (int i = 0; i < commercialBuilding.length; i++) {
          for (int j = 0; j < commercialBuilding[i].length; j++) {
              commercialBuilding[i][j] = "C";
          }
      }
  
      if (GameMap.placeObject(commercialBuilding, location.getX(), location.getY())) {
          return true;
      } else {
          return false;
      }
  }
    
    public void IncreaseIncome() {
    	
    }
    
    public void UpdateCapital() {
    	
    }

    @Override
    public String getType() {
        return "C";
    }
}
