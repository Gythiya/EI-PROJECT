package exercise1.creational.factory;

public class WarningAlert implements Alert {
    private String message;

    public WarningAlert(String message) {
        this.message = message;
    }

    @Override
    public void trigger() {
        System.out.println("\n[WARNING ALERT] " + message);
        System.out.println(" Display yellow warning, log for monitoring.");
    }

    @Override
    public String getMessage() {
        return message;
    }
}

