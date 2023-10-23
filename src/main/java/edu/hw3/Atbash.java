package edu.hw3;

public class Atbash {

    private Atbash() {

    }

    private static final char[] DICTIONARY = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

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

        for (int i = 0; i < DICTIONARY.length; i++) {
            if (DICTIONARY[i] == findLetter) {
                return isUpperCase ? Character.toUpperCase(DICTIONARY[DICTIONARY.length - 1 - i])
                    : DICTIONARY[DICTIONARY.length - 1 - i];
            }
        }
        return letter;
    }
}
