package edu.hw10.task1.generators;

import edu.hw10.task1.annotations.Max;
import edu.hw10.task1.annotations.Min;
import java.lang.annotation.Annotation;
import java.util.concurrent.ThreadLocalRandom;

public class IntGenerator implements ArgumentGenerator {
    @Override
    public Object generate(Annotation[] annotations) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (var annotation : annotations) {
            if (annotation.annotationType() == Max.class) {
                max = ((Max) annotation).value();
            } else if (annotation.annotationType() == Min.class) {
                min = ((Min) annotation).value();
            }
        }
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
