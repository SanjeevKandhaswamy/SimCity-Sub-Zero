package Services;
import Economy.Capital;
import Buildings.ResidentialBuilding;

public class Service{
    private String serviceID;
    private int level;
    private String type;
    
    public Capital capital;
    public ResidentialBuilding RB;

    // Constructor
    public Service(String serviceID, int level, String type) { 
        this.serviceID = serviceID;
        this.level = level;
        this.type = type;
    }

    public String upgradeService() {
            if(this.level < 5) {
            	this.level++;
            	return null;
            }
            else {
            	return ("Service already at maximum level");
            }
    }
    
    
    // Overridden by the sub class functions.
    public String performUpgrade() {
    	return ("Default upgrade function inside parent class"); // Optional.
    }
    
    

    public String destroyService() {
    	int destructionCost = level * 1000;
    	if(capital.getCapital() - destructionCost < 0) {
    		return ("Not Enough Capital Balance");
    	}
    	else {
    		capital.setCapital(capital.getCapital() - destructionCost);
    		performDestruction();
    		return("Service Destroyed");
    	}
    }
    
    // This method will be overridden by the sub class methods.
    public void performDestruction() {
    	this.level = 0;
    }
}
