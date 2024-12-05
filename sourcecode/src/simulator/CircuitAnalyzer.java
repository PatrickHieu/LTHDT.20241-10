package simulator;

import circuit.Circuit;
import elements.CircuitElement;

public class CircuitAnalyzer {
    public static void analyzeSerial(Circuit circuit, double sourceVoltage) {
        double req = circuit.calculateER();
        double current = sourceVoltage / req;   //Ohm: U = I * Req
        System.out.println("Current: " + current);

        for (CircuitElement element : circuit.getElements()) {
            double voltage = current * element.getValue();
            System.out.println("Voltage of " + element.getName() + ": " + voltage);
        }
    }

    public static void analyzeParallel(Circuit circuit, double sourceVoltage) {
        double req = circuit.calculateER();
        double current = sourceVoltage / req;
        System.out.println("Current: " + current);

        for (CircuitElement element : circuit.getElements()) {
            double voltage = sourceVoltage;
            double elementCurrent = voltage / element.getValue();
            System.out.println("Current of " + element.getName() + ": " + elementCurrent);
        }
    }
}
