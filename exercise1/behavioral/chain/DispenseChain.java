package exercise1.behavioral.chain;

public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(int amount);
}
