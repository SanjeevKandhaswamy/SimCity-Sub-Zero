import java.awt.Point;
import Buildings.*;
import Util.*;
import Main.GamePanel;
import Main.Map;
import Services.Park;

public class App {
    public static void main(String[] args) throws Exception {
        int mapSize = 10; // Map size
        Map cityMap = new Map(mapSize);
        cityMap.initializeMap();
        String[][] map = new String[mapSize][mapSize];
        Location l1 = new Location(1, 0);
        Park p1 = new Park("P1", 1, 25, l1, cityMap);
        p1.buildPark();

        Points points = cityMap.getPoints(); // Get the Points instance from the cityMap
        Point startingPoint = points.getPoint(new Point(2, 2));
        System.out.println("Starting Point: " + startingPoint);

        // Update the map based on changes made in the buildPark method
        map = cityMap.getMap();
        cityMap.DisplayMap();

        // Create a GamePanel with the updated map
        GamePanel gamePanel = new GamePanel(map);
        gamePanel.displayPanel();

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

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
