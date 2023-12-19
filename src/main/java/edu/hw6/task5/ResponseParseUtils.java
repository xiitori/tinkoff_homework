package edu.hw6.task5;

import java.util.regex.Pattern;

public class ResponseParseUtils {

    private static final Pattern TITLE_PATTERN = Pattern.compile("\"title\":\"(.*?)\"");

    private ResponseParseUtils() {
    }

    static String getTitleFromBody(String body) {
        var matcher = TITLE_PATTERN.matcher(body);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new IllegalArgumentException();
        }
    }

    static long[] parseBodyToArray(String body) {
        String[] data = body.substring(1, body.length() - 1).split(",");
        long[] resultData = new long[data.length];

        for (int i = 0; i < data.length; i++) {
            resultData[i] = Long.parseLong(data[i]);
        }

        return resultData;
    }
}
