package edu.hw3.task4;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("MagicNumber")
public class DigitConverter {

    private static final int MAX_CONVERTIBLE = 5999;

    private static final Map<String, Integer> ROMAN_NUMERALS = new LinkedHashMap<>();

    static {
        ROMAN_NUMERALS.put("M", 1000);
        ROMAN_NUMERALS.put("CM", 900);
        ROMAN_NUMERALS.put("D", 500);
        ROMAN_NUMERALS.put("CD", 400);
        ROMAN_NUMERALS.put("C", 100);
        ROMAN_NUMERALS.put("XC", 90);
        ROMAN_NUMERALS.put("L", 50);
        ROMAN_NUMERALS.put("XL", 40);
        ROMAN_NUMERALS.put("X", 10);
        ROMAN_NUMERALS.put("IX", 9);
        ROMAN_NUMERALS.put("V", 5);
        ROMAN_NUMERALS.put("IV", 4);
        ROMAN_NUMERALS.put("I", 1);
    }

    private DigitConverter() {
    }

    public static String convertToRoman(int arabian) {
        if (arabian <= 0 || arabian > MAX_CONVERTIBLE) {
            return "";
        }
        int digit = arabian;
        StringBuilder romanDigit = new StringBuilder();
        while (digit > 0) {
            Set<Map.Entry<String, Integer>> set = ROMAN_NUMERALS.entrySet();
            for (var entry : set) {
                if (digit >= entry.getValue()) {
                    romanDigit.append(entry.getKey());
                    digit -= entry.getValue();
                    break;
                }
            }
        }
        return romanDigit.toString();
    }
}
