package Infrastructure;
import java.util.List;
import java.util.ArrayList;

class Infrastructure {
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
}
