package edu.hw6;

import edu.hw6.task1.DiskMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DiskMapTest {

    private static final Path mapFile = Path.of("src/main/resources/hw6/task1/DiskMap.txt");

    @Test
    void constructorTest() throws IOException {
        DiskMap map = new DiskMap();

        var countRecords = Files.readAllLines(mapFile).size();

        assertThat(countRecords).isEqualTo(0);
    }

    @Test
    void sizeTest() {
        DiskMap map = new DiskMap();

        map.put("abc", "def");
        map.put("ghi", "jkl");
        int putSize = map.size();
        map.remove("ghi");
        int removeSize = map.size();

        assertThat(putSize).isEqualTo(2);
        assertThat(removeSize).isEqualTo(1);
    }

    @Test
    void loadFromFileTest() throws IOException {
        Path testFile = Path.of("src/main/resources/hw6/task1/DiskMapTest.txt");

        DiskMap map = new DiskMap(testFile);
        var testFileData = Files.readAllLines(testFile);
        var mapData = Files.readAllLines(mapFile);

        assertThat(testFileData).isEqualTo(mapData);
    }

    @Test
    void saveIntoFileTest() throws IOException {
        Path saveFile = Path.of("src/main/resources/hw6/task1/DiskMapSave.txt");
        Files.delete(saveFile);
        DiskMap map = new DiskMap();
        map.put("abc", "def");
        map.put("ghi", "jkl");

        map.saveIntoFile(saveFile);
        var mapData = Files.readAllLines(mapFile);
        var saveData = Files.readAllLines(saveFile);

        assertThat(mapData).isEqualTo(saveData);
    }

    @Test
    void isEmptyTest() {
        DiskMap map = new DiskMap();

        map.put("abc", "def");
        boolean first = map.isEmpty();
        map.remove("abc");
        boolean second = map.isEmpty();

        assertThat(first).isFalse();
        assertThat(second).isTrue();
    }


    @Test
    void containsKeyTest() {
        DiskMap map = new DiskMap();

        map.put("abc", "def");
        map.put("ghi", "jkl");
        map.put("mno", "pqr");

        assertThat(map.containsKey("ghi")).isTrue();
        assertThat(map.containsKey("abf")).isFalse();
    }

    @Test
    void containsValueTest() {
        DiskMap map = new DiskMap();

        map.put("abc", "def");
        map.put("ghi", "jkl");
        map.put("mno", "pqr");

        assertThat(map.containsValue("jkl")).isTrue();
        assertThat(map.containsValue("abf")).isFalse();
    }

    @Test
    void getTest() {
        DiskMap map = new DiskMap();

        map.put("abc", "def");
        map.put("ghi", "jkl");
        map.put("mno", "pqr");

        String first = map.get("mno");
        String second = map.get("vberbntre");

        assertThat(first).isEqualTo("pqr");
        assertThat(second).isNull();
    }

    @Test
    void putAllTest() {
        Map<String, String> testMap = new TreeMap<>();
        DiskMap map = new DiskMap();
        testMap.put("abc", "def");
        testMap.put("ghi", "jkl");
        testMap.put("mno", "pqr");
        testMap.put("dfgd", "fldk");

        map.putAll(testMap);

        assertThat(map.size()).isEqualTo(4);
        for (var entry : testMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            assertThat(map.containsKey(key)).isTrue();
            assertThat(map.get(key)).isEqualTo(value);
        }
    }

    @Test
    void clearTest() throws IOException {
        Map<String, String> sourceMap = new TreeMap<>();
        sourceMap.put("abc", "def");
        sourceMap.put("ghi", "jkl");
        sourceMap.put("mno", "pqr");
        sourceMap.put("dfgd", "fldk");
        DiskMap map = new DiskMap();
        map.putAll(sourceMap);

        int before = map.size();
        map.clear();
        int after = map.size();
        var data = Files.readAllLines(mapFile);

        assertThat(before).isEqualTo(4);
        assertThat(after).isEqualTo(0);
        assertThat(data.isEmpty()).isTrue();
    }

    @Test
    void keySetTest() {
        Set<String> set = Set.of("abc", "ghi", "mno");
        DiskMap map = new DiskMap();
        map.put("abc", "def");
        map.put("ghi", "jkl");
        map.put("mno", "pqr");

        var result = map.keySet();

        assertThat(set).isEqualTo(result);
    }

    @Test
    void valuesTest() {
        List<String> list = List.of("def", "jkl", "pqr");
        DiskMap map = new DiskMap();
        map.put("abc", "def");
        map.put("ghi", "jkl");
        map.put("mno", "pqr");

        var result = map.values();

        assertThat(list).isEqualTo(result);
    }

    @Test
    void entrySetTest() {
        DiskMap map = new DiskMap();
        map.put("abc", "def");
        map.put("ghi", "jkl");
        map.put("mno", "pqr");

        var result = map.entrySet();

        assertThat(map.size()).isEqualTo(result.size());
        for (var entry : result) {
            String key = entry.getKey();
            String value = entry.getValue();
            assertThat(map.containsKey(key)).isTrue();
            assertThat(map.get(key)).isEqualTo(value);
        }
    }
}
