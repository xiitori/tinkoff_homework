package edu.hw1;

public class Task7 {

    private Task7() {

    }

    public static int rotateLeft(int n, int shift) {
        if (n < 0) {
            return -1;
        }
        StringBuilder binary = new StringBuilder(Integer.toBinaryString(n));
        for (int i = 0; i < shift; i++) {
            char ch = binary.charAt(0);
            binary.deleteCharAt(0);
            binary.append(ch);
        }

        int result = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            result += Integer.parseInt(String.valueOf(binary.charAt(i))) * (int) Math.pow(2, binary.length() - 1 - i);
        }
        return result;
    }

    public static int rotateRight(int n, int shift) {
        if (n < 0) {
            return -1;
        }
        StringBuilder binary = new StringBuilder(Integer.toBinaryString(n));
        for (int i = 0; i < shift; i++) {
            char ch = binary.charAt(binary.length() - 1);
            binary.deleteCharAt(binary.length() - 1);
            binary.insert(0, ch);
        }

        int result = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            result += Integer.parseInt(String.valueOf(binary.charAt(i))) * (int) Math.pow(2, binary.length() - 1 - i);
        }
        return result;
    }
}
