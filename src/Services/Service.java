package Services;
import Economy.Capital;

public class Service {
    private String serviceID;
    private int level;
    private String type;
    
    public Capital capital;

    // Constructor
    public Service(String serviceID, int level, String type) { 
        this.serviceID = serviceID;
        this.level = level;
        this.type = type;
    }

    public void upgradeService() {
            if(this.level < 5) {
            	this.level++;
            	performUpgrade();
            }
            else {
            	System.err.println("Service already at maximum level");
            }
    }
    
    
    // Overridden by the sub class functions.
    public void performUpgrade() {
    	System.out.println("Default upgrade function inside parent class"); // Optional.
    }
    
    

    public void destroyService() {
    	int destructionCost = level * 1000;
    	if(capital.getCapital() - destructionCost < 0) {
    		System.err.println("Not Enough Capital Balance");
    	}
    	else {
    		capital.setCapital(capital.getCapital() - destructionCost);
    		performDestruction();
    	}
    }
    
    // This method will be overridden by the sub class methods.
    public void performDestruction() {
    	this.level = 0;
    }
}
