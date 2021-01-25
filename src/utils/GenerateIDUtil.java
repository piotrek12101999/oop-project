package utils;

import java.util.UUID;

public class GenerateIDUtil {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
