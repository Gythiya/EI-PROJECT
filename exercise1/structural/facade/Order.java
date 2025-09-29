package exercise1.structural.facade;

public class Order {
    private int orderId;
    private double amount;
    private String customerName;

    public Order(int orderId, double amount, String customerName) {
        this.orderId = orderId;
        this.amount = amount;
        this.customerName = customerName;
    }

    public int getOrderId() { return orderId; }
    public double getAmount() { return amount; }
    public String getCustomerName() { return customerName; }
}
