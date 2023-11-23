package Buildings;
import Util.Location;
import Economy.Capital;


public class Building {
    private String building_id;
    private Location location;
    private String type;
    private int level;

    public Capital capital;

    // Constructor
    public Building(String id, Location location, String type, int level) {
        this.building_id = id;
        this.location = location;
        this.type = type;
        this.level = level;
    }

    public int upgradeCost(int level){
        switch (level) {
            case 1:
                return 100;
            case 2:
                return 300;
            case 3:
                return 500;
            case 4:
                return 750;
            case 5:
                return 1000;

            default:
                return 0;
        }
    }

    public void UpgradeBuilding(String building_id, int level){
        int cost = upgradeCost(level);
        if (capital.checkSufficientCapital(cost)){
            capital.setCapital(capital.getCapital()-cost);
            this.level += 1;
        }
        else{
            System.err.println("Not enough Money!");
        }

    }

    public void DestroyBuilding(String building_id) {
        this.location = null;
    }
}
