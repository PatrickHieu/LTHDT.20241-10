package service;

import models.circuit.Circuit;
import models.elements.Capacitor;
import models.elements.CircuitElement;
import models.elements.Inductor;
import models.elements.Resistor;

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

        for (CircuitElement element : circuit.getElements()) {
            if (element instanceof Resistor) totalResistance += element.getValue();
            else if (element instanceof Capacitor) totalCapacitanceInverse += 1 / element.getValue();
            else if (element instanceof Inductor) totalInductance += element.getValue();
        }

        System.out.println("Total resistance: " + totalResistance + " Ω");
        System.out.println("Total capacitance: " + (1 / totalCapacitanceInverse) + " F");
        System.out.println("Total inductance: " + totalInductance + " H");
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

        for (CircuitElement element : circuit.getElements()) {
            if (element instanceof Resistor) inverseResistance += 1 / element.getValue();
            else if (element instanceof Capacitor) totalCapacitance += element.getValue();
            else if (element instanceof Inductor) inverseInductance += 1 / element.getValue();
        }

        System.out.println("Total resistance: " + (1 / inverseResistance) + " Ω");
        System.out.println("Total capacitance: " + totalCapacitance + " F");
        System.out.println("Total inductance: " + (1 / inverseInductance) + " H");
    }
}
