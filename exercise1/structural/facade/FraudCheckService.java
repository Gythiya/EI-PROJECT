package exercise1.structural.facade;

public class FraudCheckService {
    public boolean check(Order order) {
        System.out.println("Performing fraud check for order: " + order.getOrderId());
        // Dummy logic; in real system, add rules
        return true;
    }
}
