package exercise1.creational.factory;

public class InfoAlert implements Alert {
    private String message;

    public InfoAlert(String message) {
        this.message = message;
    }

    @Override
    public void trigger() {
        System.out.println("\n[INFO ALERT] " + message);
        System.out.println(" Log information for reference.");
    }

    @Override
    public String getMessage() {
        return message;
    }
}
