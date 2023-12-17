package edu.hw10.task2.cacher;

import java.lang.reflect.Method;

public interface Cacher {

    void put(Object object, Method method, Object value);

    String get(Object object, Method method);

    static Cacher getCacherByPersists(boolean persists) {
        if (persists) {
            return FileCacher.getFileCacher();
        } else {
            return MapCacher.getMapCacher();
        }
    }
}
