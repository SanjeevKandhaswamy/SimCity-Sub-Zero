package Services;
import Util.Location;
import Main.Map;
<<<<<<< HEAD
import Buildings.ResidentialBuilding;
=======
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a

public class PublicTransport extends Service {
    private int capacity;
    private Location location;
    private int length;
    private int breadth;
    private int boostValue;

<<<<<<< HEAD
<<<<<<< Updated upstream
=======
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a
    private int boostPercent;
    

    private Map GameMap;

=======
>>>>>>> Stashed changes

    public PublicTransport(String serviceID, int level, int x, int y, int length, int breadth) {
        super(serviceID, level, "PublicTransport");
        this.capacity = (int)(length * breadth)/100; // Default capacity
        this.location.setLocation(x, y);
        this.length = length;
        this.breadth = breadth;
        this.boostValue = 10;
        this.boostPercent = 10;
    }
    
<<<<<<< HEAD
<<<<<<< Updated upstream
    public boolean buildTransport() {
    	
    	if(!(GameMap.isAreaAvailable(location.getX(),location.getY(), length, breadth))) {
    		return false;
=======
    public String buildTransport() {
=======
    public boolean buildTransport() {
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a
    	
    	if(!(GameMap.isAreaAvailable(location.getX(),location.getY(), length, breadth))) {
<<<<<<< HEAD
    		return ("Selected Location is already occupied");
>>>>>>> Stashed changes
=======
    		return false;
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a
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
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a
    	if(GameMap.placeObject(road, location.getX(), location.getY())) {
    		return true;
    	}
    	return false;
<<<<<<< HEAD
=======
    	GameMap.placeObject(road, location.getX(), location.getY());
    	return null;
>>>>>>> Stashed changes
=======
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a
    	
    }
    
    
    
    @Override
    public String performUpgrade() {
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
    	super.performUpgrade();
>>>>>>> Stashed changes
=======
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a
    	if(capacity > RB.getPopulation() * 0.01) {
    		return ("Present Road transport is sufficient for the present population");
    	}
    	this.length += this.boostValue;
    	this.breadth += this.boostValue;
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a
    	int status = super.upgradeService();
    	if(status == 0) {
    		return ("Not Enough Capital Balance!!");
    	}
    	else if(status == -1){
    		return ("Service already at maximum level :)");
    	}
    	else if(buildTransport()) {
    		RB.boostHappiness(this.boostPercent);
    		return ("Road Upgraded :)");
    	}
    	else {
    		return ("Selected area is already occupied!!");
    	}
<<<<<<< HEAD
=======
    	buildTransport(); // Update the new road in the game map
       	return ("Road Upgraded");
>>>>>>> Stashed changes
=======
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a
    }
    
    
    @Override
    public boolean performDestruction() {
    	if(GameMap.destroyObject(this.length, this.breadth, location.getX(), location.getY())) {
    		return true;
    	}
    	return false;
    }

   
}