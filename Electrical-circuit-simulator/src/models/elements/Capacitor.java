package models.elements;

public class Capacitor extends CircuitElement {

    public Capacitor(String name, double capacitance) {
        super(name, capacitance);
    }

    @Override
    public double calculateVoltage(double current) {
        double frequency = 50;
        return current * (-1 / (2 * Math.PI * frequency * getValue()));
    }

    @Override
    public double calculateCurrent(double voltage) {
        double frequency = 50;
        return voltage * (2 * Math.PI * frequency * getValue());
    }

    @Override
    public double calculateResistance(double frequency) {
        if (frequency == 0) {
            return Double.POSITIVE_INFINITY; // Mở mạch với DC
        }
        return 1 / (2 * Math.PI * frequency * getValue()); // Z = 1 / (2πfC)
    }

    @Override
    public String toString() {
        return "Capacitor{name='" + getName() + "', capacitance=" + getValue() + "}";
    }
}
