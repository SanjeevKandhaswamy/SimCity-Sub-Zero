import Main.GamePanel;
import Main.Map;
import Util.RandomMap;
import Buildings.Building;

public class App {
    public static void main(String[] args) throws Exception {
        int mapSize = 5;  // Adjust the map size as needed
        Building[][] randomMap = RandomMap.generateRandomMap(mapSize);

        // Print the generated map
        System.out.println("Generated Random Map:");
        for (Building[] row : randomMap) {
            for (Building building : row) {
                System.out.print((building != null) ? building.getType() : "null");
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
