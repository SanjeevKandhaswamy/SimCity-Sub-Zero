import Buildings.*;
import Util.RandomMap;
import Main.GamePanel;

public class App {
    public static void main(String[] args) throws Exception {
        int mapSize = 10; //Map size
        Building[][] randomMap = RandomMap.generateRandomMap(mapSize);

        // Create a GamePanel with the random map
        GamePanel gamePanel = new GamePanel(convertToStringArray(randomMap));
        
        // Display the GamePanel
        gamePanel.displayPanel();
        
        // Access the coordinates
        System.out.println("Clicked at coordinates: " + gamePanel.getCoordinates());
    }

    // Helper method to convert Building[][] to String[][]
    private static String[][] convertToStringArray(Building[][] buildingMap) {
        String[][] stringArray = new String[buildingMap.length][buildingMap[0].length];

        for (int i = 0; i < buildingMap.length; i++) {
            for (int j = 0; j < buildingMap[i].length; j++) {
                Building building = buildingMap[i][j];
                stringArray[i][j] = (building != null) ? building.getType() : "null";
            }
        }
        return stringArray;
    }
}
