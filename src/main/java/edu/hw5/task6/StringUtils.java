package edu.hw5.task6;

import java.util.regex.Pattern;

public class StringUtils {

    public static boolean isSubstring(String original, String sub) {
        Pattern pattern = Pattern.compile(sub);
        var matcher = pattern.matcher(original);
        return matcher.find();
    }

}
