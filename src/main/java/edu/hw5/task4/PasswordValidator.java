package edu.hw5.task4;

import java.util.regex.Pattern;

public class PasswordValidator {

    private static final Pattern specialSymbolPattern = Pattern.compile("[~!@#$%^&*|]");

    private PasswordValidator() {
    }

    public static boolean validate(String password) {
        var matcher = specialSymbolPattern.matcher(password);
        return matcher.find();
    }

}
