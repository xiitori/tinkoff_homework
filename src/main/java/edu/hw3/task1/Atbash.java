package edu.hw3.task1;

public class Atbash {

    private static final int MIN_CHAR_VALUE = 97;

    private static final int MAX_CHAR_VALUE = 122;

    private Atbash() {

    }

    public static String atbash(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            stringBuilder.append(getAtbashLetter(letter));
        }
        return stringBuilder.toString();
    }

    private static char getAtbashLetter(char letter) {
        boolean isUpperCase = false;
        char findLetter;
        if (Character.isUpperCase(letter)) {
            isUpperCase = true;
            findLetter = Character.toLowerCase(letter);
        } else {
            findLetter = letter;
        }

        if (findLetter < MIN_CHAR_VALUE || findLetter > MAX_CHAR_VALUE) {
            return letter;
        }

        char resultLetter = (char) (MAX_CHAR_VALUE - (findLetter - MIN_CHAR_VALUE));

        return isUpperCase ? Character.toUpperCase(resultLetter) : resultLetter;
    }
}
