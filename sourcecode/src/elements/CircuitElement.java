package elements;

public abstract class CircuitElement {
    protected String name;
    protected double value;

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

    public abstract double calculateVoltage();
    public abstract double calculateCurrent();
}