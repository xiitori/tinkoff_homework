package edu.hw10.task2.cacher;

import java.lang.reflect.Method;

public class CacheParser {
    private CacheParser() {

    }

    static String parseData(Object object, Method method) {
        return object.getClass().getSimpleName() + ", " + method.getName();
    }
}
