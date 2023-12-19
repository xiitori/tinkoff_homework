package edu.hw5;

import edu.hw5.task2.Friday13Getter;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {

    static Arguments[] arguments() {
        return new Arguments[] {
            Arguments.of(
                LocalDate.of(1925, 1, 6),
                LocalDate.of(1925, 2, 13)
            ),
            Arguments.of(
                LocalDate.of(1925, 7, 14),
                LocalDate.of(1925, 11, 13)
            ),
            Arguments.of(
                LocalDate.of(2023, 7, 24),
                LocalDate.of(2023, 10, 13)
            )
        };
    }

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

    @ParameterizedTest
    @DisplayName("тест функции получения следущей пятницы 13-го")
    @MethodSource("arguments")
    void getNextFriday13Test(LocalDate date, LocalDate nextDate) {
        var result = Friday13Getter.getNextFriday13(date);

        assertThat(result).isEqualTo(nextDate);
    }

    @Test
    @DisplayName("получение следующей пятницы 13-го, если дата уже пятница 13-го")
    void dateIsAlreadyFriday13Test() {
        LocalDate date = LocalDate.of(1925, 2, 13);
        var result = Friday13Getter.getNextFriday13(date);

        assertThat(result).isEqualTo(LocalDate.of(1925, 3, 13));
    }
}
