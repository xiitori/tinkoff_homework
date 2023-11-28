package edu.hw3.task1;

public class Atbash {

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

        if (findLetter < 97 || findLetter > 122) {
            return letter;
        }

        char resultLetter = (char) (122 - (findLetter - 97));

        return isUpperCase ? Character.toUpperCase(resultLetter) : resultLetter;
    }
}
