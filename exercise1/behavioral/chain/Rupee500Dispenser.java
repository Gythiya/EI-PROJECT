package exercise1.behavioral.chain;

public class Rupee500Dispenser implements DispenseChain {
    private DispenseChain next;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.next = nextChain;
    }

    @Override
    public void dispense(int amount) {
        if (amount >= 500) {
            int num = amount / 500;
            int remainder = amount % 500;
            System.out.println("Dispensing " + num + " x Rs.500 notes");
            if (remainder != 0) next.dispense(remainder);
        } else {
            next.dispense(amount);
        }
    }
}
