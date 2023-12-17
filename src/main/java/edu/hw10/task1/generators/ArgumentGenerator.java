package edu.hw10.task1.generators;

import java.lang.annotation.Annotation;

public interface ArgumentGenerator {
    Object generate(Annotation[] annotations);

    static ArgumentGenerator getGenerator(Class<?> type) {
        if (type == String.class) {
            return new StringGenerator();
        } else if (type == int.class) {
            return new IntGenerator();
        } else if (type == boolean.class) {
            return new BooleanGenerator();
        }

        throw new UnsupportedTypeException("There is no generator for " + type.getSimpleName() + " class");
    }
}
