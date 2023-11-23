package Buildings;
import Util.Location;

public class CommercialBuilding extends Building{
	
	int Income;
	
    public CommercialBuilding(String id, Location location, int level) {
        super(id, location, null, level);
    }
    
    public Location BuildOffice(int x, int y) {
		return null;
    }
    
    public void IncreaseIncome() {
    	
    }
    
    public void UpdateCapital() {
    	
    }
}
