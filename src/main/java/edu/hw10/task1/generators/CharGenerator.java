package edu.hw10.task1.generators;

import java.lang.annotation.Annotation;
import java.util.concurrent.ThreadLocalRandom;

public class CharGenerator implements ArgumentGenerator {

    private static final int MAX_SYMBOL = 55296;

    @Override
    public Object generate(Annotation[] annotations) {
        return (char) ThreadLocalRandom.current().nextInt(MAX_SYMBOL);
    }
}
