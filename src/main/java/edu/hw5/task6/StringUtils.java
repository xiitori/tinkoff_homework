package edu.hw5.task6;

import java.util.regex.Pattern;

public class StringUtils {

    public static boolean isSubstring(String main, String sub) {
        if (sub.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile(sub);
        var matcher = pattern.matcher(main);
        return matcher.find();
    }

}
