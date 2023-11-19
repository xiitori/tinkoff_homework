package edu.hw6;

import edu.hw6.task1.DiskMap;
import java.io.IOException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DiskMapTest {
    @Test
    void putTest() {
        DiskMap map = new DiskMap();

        map.put("key", "value");
        map.put("=", "=");
        map.put("5 + 4 =","9");

        var entrySet = map.entrySet();
        entrySet.forEach(e -> {
            System.out.println(e.getKey() + " " + e.getValue());
        });
    }

    @Test
    void loadWithFileTest() throws IOException {
        Path testFile = Path.of("src/main/java/edu/hw6/task1/DiskMapTest.txt");

        DiskMap map = new DiskMap(testFile);

        assertThat(map.size()).isEqualTo(4);
    }

    @Test
    void saveIntoFileTest() {

    }
}
