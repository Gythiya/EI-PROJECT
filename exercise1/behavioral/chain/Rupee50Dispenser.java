package exercise1.behavioral.chain;

public class Rupee50Dispenser implements DispenseChain {
    private DispenseChain next;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.next = nextChain;
    }

    @Override
    public void dispense(int amount) {
        if (amount >= 50) {
            int num = amount / 50;
            int remainder = amount % 50;
            System.out.println("Dispensing " + num + " x Rs.50 notes");
            if (remainder != 0) next.dispense(remainder);
        } else {
            if (amount != 0) {
                System.out.println("Cannot dispense ₹" + amount + " (not a multiple of 50)");
            }
        }
    }
}
