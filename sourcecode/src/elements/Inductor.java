package elements;

public class Inductor extends CircuitElement {

    public Inductor(String name, double inductance) {
        super(name, inductance);
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
