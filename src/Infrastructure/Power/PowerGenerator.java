package Infrastructure.Power;
import Infrastructure.InfrastructureElement;

public class PowerGenerator extends InfrastructureElement {
    private int supply;

    //Lowkik Comment
    public PowerGenerator(String infraID, int level) {
        super(infraID, "PowerGenerator", level);
        this.supply = 30; // Default supply
    }
}
