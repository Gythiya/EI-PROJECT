package exercise1.creational.factory;

public class AlertFactory {

    public static Alert createAlert(String type, String message) {
        switch (type.toLowerCase()) {
            case "critical":
                return new CriticalAlert(message);
            case "warning":
                return new WarningAlert(message);
            case "info":
                return new InfoAlert(message);
            default:
                throw new IllegalArgumentException("Invalid alert type: " + type);
        }
    }
}
