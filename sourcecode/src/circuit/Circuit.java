package src.circuit;

import java.util.ArrayList;
import java.util.List;
import src.elements.Capacitor;
import src.elements.CircuitElement;
import src.elements.Inductor;
import src.elements.Resistor;

public class Circuit {
    private final List<CircuitElement> elements;
    private final String circuitType;

    public Circuit(String circuitType) {
        this.elements = new ArrayList<>();
        this.circuitType = circuitType;
    }

    public void addElement(CircuitElement element) {
        if (elements.size() < 5) {
            elements.add(element);
        } else {
            System.out.println("Cannot add more than 5 elements.");
        }
    }

    public List<CircuitElement> getElements() {
        return elements;
    }

    public double calculateTotalResistance() {
        double totalResistance = 0;

        if (circuitType.equals("Serial")) {
            for (CircuitElement element : elements) {
                if (element instanceof Resistor) {
                    totalResistance += element.getValue(); // tổng trở trong mạch nối tiếp
                }
            }
        } else if (circuitType.equals("Parallel")) {
            double inverseResistance = 0;
            for (CircuitElement element : elements) {
                if (element instanceof Resistor) {
                    inverseResistance += 1 / element.getValue(); // tổng nghịch đảo trở trong mạch song song
                }
            }
            totalResistance = 1 / inverseResistance;
        }

        return totalResistance;
    }

    public double calculateTotalCapacitance() {
        double totalCapacitance = 0;

        if (circuitType.equals("Serial")) {
            double inverseCapacitance = 0;
            for (CircuitElement element : elements) {
                if (element instanceof Capacitor) {
                    inverseCapacitance += 1 / element.getValue(); 
                }
            }
            totalCapacitance = 1 / inverseCapacitance;
        } else if (circuitType.equals("Parallel")) {
            for (CircuitElement element : elements) {
                if (element instanceof Capacitor) {
                    totalCapacitance += element.getValue(); 
                }
            }
        }

        return totalCapacitance;
    }

    public double calculateTotalInductance() {
        double totalInductance = 0;

        if (circuitType.equals("Serial")) {
            for (CircuitElement element : elements) {
                if (element instanceof Inductor) {
                    totalInductance += element.getValue(); 
                }
            }
        } else if (circuitType.equals("Parallel")) {
            double inverseInductance = 0;
            for (CircuitElement element : elements) {
                if (element instanceof Inductor) {
                    inverseInductance += 1 / element.getValue(); 
                }
            }
            totalInductance = 1 / inverseInductance;
        }

        return totalInductance;
    }

    public void displayCircuitDiagram() {
// Hiển thị sơ đồ mạch
        StringBuilder serialDiagram = new StringBuilder();
        StringBuilder parallelDiagram = new StringBuilder();
    
        StringBuilder resistors = new StringBuilder();
        StringBuilder capacitors = new StringBuilder();
        StringBuilder inductors = new StringBuilder();
    
        for (CircuitElement element : elements) {
            if (element instanceof Resistor) {
                resistors.append(element.getName()).append(" -> ");
            } else if (element instanceof Capacitor) {
                capacitors.append(element.getName()).append(" -> ");
            } else if (element instanceof Inductor) {
                inductors.append(element.getName()).append(" -> ");
            }
        }
    
        if (resistors.length() > 0) {
            resistors.append("Source");
        }
        if (capacitors.length() > 0) {
            capacitors.append("Source");
        }
        if (inductors.length() > 0) {
            inductors.append("Source");
        }
    
        if (circuitType.equals("Serial")) {
            serialDiagram.append("Show serial Resistor: ").append(resistors).append("\n");
            serialDiagram.append("Show serial Capacitor: ").append(capacitors).append("\n");
            serialDiagram.append("Show serial Inductor: ").append(inductors);
            System.out.println(serialDiagram);
        } else if (circuitType.equals("Parallel")) {
            parallelDiagram.append("Show parallel Resistor:\n").append(formatParallel(resistors)).append("\n");
            parallelDiagram.append("Show parallel Capacitor:\n").append(formatParallel(capacitors)).append("\n");
            parallelDiagram.append("Show parallel Inductor:\n").append(formatParallel(inductors));
            System.out.println(parallelDiagram);
        }
    }
    
    public void displayCircuitDiagram(String elementType) {

        StringBuilder diagram = new StringBuilder();
        diagram.append("Show ").append(circuitType).append(" ").append(elementType).append(":\n");
    
        for (CircuitElement element : elements) {
            if (elementType.equals("Resistor") && element instanceof Resistor) {
                diagram.append(element.getName()).append("\n");
            } else if (elementType.equals("Capacitor") && element instanceof Capacitor) {
                diagram.append(element.getName()).append("\n");
            } else if (elementType.equals("Inductor") && element instanceof Inductor) {
                diagram.append(element.getName()).append("\n");
            }
        }
    
        if (diagram.toString().equals("Show " + circuitType + " " + elementType + ":\n")) {
            diagram.append("No ").append(elementType).append(" found.\n");
        }
    
        System.out.println(diagram);
    }
    

    private String formatParallel(StringBuilder elements) {
        if (elements.length() == 0) return "None";

        String[] parts = elements.toString().split(" -> ");
        StringBuilder formatted = new StringBuilder("Source\n");
        for (String part : parts) {
            if (!part.equals("Source")) {
                formatted.append(" |\n").append(" ").append(part).append("\n");
            }
        }
        formatted.append(" |\nSource");
        return formatted.toString();
    }
}
