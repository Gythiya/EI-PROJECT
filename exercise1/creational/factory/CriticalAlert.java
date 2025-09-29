package exercise1.creational.factory;

public class CriticalAlert implements Alert {
    private String message;

    public CriticalAlert(String message) {
        this.message = message;
    }

    @Override
    public void trigger() {
        System.out.println("\n[CRITICAL ALERT] " + message);
        System.out.println("Siren ON, Flash Red Light, Notify all Members!");
    }

    @Override
    public String getMessage() {
        return message;
    }
}