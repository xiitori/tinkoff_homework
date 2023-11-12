package edu.hw5.task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

public class TimeUtils {

    private static final Pattern dateTimePattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2}), (\\d{2}):(\\d{2})");

    private TimeUtils() {

    }

    public static Duration getTimeSession(List<String> sessions) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

        var resultDuration = Duration.ZERO;

        for (String session : sessions) {
            var matcher = dateTimePattern.matcher(session);

            if (!matcher.find()) {
                throw new IllegalArgumentException();
            }
            LocalDateTime firstDate = LocalDateTime.parse(session.substring(matcher.start(), matcher.end()), formatter);

            if (!matcher.find()) {
                throw new IllegalArgumentException();
            }
            LocalDateTime secondDate = LocalDateTime.parse(session.substring(matcher.start(), matcher.end()), formatter);

            var duration = Duration.between(firstDate, secondDate);

            resultDuration = resultDuration.plus(duration);
        }

        return resultDuration.dividedBy(sessions.size());
    }
}
