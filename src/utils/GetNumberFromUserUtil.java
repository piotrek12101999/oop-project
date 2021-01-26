package utils;

import java.util.Scanner;

public class GetNumberFromUserUtil {
    private static Scanner handleInputCreation(String message) {
        System.out.println(message);
        Scanner console = new Scanner(System.in);
        return console;
    }

    public static int getInt(String message) {
        Scanner console = handleInputCreation(message);
        return console.nextInt();
    }

    public static double getDouble(String message) {
        Scanner console = handleInputCreation(message);
        return console.nextDouble();
    }
}
