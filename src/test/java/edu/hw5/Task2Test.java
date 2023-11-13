package edu.hw5;

import edu.hw5.task2.Friday13Getter;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {

    @Test
    @DisplayName("тест получения пятниц 13-го 2023 года")
    void test() {
        Friday13Getter getter = new Friday13Getter(2023);
        var checkList = List.of("2023-01-13", "2023-10-13");

        var result = getter.getFridays13();

        for (int i = 0; i < result.size(); i++) {
            String date = result.get(i).toString();
            String expectedDate = checkList.get(i);
            assertThat(date).isEqualTo(expectedDate);
        }
    }

    @Test
    @DisplayName("тест получения пятниц 13-го 1925 года")
    void year1925Test() {
        Friday13Getter getter = new Friday13Getter(1925);
        var checkList = List.of("1925-02-13", "1925-03-13", "1925-11-13");

        var result = getter.getFridays13();

        for (int i = 0; i < result.size(); i++) {
            String date = result.get(i).toString();
            String expectedDate = checkList.get(i);
            assertThat(date).isEqualTo(expectedDate);
        }
    }

    @Test
    @DisplayName("тест невалидного года")
    void invalidYearTest() {
        assertThrows(IllegalArgumentException.class, () -> {
           Friday13Getter friday13Getter = new Friday13Getter(-1023);
        });
    }
}
