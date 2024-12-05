package elements;

public class Resistor extends CircuitElement {

    public Resistor(String name, double resistance) {
        super(name, resistance);
    }

    @Override
    public double calculateVoltage() {
        return getValue();
    }
    @Override
    public double calculateCurrent() {
        return getValue();
    }
}