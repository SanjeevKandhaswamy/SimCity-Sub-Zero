import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import Main.GameMap;
import Main.GamePanel;
import Services.Park;
import Util.DialogBox;
import Util.Location;
import Util.Points;
import Buildings.*;

public class App {
    public static void main(String[] args) throws Exception {
        int mapSize = 15; // Map size
        GameMap cityMap = new GameMap(mapSize);
        cityMap.initializeMap();
        String[][] map = new String[mapSize][mapSize];
        Location selectedPoint = new Location(1, 0);
        Park p1 = new Park("P", 1, 25, selectedPoint, cityMap);
        p1.buildPark();

        Points points = cityMap.getPoints(); // Get the Points instance from the cityMap
        //Point startingPoint = points.getPoint(new Point(2, 2));
        //System.out.println("Starting Point: " + startingPoint);

        // Update the map based on changes made in the buildPark method
        map = cityMap.getMap();
        cityMap.DisplayMap();

        // Create a GamePanel with the updated map
        GamePanel gamePanel = new GamePanel(map);
        gamePanel.displayPanel();

        // Map to track building flags
        Map<Point, Integer> buildingFlags = new HashMap<>();

        // Keep checking for the last clicked coordinates in a loop until (0, 0) is clicked
        while (true) {
            Point lastClicked = gamePanel.getLastClickedCoordinates();
            System.out.println("Last clicked coordinates: " + lastClicked);

            // Check if the last clicked coordinates are (9, 9)
            if (lastClicked.equals(new Point(9, 9))) {
                System.out.println("Exiting the loop. Coordinates (9, 9) clicked.");
                break;
            }

            // Map the last clicked point to its initial point
            Point initialPoint = points.getPoint(lastClicked);
            System.out.println("Initial Point for last clicked: " + initialPoint);

            // If initialPoint is null and the building flag is not set, show the dialog box
            if (initialPoint == null && buildingFlags.getOrDefault(lastClicked, 0) == 0 && !(lastClicked.equals(new Point(-1, -1)))) {
                int userChoice = DialogBox.createAndShowDialog();
                Location selectedLocation = new Location((int) lastClicked.getX(), (int) lastClicked.getY());
                System.out.println(lastClicked.getX());
                System.out.println(lastClicked.getY());
                System.out.println(selectedLocation.getX());
                System.out.println(selectedLocation.getY());
                buildingFlags.put(lastClicked, 1);
                if(userChoice == 0) {
                	ResidentialBuilding RB = new ResidentialBuilding("R", selectedLocation, 1, cityMap);
                	RB.buildBuilding();	
                	
                    map = cityMap.getMap();
                    cityMap.DisplayMap();

                    // Create a GamePanel with the updated map
                    gamePanel.updatePanel(map);
                    gamePanel.displayPanel();
                }

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
