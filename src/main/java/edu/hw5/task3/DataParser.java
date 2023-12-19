package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

public class DataParser {

    private static final Pattern ENGLISH_DATE_FORMAT = Pattern.compile("((\\d{4})-(\\d{1,2})-(\\d{1,2}))");

    private static final Pattern RUSSIAN_DATE_FORMAT = Pattern.compile("((\\d{1,2})/(\\d{1,2})/(\\d{2}|\\d{4}))");

    private static final Pattern DAYS_AGO_FORMAT = Pattern.compile("(\\d)+ days ago");

    private DataParser() {

    }

    public Optional<LocalDate> parseDate(String string) {
        Optional<LocalDate> optionalLocalDate = Optional.empty();
//        var matcher = ENGLISH_DATE_FORMAT.matcher(string);
//        if (matcher.matches()) {
//
//        }
//
//        matcher = RUSSIAN_DATE_FORMAT.matcher(string);
//        if (matcher.matches()) {
//
//        }
//
//        matcher = DAYS_AGO_FORMAT.matcher(string);
//        if (matcher.matches()) {
//
//        } else if (string.equals("tomorrow")) {
//            optionalLocalDate = Optional.of(LocalDate.now().plusDays(1));
//        } else if (string.equals("today")) {
//            optionalLocalDate = Optional.of(LocalDate.now());
//        } else if (string.equals("yesterday")) {
//            optionalLocalDate = Optional.of(LocalDate.now().minusDays(1));
//        }
        return optionalLocalDate;
    }
}
