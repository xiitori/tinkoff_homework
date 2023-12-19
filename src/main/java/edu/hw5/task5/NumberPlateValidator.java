package edu.hw5.task5;

import java.util.regex.Pattern;

public class NumberPlateValidator {

    private static final Pattern NUMBER_PLATE_PATTERN = Pattern.compile(
        "^[АВЕКМНОРСТУХ](\\d{3})(?<!000)[АВЕКМНОРСТУХ]{2}(\\d{2,3})$");

    private NumberPlateValidator() {

    }

    public static boolean validate(String numberPlate) {
        return numberPlate.matches(NUMBER_PLATE_PATTERN.pattern());
    }
}
