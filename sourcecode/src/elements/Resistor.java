package src.elements;

public class Resistor extends CircuitElement {

    public Resistor(String name, double resistance) {
        super(name, resistance);
    }

    @Override
    public double calculateVoltage(double current) {
        return current * getValue(); // V = I * R
    }

    @Override
    public double calculateCurrent(double voltage) {
        return voltage / getValue(); // I = V / R
    }
    @Override
    public String toString() {
    return "Resistor{name='" + getName() + "', resistance=" + getValue() + "}";
}

}
