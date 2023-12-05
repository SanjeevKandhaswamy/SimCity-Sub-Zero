package Infrastructure;
import java.util.List;
import java.util.ArrayList;


public class Infrastructure {
    private List<InfrastructureElement> infrastructureElements;

    public Infrastructure() {
        this.infrastructureElements = new ArrayList<>();
    }

    public void addInfrastructureElement(InfrastructureElement element) {
        infrastructureElements.add(element);
    }

    public List<InfrastructureElement> getInfrastructureElements() {
        return infrastructureElements;
    }

    public void displayAllElementsInfo() {
        for (InfrastructureElement element : infrastructureElements) {
            element.displayInfo();
        }
    }

    // Function to upgrade the infrastructure
    public void upgradeInfrastructure(InfrastructureElement element) {
        // Implement upgrade logic
        System.out.println("Upgrading infrastructure: " + element.getInfraID());
        System.out.println("Upgrade logic goes here.");
    }

    // Function to destroy the infrastructure
    public void destroyInfrastructure(InfrastructureElement element) {
        // Implement destroy logic
        System.out.println("Destroying infrastructure: " + element.getInfraID());
        System.out.println("Destroy logic goes here.");
    }
}