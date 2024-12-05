import circuit.Circuit;
import elements.Capacitor;
import elements.Inductor;
import elements.Resistor;
import simulator.CircuitAnalyzer;

public class Main {
    public static void main(String[] args) {
        //Create Serial Circuit
        Circuit circuit = new Circuit("Serial");

        //Add elements
        circuit.addElement(new Resistor("R1", 100));
        circuit.addElement(new Capacitor("C2", 0.000001));
        circuit.addElement(new Inductor("L3", 0.1));

        //Analyze circuit
        CircuitAnalyzer.analyzeSerial(circuit, 12);

        //Create Parallel Circuit
        Circuit parallelCircuit = new Circuit("Parallel");

        //Add elements
        parallelCircuit.addElement(new Resistor("R1", 200));
        parallelCircuit.addElement(new Capacitor("C2", 0.000002));
        parallelCircuit.addElement(new Inductor("L3", 0.02));

        //Analyze circuit
        CircuitAnalyzer.analyzeParallel(circuit, 12);
    }
}
