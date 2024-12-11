package src;

import src.circuit.Circuit;
import src.elements.Capacitor;
import src.elements.Inductor;
import src.elements.Resistor;
import src.simulator.CircuitSimulator;

public class Main {
    public static void main(String[] args) {
        Circuit serialCircuit = new Circuit("Serial");
        serialCircuit.addElement(new Resistor("R1", 100));
        serialCircuit.addElement(new Capacitor("C2", 0.002));
        serialCircuit.addElement(new Inductor("L3", 0.1));

        Circuit parallelCircuit = new Circuit("Parallel");
        parallelCircuit.addElement(new Resistor("R1", 200));
        parallelCircuit.addElement(new Capacitor("C2", 0.004));
        parallelCircuit.addElement(new Inductor("L3", 0.2));

        CircuitSimulator.runInteractiveMenu(serialCircuit, parallelCircuit);
    }
}
