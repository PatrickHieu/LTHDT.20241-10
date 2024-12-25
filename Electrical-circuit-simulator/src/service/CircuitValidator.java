package service;

import models.circuit.Circuit;
import models.elements.CircuitElement;

public class CircuitValidator {

    public static boolean validateCircuit(Circuit circuit) {
        if (circuit.getElements().isEmpty()) {
            System.out.println("Validation failed: Circuit has no elements.");
            return false;
        }

        for (CircuitElement element : circuit.getElements()) {
            if (element.getValue() <= 0) {
                System.out.println("Validation failed: Element " + element.getName() + " has invalid value.");
                return false;
            }
        }

        System.out.println("Circuit validation passed.");
        return true;
    }
}
