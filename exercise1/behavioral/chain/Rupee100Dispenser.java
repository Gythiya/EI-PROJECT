package exercise1.behavioral.chain;

public class Rupee100Dispenser implements DispenseChain {
    private DispenseChain next;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.next = nextChain;
    }

    @Override
    public void dispense(int amount) {
        if (amount >= 100) {
            int num = amount / 100;
            int remainder = amount % 100;
            System.out.println("Dispensing " + num + " x Rs.100 notes");
            if (remainder != 0) next.dispense(remainder);
        } else {
            next.dispense(amount);
        }
    }
}
