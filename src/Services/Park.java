package Services;
import Util.Location;
import Buildings.ResidentialBuilding;

public class Park extends Service {
    private int boostPercentage;
    private int greenSpace;
    private int boostgreenSpace;
    private Location location;

    public Park(String serviceID, int level, int greenSpace, int x, int y) {
        super(serviceID, level, "Park");
        this.boostPercentage = 10;   // Default boost percentage
        this.greenSpace = greenSpace; 
        this.boostgreenSpace = 5; // Default boost value for green space
        setLocation(x,y);
    }
    
    // Set location coordinates of the park
    public void setLocation(int x, int y) {
    	this.location.setLocation(x, y);
    }
    
    
    // Setter method for boostPercentage
    public void setBoostPercentage(int boostPercentage) {
    	this.boostPercentage = boostPercentage;
    }
    
    
    @Override
	public  String performUpgrade() {
    	super.performUpgrade(); //Optional
    	this.greenSpace += boostgreenSpace; //Customizable boost value for green space
    	BuildPark(); // Updating the park after green space is updated
    	super.upgradeService();
		return ("Park Upgraded");
    }
    
    
    
    public String BuildPark() {
    	
    	int side = (int) Math.sqrt(this.greenSpace); // Calculating the length of the side of park
    	String[][] park = new String[side][side]; // Declaring new park using size
    	
    	// Checks whether area is available
    	if(!(GameMap.isAreaAvailable(location.getX(),location.getY(), side, side))) {
    		return ("Selected Location is alreay occupied");
    	}
    	
    	
    	for(int i = 0; i <= park.length - 1; i++) {
    		for(int j = 0; j <= park[i].length - 1; j++) {
    			park[i][j] = " ";
    		}
    	}
    	
    	int grass = 0x0001F33F;
    	// Filling the park borders with '+' and the inside area with 'P'.
        for (int i = 0; i <= side - 1; i++) {
            for (int j = 0; j <= side - 1; j++) {
                if (i == 0 || i == side - 1 || j == 0 || j == side - 1) {
                    if (i < park.length && j < park[i].length) {
                        park[i][j] = " +";
                    }
                } else {
                    park[i][j] = Character.toString(0);
                }
            }
        }
        
        GameMap.placeObject(park,location.getX(),location.getY());
        return null;
    }
    
    
    @Override
    public void performDestruction() {
    	super.performDestruction();
    	int size = (int) Math.sqrt(greenSpace);
    	GameMap.destroyObject(size,location.getX(),location.getY());
    }
    
}
