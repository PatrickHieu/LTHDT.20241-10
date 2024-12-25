package simulator;

import java.util.Scanner;

import service.CircuitAnalyzer;
import models.circuit.Circuit;
import models.elements.Capacitor;
import models.elements.Inductor;
import models.elements.Resistor;
import service.DetectCircuit;

public class CircuitSimulator {
    public static void runInteractiveMenu(Circuit serialCircuit, Circuit parallelCircuit) {
        Scanner scanner = new Scanner(System.in);

        double sourceVoltage = 10.0; // Giá trị điện áp nguồn mặc định

        while (true) {
            System.out.println("\nCircuit Simulator");
            System.out.println("1. Add Element to Serial Circuit");
            System.out.println("2. Add Element to Parallel Circuit");
            System.out.println("3. Show Serial Circuit");
            System.out.println("4. Show Parallel Circuit");
            System.out.println("5. Analyze Serial Circuit");
            System.out.println("6. Analyze Parallel Circuit");
            System.out.println("7. Clear Parallel Circuit");
            System.out.println("8. Clear Parallel Circuit");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addElementToCircuit(serialCircuit, scanner, "Serial");
                case 2 -> addElementToCircuit(parallelCircuit, scanner, "Parallel");
                case 3 -> displayCircuitWithSubOptions(serialCircuit, "Serial", scanner);
                case 4 -> displayCircuitWithSubOptions(parallelCircuit, "Parallel", scanner);
                case 5 -> CircuitAnalyzer.analyzeSerial(serialCircuit, sourceVoltage);
                case 6 -> CircuitAnalyzer.analyzeParallel(parallelCircuit, sourceVoltage);
                case 7 -> clearCircuit(serialCircuit, "Serial");
                case 8 -> clearCircuit(parallelCircuit, "Parallel");
                case 0 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addElementToCircuit(Circuit circuit, Scanner scanner, String circuitType) {
        System.out.println("\nAdd Element to " + circuitType + " Circuit:");
        System.out.println("1. Add Resistor");
        System.out.println("2. Add Capacitor");
        System.out.println("3. Add Inductor");
        System.out.print("Choose an element to add: ");

        int elementChoice = scanner.nextInt();
        switch (elementChoice) {
            case 1 -> addResistor(circuit, scanner);
            case 2 -> addCapacitor(circuit, scanner);
            case 3 -> addInductor(circuit, scanner);
            default -> System.out.println("Invalid element choice. Try again.");
        }

        if (DetectCircuit.detectShortCircuit(circuit, circuitType)) {
            System.out.println("Warning: Short Circuit detected! Please check the circuit.");
        }
    }

    private static void addResistor(Circuit circuit, Scanner scanner) {
        System.out.print("Enter resistor name: ");
        String name = scanner.next();
        System.out.print("Enter resistance (\u03A9): ");
        double value = scanner.nextDouble();
        circuit.addElement(new Resistor(name, value));
        System.out.println("Resistor " + name + " added with resistance: " + value + " Ω.");
    }

    private static void addCapacitor(Circuit circuit, Scanner scanner) {
        System.out.print("Enter capacitor name: ");
        String name = scanner.next();
        System.out.print("Enter capacitance (F): ");
        double value = scanner.nextDouble();
        circuit.addElement(new Capacitor(name, value));
        System.out.println("Capacitor " + name + " added with capacitance: " + value + " F.");
    }

    private static void addInductor(Circuit circuit, Scanner scanner) {
        System.out.print("Enter inductor name: ");
        String name = scanner.next();
        System.out.print("Enter inductance (H): ");
        double value = scanner.nextDouble();
        circuit.addElement(new Inductor(name, value));
        System.out.println("Inductor " + name + " added with inductance: " + value + " H.");
    }

    private static void displayCircuitWithSubOptions(Circuit circuit, String circuitType, Scanner scanner) {
        while (true) {
            System.out.println("\nShow " + circuitType + " Circuit:");
            System.out.println("1. Show Resistors");
            System.out.println("2. Show Capacitors");
            System.out.println("3. Show Inductors");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int subChoice = scanner.nextInt();
            switch (subChoice) {
                case 1 -> circuit.displayCircuitDiagram("Resistor");
                case 2 -> circuit.displayCircuitDiagram("Capacitor");
                case 3 -> circuit.displayCircuitDiagram("Inductor");
                case 0 -> {
                    return; // Quay lại menu chính
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void clearCircuit(Circuit circuit, String circuitType) {
        circuit.clear();
        System.out.println(circuitType + " Circuit has been cleared.");
    }
}
