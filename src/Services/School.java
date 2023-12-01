package Services;
import Util.Location;

public class School extends Service {
    private int capacity;
    private int boostPercentage;
    private Location location;
    private int no_students;

    public School(String serviceID, int level) {
        super(serviceID, level, "School");
        this.capacity = 100; // Default capacity
        this.boostPercentage = 50; // Default boost percentage
        this.no_students = 75; // Default students.
    }
    
    public void setLocation(int x, int y) {
    	this.location.setLocation(x, y);
    }
    
    
    public String getAdmissionStatus() {
    	if(this.no_students < this.capacity) {
    		return ("Admissions Open");
    	}
    	else {
    		return ("Admissions Closed");
    	}
    }
    
    
    @Override
    public String performUpgrade() {
    	if(RB.getPopulation() <= capacity*10) {
    		return ("School Capcity is enough for current population count");
    	}
    	
    	super.performUpgrade();
    	this.capacity += this.boostPercentage;
    	buildSchool();
    	return ("School Upgraded");
    }
    
    
    public String buildSchool() {
    	
    	int side = this.capacity / 10;
    	String[][] school = new String[side][side];
    	
    	if(!(GameMap.isAreaAvailable(location.getX(), location.getY(), side, side))) {
    		return ("Selected Location is already occupied");
    	}
    	
    	int sc = 0x0001F3EB;
    	
    	for(int i = 0; i <= side - 1; i++) {
    		for(int j = 0; j <= side - 1; j++) {
    			school[i][j] = " ";
    		}
    	}
    	
    	for(int i = 0; i <= side - 1; i++) {
    		for(int j = 0; j <= side - 1; j++) {
    			if(i == 0 || j == 0 || i == side - 1 || j == side - 1) {
    				school[i][j] = " +";
    			}
    			else {
    				school[i][j] = Character.toString(sc);
    			}
    		}
    	}
    	
    	GameMap.placeObject(school, location.getX(), location.getY());
    	return null;
    }
    
    
    
    @Override
    public void performDestruction() {
    	super.performDestruction();
    	GameMap.destroyObject();
    }
}

