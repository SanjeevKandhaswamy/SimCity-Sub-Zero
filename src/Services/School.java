package Services;
import Util.Location;
import Main.GameMap;

public class School extends Service {
    private int capacity;
    private int boostPercentage;
    private Location location;
    private int no_students;
    
    private GameMap GameMap;

    // Constructor
    public School(String serviceID, int level) {
        super(serviceID, level, "School");
        this.capacity = 100; // Default capacity
        this.boostPercentage = 50; // Default boost percentage
        this.no_students = 75; // Default students.
    }
    
    
    // Setter method for setting location
    public void setLocation(int x, int y) {
    	this.location.setLocation(x, y);
    }
    
    
    // Method for getting the admission status of the school object
    public String getAdmissionStatus() {
    	if(this.no_students < this.capacity) {
    		return ("Admissions Open");
    	}
    	else {
    		return ("Admissions Closed");
    	}
    }
    
    
    // Implementing performUpgrade method inherited from Service class
    @Override
    public String performUpgrade() {
    	if(RB.getPopulation() <= capacity*10) {
    		return ("School capacity is enough for current population :)");
    	}
    	
    	this.capacity += this.boostPercentage;
    	int status = upgradeService();
    	if(status == 0){
    		return ("Not Enough Capital Balance!!");
    	}
    	else if(status == -1) {
    		return ("Service Already at maximum level!!");
    	}
    	else {
    		RB.boostHappiness(this.boostPercentage);
    		return ("School Upgraded Successfully :)");
    	}
    }
    
    
    // Implementing upgradeService method inherited from Service class
    @Override
    public int upgradeService() {
        if(this.level < 5) {
        	int upgradeCost = level * 1000;
        	if(capital.getCapital() - upgradeCost < 0) {
        		return 0;
        	}
        	capital.setCapital(capital.getCapital() - upgradeCost);
        	this.level++;
        	return 1;
        }
        else {
        	return -1;
        }
    }
    
    
    // buildSchool() method for building school in the map
    public boolean buildSchool() {
    	

    	String[][] school = new String[1][1];
    	
    	if(!(GameMap.isAreaAvailable(location.getX(), location.getY(), 1, 1))) {
    		return false;
    	}
    	
    	int sc = 0x0001F3EB;
    	

    	school[0][0] = Character.toString(sc);

    	
    	
    	if(GameMap.placeObject(school, location.getX(), location.getY())) {
        	return true;
    	}
    	return false;
    }
    
    
    // Implementation of destroyService() inherited from Service Class
    @Override
    public String destroyService() {
    	int destructionCost = level * 1000;
    	if(capital.getCapital() - destructionCost < 0) {
    		return ("Not Enough Capital Balance");
    	}
    	else {
    		capital.setCapital(capital.getCapital() - destructionCost);
    		if(performDestruction()) {
    			return("Service Destroyed");
    		}
    		else {
    			return ("Service Not Destroyed!! Retry :)");
    		}
    	}
    }
    
    
    // Implementation of performDestruction() method for proper destruction of the object
    @Override
    public boolean performDestruction() {
    	this.level = 0;
    	if(GameMap.destroyObject(1, 1, location.getX(), location.getY())) {
    		return true;
    	}
    	return false;
    }
}

