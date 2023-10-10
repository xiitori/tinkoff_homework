package edu.hw1;

public class Task3 {

    private Task3() {

    }

    public static boolean isNestable(int[] first, int[] second) {
        int firstMin = findMin(first);
        int firstMax = findMax(first);
        int secondMin = findMin(second);
        int secondMax = findMax(second);

        return firstMin > secondMin && firstMax < secondMax;
    }

    private static int findMin(int[] array) {
        if (array == null || array.length < 1) {
            throw new RuntimeException();
        }
        int min = array[0];
        for (int i : array) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    private static int findMax(int[] array) {
        if (array == null || array.length < 1) {
            throw new RuntimeException();
        }
        int max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
