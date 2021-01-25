package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetStringFromUserUtil {
    public static Boolean validate(Pattern pattern, String data) {
        Matcher matcher = pattern.matcher(data);
        return matcher.find();
    }

    public static String getData(String message, boolean shouldValidate, Pattern pattern) {
        Scanner console = new Scanner(System.in);
        String value;

        do {
            System.out.println(message);
            value = console.nextLine();
        } while (value.equals("") || (shouldValidate && !validate(pattern, value)));

        return value;
    }
}
