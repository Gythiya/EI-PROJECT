package exercise2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerManager {

    private static LoggerManager instance;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private LoggerManager() {}

    public static LoggerManager getInstance() {
        if (instance == null) instance = new LoggerManager();
        return instance;
    }

    public void log(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[" + timestamp + "] " + message);
    }
}
