package edu.hw10.task2.cacher;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static edu.hw10.task2.cacher.CacheParser.parseData;

public class MapCacher implements Cacher {

    private static final MapCacher CACHER = new MapCacher();
    private final Map<String, String> cache = new HashMap<>();

    private MapCacher() {

    }

    public static MapCacher getMapCacher() {
        return CACHER;
    }

    @Override
    public void put(Object object, Method method, Object value) {
        String key = parseData(object, method);
        cache.put(key, value.toString());
    }

    @Override
    public String get(Object object, Method method) {
        String key = parseData(object, method);
        return cache.getOrDefault(key, null);
    }
}
