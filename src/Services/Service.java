package Services;
import Economy.Capital;
import Buildings.ResidentialBuilding;

public class Service{
    private String serviceID;
    protected int level;
    private String type;
    
    public Capital capital;
    public ResidentialBuilding RB;

    // Constructor
    public Service(String serviceID, int level, String type) { 
        this.serviceID = serviceID;
        this.level = level;
        this.type = type;
    }

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
    
    
    // Overridden by the sub class functions.
    public String performUpgrade() {
    	System.out.println("Default Upgrade Function inside Parent Function");
    	return null; // Optional.
    }
    
    

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
    
    
    
    // This method will be overridden by the sub class methods.
    public boolean performDestruction() {
    	this.level = 0;
    	return true;
    }
}
