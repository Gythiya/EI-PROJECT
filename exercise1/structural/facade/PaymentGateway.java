package exercise1.structural.facade;

public class PaymentGateway {
    public void pay(Order order) {
        System.out.println("Processing payment of Rs." + order.getAmount() + " for " + order.getCustomerName());
    }
}
