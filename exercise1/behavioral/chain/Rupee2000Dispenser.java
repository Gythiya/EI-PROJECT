package exercise1.behavioral.chain;

public class Rupee2000Dispenser implements DispenseChain {
    private DispenseChain next;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.next = nextChain;
    }

    @Override
    public void dispense(int amount) {
        if (amount >= 2000) {
            int num = amount / 2000;
            int remainder = amount % 2000;
            System.out.println("Dispensing " + num + " x Rs.2000 notes");
            if (remainder != 0) next.dispense(remainder);
        } else {
            next.dispense(amount);
        }
    }
}
