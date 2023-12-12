package Infrastructure.Waste;
import Infrastructure.InfrastructureElement;
import Util.Location;

public class SewagePlant extends InfrastructureElement {
    private int capacity;

    public SewagePlant(String infraID, int level) {
        super(infraID, "SewagePlant", level);
        this.capacity = 70; // Default capacity  
    }

    public boolean buildSewagePlant() {
        int side = this.size; //default
        String[][] SewagePlantStructure = new String[side][side];

        // checks whether area is available
        if(!(gameMap.isAreaAvailable(location.getX(), location.getY(), side, side))) {
            return false;
        }

        for(int i = 0 ; i < SewagePlantStructure.length; i++){
            for(int j = 0 ; j < SewagePlantStructure[i].length; j++){
                SewagePlantStructure[i][j] = " ";
            }
        }

        // Filling the Sewage plant borders with '+ ' and the inside area with 'u5408'.
        int sewage = 0x1F33F;
        for(int i = 0; i<=side -1 ; i++){
            for(int j = 0 ; j<= side -1 ; j++) {
                if (i==0 || i == side -1 || j==0 || j==side-1) {
                    if (i< SewagePlantStructure.length && j < SewagePlantStructure[i].length) {
                        SewagePlantStructure[i][j] = "+";
                    }
                    
                } else {
                    SewagePlantStructure[i][j] = Character.toString(sewage);
                }
            }
        }

        if (gameMap.placeObject(SewagePlantStructure,location.getX(),location.getY())) {
            return true;
        }
        return false;
    }

    //Function to perform regular maintenance
    public void performMaintenance() {
        System.out.println(x:"Performing regular maintenance on the Sewage Plant.");
    
    }

    //Override displayInfo to include Sewage plant specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Total capacity: " + this.capacity);
    }

    // Function to upgrade sewage plant
    public void upgradeSewagePlant(int size, int capacity) {
        this.size += (size > 0) ? size : 20;
        int status = super.upgradeInfrastructure();
        if (status == 0) {
             System.out.println("Not Enough Capital Balance!!");
        } else if (status == -1) {
            System.out.println("Sewage Plant is already at maximum level..");
        } else if (buildSewagePlant()) {
            System.out.println("Sewage Plant is Upgraded :)");
        } else {
            System.out.println("Selected area is already occupied!!");
        } 
    }

    // Function to destroy Sewage plant
    public void destroySewagePlant() {
        int side = this.size; //Default
        if (gameMap.destroyObject(side,side, location.getX(),location.getY())) {
            System.out.println("Sewage Plant Destroyed :(");
        } else {
            System.out.println("Unable to destroy Sewage Plant. Area may be occupied.");
        }
    }
}
