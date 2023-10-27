package edu.hw3;

import edu.hw3.task7.NullComparator;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.assertThat;

public class NullComparatorTest {
    @Test
    void comparatorTest() {
        TreeMap<String, String> map = new TreeMap<>(NullComparator.getComparator());
        map.put(null, "string");

        assertThat(map.containsKey(null)).isTrue();
    }
}
