import Buildings.*;
import Util.Location;
import Util.RandomMap;
import Util.Points;
import Main.GamePanel;
import Main.Map;
import Services.Park;

public class App {
    public static void main(String[] args) throws Exception {
        int mapSize = 15; // Map size
        Map cityMap = new Map(mapSize);
        cityMap.initializeMap();
        String[][] map = new String[mapSize][mapSize];
        Location l1 = new Location(1, 0);
        Park p1 = new Park("P1", 1, 25, l1, cityMap);
        p1.buildPark();

        // Update the map based on changes made in the buildPark method
        map = cityMap.getMap();
        cityMap.DisplayMap();

        // Create a GamePanel with the updated map
        GamePanel gamePanel = new GamePanel(map);
        gamePanel.displayPanel();
    }
}

