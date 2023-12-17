package edu.hw10.task1.generators;

import edu.hw10.task1.annotations.NotNull;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class StringGenerator implements ArgumentGenerator {

    private static final int MIN_CHAR = 97;

    private static final int MAX_CHAR = 123;

    private static final int MIN_LENGTH = 6;

    private static final int MAX_LENGTH = 20;

    @Override
    public Object generate(Annotation[] annotations) {
        if (Arrays.stream(annotations).anyMatch(annotation -> annotation.annotationType() == NotNull.class)) {
            return getRandomString();
        } else {
            return ThreadLocalRandom.current().nextInt(2) == 1 ? null : getRandomString();
        }
    }

    private static String getRandomString() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = ThreadLocalRandom.current().nextInt(MIN_LENGTH, MAX_LENGTH);
        for (int i = 0; i < length; i++) {
            char ch = (char) ThreadLocalRandom.current().nextInt(MIN_CHAR, MAX_CHAR);
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
