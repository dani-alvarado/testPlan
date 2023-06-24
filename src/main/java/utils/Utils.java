package utils;

import java.util.Random;

public class Utils {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz1234567890";
    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static String calculateTax(double price) {
        double taxRate = 0.08; // This is the set tax rate for the app
        double orderTax = price * taxRate;

        return String.format("%.2f", orderTax);
    }

    public static String calculateTotalPrice(double price) {
        double orderTax = Double.parseDouble(calculateTax(price));
        return String.valueOf(orderTax+price);
    }
}
