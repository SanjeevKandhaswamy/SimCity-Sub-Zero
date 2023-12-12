import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
// Importing all the packages for creating objects
import Main.*;
import Services.*;
import Util.*;
import Buildings.*;
import Infrastructure.*;
import Infrastructure.Power.*;

public class App {
    public static void main(String[] args) throws Exception {
        int mapSize = 15; // Customizable Map Size for users
        // Instantiating Game map for the city 
        GameMap cityMap = new GameMap(mapSize);
        cityMap.initializeMap(); 
        String[][] map = new String[mapSize][mapSize];

        // Get the Points instance from the cityMap
        Points points = cityMap.getPoints(); 


        // Create a GamePanel with the updated map
        GamePanel gamePanel = new GamePanel(map);
        gamePanel.displayPanel();

        // Map to track building flags
        Map<Point, Integer> buildingFlags = new HashMap<>();
        

        // Keep checking for the last clicked coordinates in a loop until (14, 14) is clicked
        while (true) {
            Point lastClicked = gamePanel.getLastClickedCoordinates();

            // Check if the last clicked coordinates are (9, 9)
            if (lastClicked.equals(new Point(9, 9))) {
                System.out.println("Exiting the loop. Coordinates (9, 9) clicked.");
                break;
            }

            // Map the last clicked point to its respective mapped initial point
            Point initialPoint = points.getPoint(lastClicked);

            // If initialPoint is null and the building flag is not set then the point is free of buildings. Calling a dialog box in that case
            if (initialPoint == null && buildingFlags.getOrDefault(lastClicked, 0) == 0 && !(lastClicked.equals(new Point(-1, -1)))) {
            	
            	// Getting the user input choice from the dialog box
                int userChoice = DialogBox.createAndShowDialog();
                Location selectedLocation = new Location((int) lastClicked.getX(), (int) lastClicked.getY());
                
                // Maintaining a Hash map data structure for storing which points has been utilized for building.
                buildingFlags.put(lastClicked, 1);
                
                // Handling userChoice to create respective buildings objects and calling Build function
                if(userChoice == 0) {
                	ResidentialBuilding RB = new ResidentialBuilding("R", selectedLocation, 1, cityMap);
                	RB.buildBuilding();	
                }
                else if(userChoice == 1) {
                	CommercialBuilding CB = new CommercialBuilding("C", selectedLocation, 1, cityMap);
                	CB.buildBuilding();
                }
                else if(userChoice == 2) {
                	IndustrialBuilding IB = new IndustrialBuilding("I", selectedLocation, 1, cityMap);
                	IB.buildBuilding();
                }
                else if(userChoice == 3) {
                	Park P = new Park("P", 1, 25, selectedLocation, cityMap);
                	P.buildPark();
                }
                else if(userChoice == 4) {
                	PowerGenerator PG = new PowerGenerator("PG", 1, 500, selectedLocation);
                	PG.buildGenerator();
                }
                else if(userChoice == 5) {
                	School S = new School("Sc", 1);
                	S.buildSchool();
                }
                map = cityMap.getMap();
                cityMap.DisplayMap();

                // Create a GamePanel with the updated map
                gamePanel.updatePanel(map);
                gamePanel.displayPanel();

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
