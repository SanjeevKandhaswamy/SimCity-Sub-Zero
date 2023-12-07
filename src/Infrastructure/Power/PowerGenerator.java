package Infrastructure.Power;
import Buildings.*;
import Infrastructure.InfrastructureElement;
import Util.Location;
import Main.Map;


public class PowerGenerator extends Power {
    private int supply;
    private Location location;
    private Map GameMap;
    private int size;

    public PowerGenerator(String infraID, int level, int demand, int supply,int x,int y,int size) {
        super(infraID, level, demand);
        this.supply = supply; //Supply of the power generator
        this.location.setLocation(x,y); //Building at that certain location
        this.size = (size > 0) ? size : 50; //DEFAULT_SIZE
    }

    public boolean buildPowerHouse() {

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

    // Method to check if the power supply is sufficient for a building
    public boolean isSupplySufficient(Building building) {
        if ("Power".equals(building.getType())) {
            int demand = getPowerDemand(building); // Assume a method to get demand from the building
            return supply >= demand;
        }
        return false;
    }

    // Method to expand power supply
    public void expandPowerSupply(int expandSupply) {
        // Logic to expand power supply
        System.out.println("Expanding Power Supply for " + getInfraID());
        supply = expandSupply + 10; // For example, increase supply by 10 MW
    }

    // Method to get power demand from a building
    private int getPowerDemand(Building building) {
        // Placeholder logic, replace it with your actual logic to get demand from the building
        return 20; // Example demand value
    }

    // Override displayInfo to include generator-specific information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Power Supply: " + supply + " MW");
    }

    // Function to update power supply
    public void updateSupply(int newSupply) {
        this.supply = newSupply;
        System.out.println("Power Supply Updated to: " + newSupply + " MW");
    }

    // Function to build power supply.
    public void buildPowerSupply() {
        // Implement build logic
        System.out.println("Building Power Supply for: " + getInfraID());
    }

    // Function to destroy power supply
    public void destroyPowerSupply() {
        // Implement destroy logic
        System.out.println("Destroying Power Supply for: " + getInfraID());
    }

    // Function to check power demand
    public void checkDemand() {
        System.out.println("Checking Power Demand for: " + getInfraID());
        // Implement demand check logic
    }

}
