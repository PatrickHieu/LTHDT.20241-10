package src.elements;

public abstract class CircuitElement {
    private final String name;
    private final double value; // Giá trị: resistance, capacitance, inductance

    public CircuitElement(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public abstract double calculateVoltage(double current);

    public abstract double calculateCurrent(double voltage);

    public abstract double calculateResistance(double frequency);
}
