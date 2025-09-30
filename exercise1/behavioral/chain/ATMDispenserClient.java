package exercise1.behavioral.chain;

import java.util.Scanner;

public class ATMDispenserClient {
    public static void main(String[] args) {
        // initialize the chain
        DispenseChain d2000 = new Rupee2000Dispenser();
        DispenseChain d500 = new Rupee500Dispenser();
        DispenseChain d100 = new Rupee100Dispenser();
        DispenseChain d50 = new Rupee50Dispenser();

        // set the chain of responsibility
        d2000.setNextChain(d500);
        d500.setNextChain(d100);
        d100.setNextChain(d50);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter amount to dispense (multiple of 50, 0 to exit): ");
            int amount = sc.nextInt();

            if (amount == 0) {
                System.out.println("Exiting ATM. Thank you!");
                break;
            } else if (amount % 50 != 0) {
                System.out.println("Amount must be multiple of 50!");
            } else {
                d2000.dispense(amount);
            }
        }
        sc.close();
    }
}
