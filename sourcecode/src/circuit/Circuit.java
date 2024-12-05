package circuit;

import elements.CircuitElement;

import java.util.ArrayList;
import java.util.List;

public class Circuit {
    private final List<CircuitElement> elements;
    private final String circuitType;

    public Circuit(String circuitType) {
        this.elements = new ArrayList<>();
        this.circuitType =circuitType;
    }

    public void addElement (CircuitElement element) {
        elements.add(element);
    }
    // ER: Equivalent Resistance (Điện trở tương đương)
    public double calculateER() {
        double totalResistance = 0;
        if (circuitType.equals("Serial")) {
            for (CircuitElement element : elements) {
                totalResistance += element.getValue();
            }
        } else if (circuitType.equals("Parallel")) {
            double reverseResistance = 0;
            for (CircuitElement element : elements) {
                reverseResistance += 1 / element.getValue(); //1/Rtd = 1/R1 + 1/R2 + ...
            }
            totalResistance = 1 / reverseResistance; //Rtd = 1/R
        }
        return totalResistance;
    }

    public List<CircuitElement> getElements() {
        return elements;
    }
}
