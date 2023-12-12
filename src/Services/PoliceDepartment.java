package Services;
import Util.Location;
import Main.GameMap;

public class PoliceDepartment extends Service {
    private int PoliceCoverage;
    private int boostPoliceCoverage;
    private Location location;
    private GameMap GameMap;

    public PoliceDepartment(String serviceID, int level, int PoliceCoverage, int x, int y, GameMap gameMap) {
        super(serviceID, level, "PoliceDepartment");
        this.PoliceCoverage = PoliceCoverage;
        this.boostPoliceCoverage = 5; // Default boost value for Police coverage
        this.location = new Location(x, y);
        this.GameMap = gameMap;
    }

    // Set location coordinates of the Police department
    public void setLocation(int x, int y) {
        this.location.setLocation(x, y);
    }

    @Override
    public String performUpgrade() {
        this.PoliceCoverage += boostPoliceCoverage; // Customizable boost value for Police coverage
        int status = upgradeService();
        if (status == 0) {
            return ("Not Enough Capital Balance!!");
        } else if (status == -1) {
            return ("Service Already at maximum level");
        } else if (buildPoliceDepartment()) {
            return ("Police Department Upgraded :)");// Updating the Police department after Police coverage is updated
        } else {
            return ("Selected area is already occupied by an object!!");
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
    
   

    public boolean buildPoliceDepartment() {
        int side = (int) Math.sqrt(this.PoliceCoverage); // Calculating the length of the side of the Police department

        // Checks whether the area is available
        if (!(GameMap.isAreaAvailable(location.getX(), location.getY(), side, side))) {
            return false;
        }

        String[][] PoliceDepartment = new String[side][side]; // Declaring a new Police department using size

        for (int i = 0; i <= PoliceDepartment.length - 1; i++) {
            for (int j = 0; j <= PoliceDepartment[i].length - 1; j++) {
            	PoliceDepartment[i][j] = " ";
            }
        }

        // Filling the Police department borders with '+' and the inside area with 'F'.
        int departmentSize = PoliceCoverage / 5;  // Adjust for the Police department size
        for (int i = 1; i <= departmentSize; i++) {
            for (int j = 1; j <= departmentSize; j++) {
                if (i == 1 || i == departmentSize || j == 1 || j == departmentSize) {
                    if (i < PoliceDepartment.length && j < PoliceDepartment[i].length) {
                    	PoliceDepartment[i][j] = " +";
                    }
                } else {
                	PoliceDepartment[i][j] = "F";
                }
            }
        }

        if (GameMap.placeObject(PoliceDepartment, location.getX(), location.getY())) {
            return true;
        } else {
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
        int size = (int) Math.sqrt(PoliceCoverage);
        if (GameMap.destroyObject(size, size, location.getX(), location.getY())) {
            return true;
        }
        return false;
    }
}
