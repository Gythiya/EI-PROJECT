package exercise1.structural.facade;

public class InvoiceService {
    public void generate(Order order) {
        System.out.println("Generating invoice for order: " + order.getOrderId());
    }
}
