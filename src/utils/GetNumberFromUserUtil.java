package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetNumberFromUserUtil {
    private static Scanner handleInputCreation(String message) {
        System.out.println(message);
        Scanner console = new Scanner(System.in);
        return console;
    }

    public static int getInt(String message) throws InputMismatchException {
        Scanner console = handleInputCreation(message);
        try {
            return console.nextInt();
        } catch (java.util.InputMismatchException error) {
            throw new InputMismatchException("Please provide number");
        }
    }

    public static double getDouble(String message) throws InputMismatchException {
        Scanner console = handleInputCreation(message);
        try {
            return console.nextDouble();
        } catch (java.util.InputMismatchException error) {
            throw new InputMismatchException("Please provide number");
        }
    }
}
