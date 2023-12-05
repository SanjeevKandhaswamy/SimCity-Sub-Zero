package Services;
import Util.Location;
import Buildings.ResidentialBuilding;

public class PublicTransport extends Service {
    private int capacity;
    private Location location;
    private int length;
    private int breadth;
    private int boostValue;
    private Map GameMap;


    public PublicTransport(String serviceID, int level, int x, int y, int length, int breadth) {
        super(serviceID, level, "PublicTransport");
        this.capacity = (int)(length * breadth)/100; // Default capacity
        this.location.setLocation(x, y);
        this.length = length;
        this.breadth = breadth;
        this.boostValue = 10;
    }
    
    public String buildTransport() {
    	
    	int area = length * breadth;
    	if(!(GameMap.isAreaAvailable(location.getX(),location.getY(), length, breadth))) {
    		return ("Selected Location is already occupied");
    	}
    	
    	String[][] road = new String[length][breadth]; // Declaring a new 2d road array.
    	for(int i = 0; i <= road.length - 1; i++) { // Initializing the road to empty fields.
    		for(int j = 0; j <= road[0].length - 1; j++) {
    			road[i][j] = " ";
    		}
    	}
    	
    	// Fill the outline cells of the array with '+' and inside with 'R'.
    	for (int i = 0; i < length; i++) {
            for (int j = 0; j < breadth; j++) {
                if (i == 0 || i == length - 1 || j == 0 || j == breadth - 1) {
                    road[i][j] = " +";
                } else {
                	if(i % 2 == 0) {
                		road[i][j] = " ";
                	}
                	else {
                        road[i][j] = " - ";     		
                	}
                }
            }
        }
    	
    	//Place the road in the game map.
    	GameMap.placeObject(road, location.getX(), location.getY());
    	return null;
    	
    }
    
    
    
    @Override
    public String performUpgrade() {
    	super.performUpgrade();
    	if(capacity > RB.getPopulation() * 0.01) {
    		return ("Present Road transport is sufficient for the present population");
    	}
    	
    	this.length += this.boostValue;
    	this.breadth += this.boostValue;
    	buildTransport(); // Update the new road in the game map
       	return ("Road Upgraded");
    }
    
    
    @Override
    public void performDestruction() {
    	super.performDestruction();
    	GameMap.destroyObject(this.length*this.breadth, location.getX(), location.getY());
    }

   
}