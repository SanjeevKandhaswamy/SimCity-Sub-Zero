import Main.GamePanel;
import Main.Map;
import Util.RandomMap;
import Util.Location;
import Buildings.Building;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello");

        // Create a Map with a size s
        int s = 10;
        Map citymap = new Map(s);
        citymap.initializeMap();

        GamePanel gamePanel = new GamePanel(citymap.getMap());

        // Generate a random map and populate cityMap using placeObject
        Building[][] randomMap = RandomMap.generateRandomMap(s);
        for (int i = 0; i < randomMap.length; i++) {
            for (int j = 0; j < randomMap[i].length; j++) {
                Building building = randomMap[i][j];
                if (building != null) {
                    // Check if the area is available before placing the object
                    if (citymap.isAreaAvailable(i, j, 1, 1)) {
                        citymap.placeObject(new String[][]{{building.getType()}}, i, j);
                    }
                }
            }
        }

        // Display the map
        citymap.DisplayMap();
        gamePanel.displayPanel();
        System.out.println(gamePanel.getCoordinates());
    }
}
