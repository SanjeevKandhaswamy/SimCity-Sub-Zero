package Services;
import Util.Location;
import Main.GameMap;


public class Hospital extends Service {
    private int healthcareCapacity;
    private int boostHealthcareCapacity;
    private Location location;
    private GameMap GameMap;

    public Hospital(String serviceID, int level, int healthcareCapacity, int x, int y) {
        super(serviceID, level, "Hospital");
        this.healthcareCapacity = healthcareCapacity;
        this.boostHealthcareCapacity = 10; // Default boost value for health care capacity
        this.location = new Location(x, y);
    }

    // Set location coordinates of the hospital
    public void setLocation(int x, int y) {
        this.location.setLocation(x, y);
    }

    @Override
    public String performUpgrade() {

        this.healthcareCapacity += boostHealthcareCapacity; // Customizable boost value for health care capacity
        int status = upgradeService();
        if(status == 0) {
        	return ("Not Enough Capital Balance!!");
        }
        else if(status == -1){
        	return ("Service Already at maximum level");
        }
        return ("Hospital Upgraded :)");
    }
    
    
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
    

    public boolean buildHospital() {
    	
        int side = (int) Math.sqrt(this.healthcareCapacity); // Calculating the length of the side of the hospital
    	
        // Checks whether area is available
        if (!(GameMap.isAreaAvailable(location.getX(), location.getY(), side, side))) {
            return false;
        }


        String[][] hospital = new String[side][side]; // Declaring a new hospital using size

        for (int i = 0; i <= hospital.length - 1; i++) {
            for (int j = 0; j <= hospital[i].length - 1; j++) {
                hospital[i][j] = " ";
            }
        }

        // Filling the hospital borders with '+' and the inside area with 'H'.
        int hospitalSize = healthcareCapacity / 10;  // Adjust for the hospital size
        for (int i = 1; i <= hospitalSize; i++) {
            for (int j = 1; j <= hospitalSize; j++) {
                if (i == 1 || i == hospitalSize || j == 1 || j == hospitalSize) {
                    if (i < hospital.length && j < hospital[i].length) {
                        hospital[i][j] = " +";
                    }
                } else {
                    hospital[i][j] = "H";
                }
            }
        }

        if(GameMap.placeObject(hospital, location.getX(), location.getY())) {
        	return true;
        }
        else {
        	return false;
        }
    }
    
    
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
    
    

    @Override
    public boolean performDestruction() {
        this.level = 0;
        int size = (int) Math.sqrt(healthcareCapacity);
        if(GameMap.destroyObject(size, size, location.getX(), location.getY())) {
        	return true;
        }
        return false;
    }
}