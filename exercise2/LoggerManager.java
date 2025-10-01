package exercise2;

public class LoggerManager {

    private static LoggerManager instance;
    private LoggerManager() {}

    public static LoggerManager getInstance() {
        if(instance == null) instance = new LoggerManager();
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
