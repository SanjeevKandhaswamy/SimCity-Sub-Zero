package Infrastructure.Power;
import Buildings.*;
import Infrastructure.InfrastructureElement;
import Util.Location;
import Main.GameMap;


public class PowerGenerator extends Power {
    private static int noOfGenerators = 0;
    private int supply; // in kW
    private Location location;
    private GameMap GameMap;
    private size;

    public PowerGenerator(String infraID, int level, int demand,int supply,int x,int y,int size) {
        super(infraID, level, demand);
        this.location.setLocation(x,y); //Building at that certain location
        this.supply = (supply > 0) ? supply : 10000; //Supply of the power generator
        this.size = (size > 0) ? size : 50; //DEFAULT_SIZE of Power House
        PowerGenerator.noOfGenerators++;
    }

    public boolean buildGenerator() {

        int side = (int) (this.size); // default
        String[][] powerHouse = new String[side][side]; // Declaring new powerHouse using size

        // Checks whether area is available
        if(!(GameMap.isAreaAvailable(location.getX(),location.getY(), side, side))) {
            return false;
        }


        for(int i = 0; i <= powerHouse.length - 1; i++) {
            for(int j = 0; j <= powerHouse[i].length - 1; j++) {
                powerHouse[i][j] = " ";
            }
        }

        int electric = 0x00002301;
        // Filling the powerHouse borders with '+' and the inside area with 'P'.
        for (int i = 0; i <= side - 1; i++) {
            for (int j = 0; j <= side - 1; j++) {
                if (i == 0 || i == side - 1 || j == 0 || j == side - 1) {
                    if (i < powerHouse.length && j < powerHouse[i].length) {
                        powerHouse[i][j] = " +";
                    }
                } else {
                    powerHouse[i][j] = Character.toString(electric);
                }
            }
        }

        if(GameMap.placeObject(powerHouse,location.getX(),location.getY())) {
            return true;
        }
        return false;

    }

//    // Method to check if the power supply is sufficient for a building
//    public boolean isSupplySufficient(Building building) {
//        if ("Power".equals(building.getType())) {
//            int demand = getPowerDemand(building); // Assume a method to get demand from the building
//            return supply >= demand;
//        }
//        return false;
//    }



    // Override displayInfo to include generator-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Total Power Supply Storage: " + this.supply + " MW");
    }

    // Function to update power supply
    public void updateSupply(int newSupply) {
        this.supply = newSupply;
        System.out.println("Power Supply Storage Updated to: " + newSupply + " MW");
    }

    // Function to build power supply.
    public String upgradeGenerator(int size,int supply) {
        this.size += (size > 0) ? size : 20; //increase size of 20 default
        this.supply += (supply > 0) ? supply : 4000; //increase supply of 4000 kW default
        int status = super.upgradeInfrastructure(null);
        if(status == 0) {
            return ("Not Enough Capital Balance!!");
        }
        else if(status == -1) {
            return ("Power Infrastructure is already at maximum level..");
        }
        else if(buildGenerator()) {
            return ("Power House Upgraded :)");
        }
        else {
            return ("Selected area is already occupied!!");
        }

    }

    // Function to destroy power supply
    public void destroyGenerator() {
        int side = (int) (this.size); // default
        if(GameMap.destroyObject(side, side, location.getX(),location.getY())) {
            return true;
        }
        return false;

    }


}
