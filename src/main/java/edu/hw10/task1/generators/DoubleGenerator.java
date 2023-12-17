package edu.hw10.task1.generators;

import edu.hw10.task1.annotations.Max;
import edu.hw10.task1.annotations.Min;
import java.lang.annotation.Annotation;
import java.util.concurrent.ThreadLocalRandom;

public class DoubleGenerator implements ArgumentGenerator {
    @Override
    public Object generate(Annotation[] annotations) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (var annotation : annotations) {
            if (annotation.annotationType() == Max.class) {
                min = ((Min) annotation).value();
            } else if (annotation.annotationType() == Min.class) {
                max = ((Max) annotation).value();
            }
        }
        return ThreadLocalRandom.current().doubles(min, max);
    }
}
