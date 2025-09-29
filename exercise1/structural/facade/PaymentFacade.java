package exercise1.structural.facade;

public class PaymentFacade {
    private FraudCheckService fraudCheck;
    private PaymentGateway paymentGateway;
    private InvoiceService invoiceService;
    private NotificationService notificationService;

    public PaymentFacade() {
        this.fraudCheck = new FraudCheckService();
        this.paymentGateway = new PaymentGateway();
        this.invoiceService = new InvoiceService();
        this.notificationService = new NotificationService();
    }

    public void processPayment(Order order) {
        if(fraudCheck.check(order)) {
            paymentGateway.pay(order);
            invoiceService.generate(order);
            notificationService.notifyCustomer(order);
            System.out.println("Payment processed successfully!\n");
        } else {
            System.out.println("Payment failed due to fraud detection.\n");
        }
    }
}
