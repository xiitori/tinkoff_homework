package edu.hw3;

import edu.hw3.task3.Dictionary;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DictionaryTest {
    @Test
    void stringDictionaryTest() {
        Map<String, Integer> map = Dictionary.freqDict(List.of("a", "bb", "a", "bb"));
        assertThat(map.size() == 2).isTrue();
        assertThat(map.get("a")).isEqualTo(2);
        assertThat(map.get("bb")).isEqualTo(2);

        map = Dictionary.freqDict(List.of("this", "and", "that", "and"));
        assertThat(map.size() == 3).isTrue();
        assertThat(map.get("this")).isEqualTo(1);
        assertThat(map.get("and")).isEqualTo(2);
        assertThat(map.get("that")).isEqualTo(1);

        map = Dictionary.freqDict(List.of("код", "код", "код", "bug"));
        assertThat(map.size() == 2).isTrue();
        assertThat(map.get("код")).isEqualTo(3);
        assertThat(map.get("bug")).isEqualTo(1);
    }

    @Test
    void integerDictionaryTest() {
        Map<Integer, Integer> map = Dictionary.freqDict(List.of(1, 1, 2, 2));
        assertThat(map.size() == 2).isTrue();
        assertThat(map.get(1)).isEqualTo(2);
        assertThat(map.get(2)).isEqualTo(2);
    }

    @Test
    void emptyListTest() {
        Map<String ,Integer> map = Dictionary.freqDict(List.of());
        assertThat(map.isEmpty()).isTrue();
    }

    @Test
    void nullTest() {
        assertThrows(NullPointerException.class, () -> {
            Dictionary.freqDict(null);
        });
    }
}
