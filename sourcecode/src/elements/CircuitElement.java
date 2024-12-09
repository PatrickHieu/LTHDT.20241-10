package src.elements;

public abstract class CircuitElement {
    protected final String name;
    protected final double value;

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

    public abstract double calculateVoltage(double voltage);
    public abstract double calculateCurrent(double current);
}
