package exercise1.creational.factory;

import java.util.Scanner;

public class AlertManager {
    private Scanner scanner;

    public AlertManager() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\n=== Alert Control Center ===");
        System.out.println("1. Create New Alert");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                createAlert();
                start(); 
                break;

            case "2":
                System.out.println("Exiting program.");
                scanner.close();
                break;

            default:
                System.out.println("\nInvalid choice. Try again.\n");
                start(); 
                break;
        }
    }

    private void createAlert() {
        System.out.print("Enter alert type (critical/warning/info): ");
        String type = scanner.nextLine().trim().toLowerCase();

        if (!type.equals("critical") && !type.equals("warning") && !type.equals("info")) {
            System.out.println("\nInvalid alert type! Must be: critical, warning, or info.\n");
            return; 
        }

        System.out.print("Enter alert message: ");
        String message = scanner.nextLine().trim();

        Alert alert = AlertFactory.createAlert(type, message);
        System.out.println("\nAlert created successfully!\n");
        alert.trigger();
    }
}
