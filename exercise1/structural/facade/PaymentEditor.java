package exercise1.structural.facade;

import java.util.Scanner;

public class PaymentEditor {
    private PaymentFacade paymentFacade;
    private Scanner scanner;

    public PaymentEditor() {
        this.paymentFacade = new PaymentFacade();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\n=== Payment Control Center ===");
        System.out.println("1. Confirm Order and Process Payment");
        System.out.println("2. Exit");

        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine().trim();

        switch(choice) {
            case "1":
                createAndProcessOrder();
                start(); 
                break;
            case "2":
                System.out.println("Exiting program.");
                scanner.close();
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                start();
                break;
        }
    }

    private void createAndProcessOrder() {
        try {
            System.out.print("Enter Order ID: ");
            int orderId = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Customer Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Payment Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            Order order = new Order(orderId, amount, name);
            paymentFacade.processPayment(order);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter correct numbers for Order ID and Amount.");
        }
    }
}
