package Buildings;
import Main.GameMap;
import Util.Location;

public class CommercialBuilding extends Building{
	
	private int income;
  private GameMap GameMap;
  private Location location;
  private String id;
  private int level;
	
  public CommercialBuilding(String id, Location location, int level, GameMap gameMap) {
      this.id = id;
      this.location = location;
      this.level = level;
      this.GameMap = gameMap;
  }
    
  @Override
  public Boolean buildBuilding() {
  
      // Checks whether the area is available
      if (!(GameMap.isAreaAvailable(location.getX(), location.getY(), 1, 1))) {
          return false;
      }
  
      String[][] commercialBuilding = new String[1][1]; // Declaring a new commercial building using size

      commercialBuilding[0][0] = "C";

  
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
