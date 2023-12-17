package edu.hw10.task2.cacher;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.hw10.task2.cacher.CacheParser.parseData;

public class FileCacher implements Cacher {

    private final Path path;

    private static final FileCacher CACHER = new FileCacher();

    private FileCacher() {
        try {
            path = Files.createTempFile("cacherTemp", "txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static FileCacher getFileCacher() {
        return CACHER;
    }

    @Override
    public void put(Object object, Method method, Object value) {
        String key = parseData(object, method);
        try {
            Files.writeString(path, key + ":" + value.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String get(Object object, Method method) {
        String key = parseData(object, method);
        try {
            for (String cachedString : Files.readAllLines(path)) {
                String signature = cachedString.substring(0, cachedString.indexOf(":"));
                if (signature.equals(key)) {
                    return cachedString.substring(cachedString.indexOf(":") + 1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
