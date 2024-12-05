import circuit.Circuit;
import elements.Capacitor;
import elements.Inductor;
import elements.Resistor;
import simulator.CircuitAnalyzer;

public class Main {
    public static void main(String[] args) {
        Circuit circuit = new Circuit("Serial");

        //Add elements
        circuit.addElement(new Resistor("R1", 10));
        circuit.addElement(new Capacitor("C2", 0.0001));
        circuit.addElement(new Inductor("L3", 0.01));

        //Analyze circuit
        CircuitAnalyzer.analyzeSerial(circuit, 10);
    }
}
