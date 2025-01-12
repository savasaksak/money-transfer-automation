package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {
    public static void waitFor(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String generateTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
        return now.format(formatter);
    }
}
