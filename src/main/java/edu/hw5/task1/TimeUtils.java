package edu.hw5.task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

public class TimeUtils {

    private static final Pattern DATE_TIME_PATTERN = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2}), (\\d{2}):(\\d{2})");

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

    private TimeUtils() {

    }

    public static String getTimeSession(List<String> sessions) {
        var averageDuration = Duration.ZERO;

        for (String session : sessions) {
            var matcher = DATE_TIME_PATTERN.matcher(session);

            if (!matcher.find()) {
                throw new ParseDateException();
            }
            int startIndex = matcher.start();
            int endIndex = matcher.end();

            LocalDateTime firstDate = LocalDateTime.parse(session.substring(startIndex, endIndex), FORMATTER);

            if (!matcher.find()) {
                throw new ParseDateException();
            }
            startIndex = matcher.start();
            endIndex = matcher.end();

            LocalDateTime secondDate = LocalDateTime.parse(session.substring(startIndex, endIndex), FORMATTER);

            var duration = Duration.between(firstDate, secondDate);

            if (duration.isNegative()) {
                throw new IllegalArgumentException();
            }

            averageDuration = averageDuration.plus(duration);
        }

        averageDuration = averageDuration.dividedBy(sessions.size());

        return averageDuration.toString();
    }
}
