package src.elements;

public class Inductor extends CircuitElement {

    public Inductor(String name, double inductance) {
        super(name, inductance);
    }

    @Override
    public double calculateVoltage(double current) {
        double frequency = 50; 
        return current * (2 * Math.PI * frequency * getValue());
    }

    @Override
    public double calculateCurrent(double voltage) {
        double frequency = 50;
        return voltage / (2 * Math.PI * frequency * getValue());
    }
    @Override
    public String toString() {
        return "Inductor{name='" + getName() + "', inductance=" + getValue() + "}";
    }


}
