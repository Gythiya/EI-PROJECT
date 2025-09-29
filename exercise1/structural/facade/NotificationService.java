package exercise1.structural.facade;

public class NotificationService {
    public void notifyCustomer(Order order) {
        System.out.println("Sending notification to " + order.getCustomerName());
    }
}
