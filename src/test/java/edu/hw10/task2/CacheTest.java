package edu.hw10.task2;

import edu.hw10.task1.RandomObjectGenerator;
import edu.hw10.task2.cacher.FileCacher;
import edu.hw10.task2.cacher.MapCacher;
import edu.hw10.task2.proxy.CacheProxy;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CacheTest {

    @Test
    void fileCacherTest() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException,
        IOException {
        RandomObjectGenerator generator = new RandomObjectGenerator();
        Trainee trainee = (Trainee) generator.nextObject(Trainee.class);
        Nameable nameable = CacheProxy.create(trainee, Nameable.class);

        nameable.name();
        nameable.name();

        Field field = FileCacher.getFileCacher().getClass().getDeclaredField("path");
        field.setAccessible(true);
        Path path = (Path) field.get(FileCacher.getFileCacher());
        assertTrue(Files.readAllLines(path).contains(Trainee.class.getSimpleName() + ", name:" + trainee.name()));
    }

    @Test
    void mapCacherTest()
        throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        RandomObjectGenerator generator = new RandomObjectGenerator();
        Trainee trainee = (Trainee) generator.nextObject(Trainee.class);
        Student student = CacheProxy.create(trainee, Student.class);

        student.getStudentId();
        student.getStudentId();

        Field field = MapCacher.getMapCacher().getClass().getDeclaredField("cache");
        field.setAccessible(true);
        Map<String, String> map = (HashMap<String, String>) field.get(MapCacher.getMapCacher());
        assertTrue(map.containsKey(Trainee.class.getSimpleName() + ", getStudentId"));
    }
}
