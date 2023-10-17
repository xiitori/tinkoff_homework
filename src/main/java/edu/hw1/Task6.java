package edu.hw1;

import java.util.Arrays;

public class Task6 {

    private Task6() {

    }

    private static final int MIN_BORDER = 1000;

    private static final int MAX_BORDER = 9999;

    private static final int KAPREKAR_CONST = 6174;

    private static final int COUNT_DIGITS = 4;

    /* хотел не использовать анотацию, но не знаю как назвать переменную со значением 10 */
    @SuppressWarnings("MagicNumber")
    public static int countK(int number) {
        if (number < MIN_BORDER || number > MAX_BORDER) {
            return -1;
        }
        if (number == KAPREKAR_CONST) {
            return 0;
        }

        Integer[] digits = numberToDigitsArray(number);
        if (checkAllElementsSame(digits)) {
            return -1;
        }

        Arrays.sort(digits);
        int minNum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            minNum += digits[i] * (int) Math.pow(10, COUNT_DIGITS - 1 - i);
        }

        Arrays.sort(digits, (o1, o2) -> o2 - o1);
        int maxNum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            maxNum += digits[i] * (int) Math.pow(10, COUNT_DIGITS - 1 - i);
        }

        boolean isOver = maxNum - minNum == KAPREKAR_CONST;
        return 1 + (isOver ? 0 : countK(maxNum - minNum));
    }

    @SuppressWarnings("MagicNumber")
    private static Integer[] numberToDigitsArray(int number) {
        int n = number;
        Integer[] digits = new Integer[COUNT_DIGITS];
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n = n / 10;
        }
        return digits;
    }

    private static boolean checkAllElementsSame(Object[] array) {
        boolean isSameDigits = true;
        for (int i = 1; i < array.length; i++) {
            if (!array[i].equals(array[i - 1])) {
                isSameDigits = false;
                break;
            }
        }
        return isSameDigits;
    }
}
