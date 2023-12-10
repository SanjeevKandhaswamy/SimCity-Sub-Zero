package Services;
import Util.Location;
import Main.GameMap;

public class School extends Service {
    private int capacity;
    private int boostPercentage;
    private Location location;
    private int no_students;
    
    private GameMap GameMap;

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
    		return ("School capacity is enough for current population :)");
    	}
    	
    	this.capacity += this.boostPercentage;
    	int status = super.upgradeService();
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
    
    
    
    @Override
    public boolean performDestruction() {
    	this.level = 0;
    	if(GameMap.destroyObject(1, 1, location.getX(), location.getY())) {
    		return true;
    	}
    	return false;
    }
}

