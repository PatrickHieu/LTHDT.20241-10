package src.simulator;

import src.circuit.Circuit;
import src.elements.Capacitor;
import src.elements.CircuitElement;
import src.elements.Inductor;
import src.elements.Resistor;

public class CircuitAnalyzer {

    public static void analyzeSerial(Circuit circuit, double sourceVoltage) {
        if (circuit.getElements().isEmpty()) {
            System.out.println("The circuit has no elements to analyze.");
            return;
        }

        double totalResistance = 0;
        double totalCapacitanceInverse = 0;
        double totalInductance = 0;

        System.out.println("Serial Circuit Analysis:");
        System.out.println("Source voltage: " + sourceVoltage + " V");

        // Hiển thị và tính toán các thành phần nối tiếp
        StringBuilder resistorDisplay = new StringBuilder("Serial Resistor: ");
        for (CircuitElement element : circuit.getElements()) {
            if (element instanceof Resistor) {
                totalResistance += element.getValue();
                resistorDisplay.append(element.getName()).append(" -> ");
            }
        }
        if (resistorDisplay.toString().equals("Serial Resistor: ")) {
            System.out.println("Serial Resistor: None");
        } else {
            resistorDisplay.append("Source");
            System.out.println(resistorDisplay);
            System.out.println("Total resistance: " + totalResistance + " Ω");
        }

        StringBuilder capacitorDisplay = new StringBuilder("Serial Capacitor: ");
        for (CircuitElement element : circuit.getElements()) {
            if (element instanceof Capacitor) {
                totalCapacitanceInverse += 1 / element.getValue();
                capacitorDisplay.append(element.getName()).append(" -> ");
            }
        }
        if (capacitorDisplay.toString().equals("Serial Capacitor: ")) {
            System.out.println("Serial Capacitor: None");
        } else {
            capacitorDisplay.append("Source");
            System.out.println(capacitorDisplay);
            System.out.println("Total capacitance: " + (1 / totalCapacitanceInverse) + " F");
        }

        StringBuilder inductorDisplay = new StringBuilder("Serial Inductor: ");
        for (CircuitElement element : circuit.getElements()) {
            if (element instanceof Inductor) {
                totalInductance += element.getValue();
                inductorDisplay.append(element.getName()).append(" -> ");
            }
        }
        if (inductorDisplay.toString().equals("Serial Inductor: ")) {
            System.out.println("Serial Inductor: None");
        } else {
            inductorDisplay.append("Source");
            System.out.println(inductorDisplay);
            System.out.println("Total inductance: " + totalInductance + " H");
        }
    }

    public static void analyzeParallel(Circuit circuit, double sourceVoltage) {
        if (circuit.getElements().isEmpty()) {
            System.out.println("The circuit has no elements to analyze.");
            return;
        }

        double inverseResistance = 0;
        double totalCapacitance = 0;
        double inverseInductance = 0;

        System.out.println("Parallel Circuit Analysis:");
        System.out.println("Source voltage: " + sourceVoltage + " V");

        // Hiển thị và tính toán các thành phần song song
        StringBuilder resistorDisplay = new StringBuilder("Parallel Resistor: ");
        for (CircuitElement element : circuit.getElements()) {
            if (element instanceof Resistor) {
                inverseResistance += 1 / element.getValue();
                resistorDisplay.append(element.getName()).append(" || ");
            }
        }
        if (resistorDisplay.toString().equals("Parallel Resistor: ")) {
            System.out.println("Parallel Resistor: None");
        } else {
            resistorDisplay.append("Source");
            System.out.println(resistorDisplay);
            System.out.println("Total resistance: " + (1 / inverseResistance) + " Ω");
        }

        StringBuilder capacitorDisplay = new StringBuilder("Parallel Capacitor: ");
        for (CircuitElement element : circuit.getElements()) {
            if (element instanceof Capacitor) {
                totalCapacitance += element.getValue();
                capacitorDisplay.append(element.getName()).append(" || ");
            }
        }
        if (capacitorDisplay.toString().equals("Parallel Capacitor: ")) {
            System.out.println("Parallel Capacitor: None");
        } else {
            capacitorDisplay.append("Source");
            System.out.println(capacitorDisplay);
            System.out.println("Total capacitance: " + totalCapacitance + " F");
        }

        StringBuilder inductorDisplay = new StringBuilder("Parallel Inductor: ");
        for (CircuitElement element : circuit.getElements()) {
            if (element instanceof Inductor) {
                inverseInductance += 1 / element.getValue();
                inductorDisplay.append(element.getName()).append(" || ");
            }
        }
        if (inductorDisplay.toString().equals("Parallel Inductor: ")) {
            System.out.println("Parallel Inductor: None");
        } else {
            inductorDisplay.append("Source");
            System.out.println(inductorDisplay);
            System.out.println("Total inductance: " + (1 / inverseInductance) + " H");
        }
    }
}
