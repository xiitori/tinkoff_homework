package edu.hw5.task7;

import java.util.regex.Pattern;

public class BinaryStringValidator {

    private static final Pattern NO_LESS_3_AND_THIRD_SYMBOL_IS_ZERO = Pattern.compile("^([01])([01])0(0|1*)$");

    private static final Pattern FIRST_AND_LAST_SYMBOL_EQUALS = Pattern.compile("^(0|1)[01]*\\1$");

    private static final Pattern NO_LESS_1_AND_NO_MORE_3 = Pattern.compile("^([01]{1,3})$");

    private BinaryStringValidator() {
    }

    public static boolean isLengthNoLess3AndThirdSymbolIsZero(String binaryString) {
        var matcher = NO_LESS_3_AND_THIRD_SYMBOL_IS_ZERO.matcher(binaryString);
        return matcher.matches();
    }

    public static boolean isFirstAndLastSymbolEquals(String binaryString) {
        var matcher = FIRST_AND_LAST_SYMBOL_EQUALS.matcher(binaryString);
        return matcher.matches();
    }

    public static boolean isLengthNoLess1AndNoMore3(String binaryString) {
        var matcher = NO_LESS_1_AND_NO_MORE_3.matcher(binaryString);
        return matcher.matches();
    }
}
