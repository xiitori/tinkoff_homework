package edu.hw1;

public class Task5 {

    private Task5() {

    }



    public static boolean isPalindromeDescendant(int number) {
        String strNum = String.valueOf(number);

        if (strNum.length() == 1) {
            return false;
        }

        if (isPalindrome(number)) {
            return true;
        } else {
            StringBuilder newNumber = new StringBuilder();
            char[] digits = strNum.toCharArray();
            for (int i = 0; i < strNum.length() - 1; i += 2) {
                newNumber.append((Integer.parseInt(String.valueOf(digits[i + 1])))
                    + (Integer.parseInt(String.valueOf(digits[i]))));
            }
            if (strNum.length() % 2 != 0) { //если число нечетное, то последнюю цифру добавляем в конец
                newNumber.append(digits[digits.length - 1]);
            }
            if (newNumber.toString().length() > 1) {
                return isPalindromeDescendant(Integer.parseInt(newNumber.toString()));
            } else {
                return false;
            }
        }
    }

    private static boolean isPalindrome(int number) {
        String strNum = String.valueOf(number);
        char[] chars = strNum.toCharArray();
        int middle = chars.length / 2;
        for (int i = 0; i < middle; i++) {
            if (!(chars[i] == chars[chars.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }
}
