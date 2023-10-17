package edu.hw1;

public class Task4 {

    private Task4() {

    }

    public static String fixString(String string) {
        if (string == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        char[] chars = string.toCharArray();
        for (int i = 0; i < string.length() - 1; i += 2) {
            result.append(chars[i + 1]);
            result.append(chars[i]);
        }
        if (string.length() % 2 != 0) {
            result.append(chars[chars.length - 1]);
        }
        return result.toString();
    }
}
