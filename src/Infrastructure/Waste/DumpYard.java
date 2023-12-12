package Infrastructure.Waste;
import Infrastructure.InfrastructureElement;

public class DumpYard extends InfrastructureElement {
    private int capacity;

    public DumpYard(String infraID, int level) {
        super(infraID, "WasteDumpYard", level);
        this.capacity = 80; // Default capacity
    }

    public boolean buildDumpYard() {
        int side = this.size;
        String[][] DumpYardStructure = new String[side][side];

        // cheecks whether area is available
        if(!(gameMAp.isAreaAvailable(location.getX(),location.getY(),side,side))) {
            return false;
        }

        for(int i = 0 ; i < DumpYardStructure.length; i++){
            for(int j = 0 ; j < DumpYardStructure[i].length; j++) {
                DumpYardStructure[i][j] = " ";
            }
        }

        // Filling the Dump yard borders with '+' and the insde with '0x1F22F'
        int Dump = 0x1F22F ;
        for(int i = 0; i<=side-1; i++){
            for(int j = 0; j<=side-1; j++){
                if(i==0 || i==side-1 || j==0 || j==side-1){
                    if(i<DumpYardStructure.length && j<DumpYardStructure[i].length){
                        DumpYardStructure[i][j] = "+" ;
                    }
                } else {
                    DumpYardStructure[i][j] = Character.toString(dump);
                }
            }
        }

        if (gameMap.placeObject(DumpYardStructure,location.getX(),llocation.getY())){
            return true;
        }
        return false;
    }

    //Override displayInfo to include dump yard specific information
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Dump Yard Capacity: " + this.capacity);
    }

    // Function to upgrade dump yard
    public void upgradeDumpYard(int size, int capacity) {
        this.size += (size > 0) ? size : 20;
        int status = super.upgradeInfrastructure();
        if (status == 0) {
             System.out.println("Not Enough Capital Balance!!");
        } else if (status == -1) {
            System.out.println("Dump Yard is already at maximum level..");
        } else if (buildSewagePlant()) {
            System.out.println("Dummp Yard is Upgraded :)");
        } else {
            System.out.println("Selected area is already occupied!!");
        } 
    }

    // Function to destroy dump yard
    public void destroyDumpYard() {
        int side = this.size; //Default
        if (gameMap.destroyObject(side,side, location.getX(),location.getY())) {
            System.out.println("Dump Yard Destroyed :(");
        } else {
            System.out.println("Unable to destroy Dump Yard. Area may be occupied.");
        }
    }
}
