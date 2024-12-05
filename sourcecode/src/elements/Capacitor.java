package elements;

public class Capacitor extends CircuitElement {

    public Capacitor(String name, double capacitance) {
        super(name, capacitance);
    }

    @Override
    public double calculateVoltage() {
        return 0;
    }

    @Override
    public double calculateCurrent() {
        return 0;
    }
}
