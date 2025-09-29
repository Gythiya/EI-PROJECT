package exercise1.structural.adapter;

import java.util.Scanner;

public class SensorManager {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("\n=== Sensor Data Control Center ===");
        System.out.println("1. Read JSON Sensor");
        System.out.println("2. Read CSV Sensor");
        System.out.println("3. Exit");

        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                SensorData jsonAdapter = new SensorAdapter(new JsonSensor());
                jsonAdapter.readData();
                start();
                break;

            case "2":
                SensorData csvAdapter = new SensorAdapter(new CsvSensor());
                csvAdapter.readData();
                start();
                break;

            case "3":
                System.out.println("Exiting program.");
                scanner.close();
                break;

            default:
                System.out.println("Invalid choice. Try again.");
                start();
                break;
        }
    }
}
