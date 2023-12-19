package edu.hw5;

import edu.hw5.task1.ParseDateException;
import edu.hw5.task1.TimeUtils;
import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    @Test
    @DisplayName("Тест валидных данных")
    void getTimeSessionTest() {
        var testDuration = Duration.parse("PT3H30M");

        var result = TimeUtils.getTimeSession(List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20",
            "2022-05-24, 10:54 - 2022-05-24, 14:04"
        ));

        assertThat(result).isEqualTo(testDuration.toString());
    }

    @Test
    @DisplayName("Отрицательный интервал")
    void negativeDurationTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            TimeUtils.getTimeSession(List.of("2022-03-12, 23:50 - 2022-03-12, 23:40"));
        });
    }

    @Test
    @DisplayName("Некорректный формат даты")
    void illegalDateFormatTest() {
        assertThrows(ParseDateException.class, () -> {
            TimeUtils.getTimeSession(List.of("2003-03-05, 3:45 - 2023-03-06, 05:33"));
        });

        assertThrows(ParseDateException.class, () -> {
            TimeUtils.getTimeSession(List.of("2003-03-05, 03:45 - 203-03-06, 05:33"));
        });

        assertThrows(ParseDateException.class, () -> {
            TimeUtils.getTimeSession(List.of("2003-03-05 03:45 - 2023-03-06, 05:3"));
        });
    }
}
