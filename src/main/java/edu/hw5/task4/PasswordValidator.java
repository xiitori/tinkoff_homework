package edu.hw5.task4;

import java.util.regex.Pattern;

public class PasswordValidator {

    private static final Pattern SPECIAL_SYMBOL_PATTERN = Pattern.compile("[~!@#$%^&*|]");

    private PasswordValidator() {
    }

    public static boolean validate(String password) {
        var matcher = SPECIAL_SYMBOL_PATTERN.matcher(password);
        return matcher.find();
    }

}
