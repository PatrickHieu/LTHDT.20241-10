package service;

import models.circuit.Circuit;
import models.elements.CircuitElement;

public class DetectCircuit {

    public static boolean detectShortCircuit(Circuit circuit, String circuitType) {
        for (CircuitElement element : circuit.getElements()) {
            if (element.calculateResistance(0) == 0) {
                System.out.println(
                        "Short circuit detected at element " + element.getName() + " in " + circuitType + " Circuit!");
                return true;
            }
        }
        System.out.println("No short circuit detected in " + circuitType + " Circuit.");
        return false;
    }
}
