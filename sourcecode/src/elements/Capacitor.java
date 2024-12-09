package src.elements;

public class Capacitor extends CircuitElement {

    public Capacitor(String name, double capacitance) {
        super(name, capacitance);
    }

    @Override
    public double calculateVoltage(double current) {
        // Tính trở kháng tụ điện: V = I * (1 / 2πfC)
        double frequency = 50; 
        return current * (-1 / (2 * Math.PI * frequency * getValue()));
    }

    @Override
    public double calculateCurrent(double voltage) {
        // Tính I = V * (2πfC)
        double frequency = 50;
        return voltage * (2 * Math.PI * frequency * getValue());
    }
}
