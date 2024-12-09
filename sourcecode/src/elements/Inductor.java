package src.elements;

public class Inductor extends CircuitElement {

    public Inductor(String name, double inductance) {
        super(name, inductance);
    }

    @Override
    public double calculateVoltage(double current) {
        // tính trở kháng cuộn cảm: V = I * (2πfL)
        double frequency = 50; 
        return current * (2 * Math.PI * frequency * getValue());
    }

    @Override
    public double calculateCurrent(double voltage) {
       // tính I = V / (2πfL)
        double frequency = 50;
        return voltage / (2 * Math.PI * frequency * getValue());
    }
}
