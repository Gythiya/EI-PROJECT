package exercise1.behavioral.strategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        System.out.print("Enter amount to pay: ");
        int amount = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Choose Payment Method: ");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");

        int choice = sc.nextInt();
        sc.nextLine(); 

        switch (choice) {
            case 1:
                System.out.print("Enter Credit Card Number: ");
                String cardNumber = sc.nextLine();
                cart.setPaymentStrategy(new CreditCardPayment(cardNumber));
                break;

            case 2:
                System.out.print("Enter UPI ID: ");
                String upiId = sc.nextLine();
                cart.setPaymentStrategy(new UPIPayment(upiId));
                break;

            default:
                System.out.println("Invalid choice! Exiting...");
                sc.close();
                return;
        }

        cart.checkout(amount);
        sc.close();
    }
}