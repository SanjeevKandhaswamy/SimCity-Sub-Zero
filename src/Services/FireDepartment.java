package Services;
import Util.Location;
import Main.GameMap;

public class FireDepartment extends Service {
    private int fireFightingCoverage;
    private int boostFireFightingCoverage;
    private Location location;
    private GameMap GameMap;

    public FireDepartment(String serviceID, int level, int fireFightingCoverage, int x, int y) {
        super(serviceID, level, "FireDepartment");
        this.fireFightingCoverage = fireFightingCoverage;
        this.boostFireFightingCoverage = 5; 
        this.location = new Location(x, y);
    }

    // Set location coordinates of the fire department
    public void setLocation(int x, int y) {
        this.location.setLocation(x, y);
    }

    @Override
    public String performUpgrade() {
        this.fireFightingCoverage += boostFireFightingCoverage; 
        int status = upgradeService();
        if (status == 0) {
            return ("Not Enough Capital Balance!!");
        } else if (status == -1) {
            return ("Service Already at maximum level");
        }
        return ("Fire Department Upgraded :)");
    }

    public boolean buildFireDepartment() {
        int side = (int) Math.sqrt(this.fireFightingCoverage); // Calculating the length of the side of the fire department

        // Checks whether the area is available
        if (!(GameMap.isAreaAvailable(location.getX(), location.getY(), side, side))) {
            return false;
        }

        String[][] fireDepartment = new String[side][side]; // Declaring a new fire department using size

        for (int i = 0; i <= fireDepartment.length - 1; i++) {
            for (int j = 0; j <= fireDepartment[i].length - 1; j++) {
                fireDepartment[i][j] = " ";
            }
        }

        // Filling the fire department borders with '+' and the inside area with 'F'.
        int departmentSize = fireFightingCoverage / 5;  // Adjust for the fire department size
        for (int i = 1; i <= departmentSize; i++) {
            for (int j = 1; j <= departmentSize; j++) {
                if (i == 1 || i == departmentSize || j == 1 || j == departmentSize) {
                    if (i < fireDepartment.length && j < fireDepartment[i].length) {
                        fireDepartment[i][j] = " +";
                    }
                } else {
                    fireDepartment[i][j] = "F";
                }
            }
        }

        if (GameMap.placeObject(fireDepartment, location.getX(), location.getY())) {
            return true;
        } else {
            return false;
        }
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
    
    

    // Implementation of performDestruction() for proper deletion of FireDepartment Object
    @Override
    public boolean performDestruction() {
        this.level = 0;
        int size = (int) Math.sqrt(fireFightingCoverage);
        if (GameMap.destroyObject(size, size, location.getX(), location.getY())) {
            return true;
        }
        return false;
    }
}
