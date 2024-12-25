package models.circuit;

public class CircuitFactory {

    public static Circuit createCircuit(CircuitType type) {
        return new Circuit(); // Hiện tại cả Serial và Parallel đều sử dụng chung Circuit
    }
}
