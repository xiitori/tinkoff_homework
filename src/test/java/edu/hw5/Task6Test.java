package edu.hw5;

import edu.hw5.task6.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task6Test {

    static Arguments[] correctStrings() {
        return new Arguments[]{
            Arguments.of("tinkoff", "kof"),
            Arguments.of("mathematics", "math"),
            Arguments.of("university", "vers"),
            Arguments.of("turtle", "rtle")
        };
    }

    static Arguments[] incorrectStrings() {
        return new Arguments[]{
            Arguments.of("tinkoff", "alfa"),
            Arguments.of("mathematics", "animal"),
            Arguments.of("university", "stateuniversity"),
            Arguments.of("turtle", "turtlefish"),
            Arguments.of("biology", "olof")
        };
    }

    @ParameterizedTest
    @DisplayName("Строки, в которых одна содержится в другой")
    @MethodSource("correctStrings")
    void correctStringsTest(String main, String sub) {
        boolean answer = StringUtils.isSubstring(main, sub);

        assertThat(answer).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Строки, в которых одна не содержится в другой")
    @MethodSource("incorrectStrings")
    void incorrectStringsTest(String main, String sub) {
        boolean answer = StringUtils.isSubstring(main, sub);

        assertThat(answer).isFalse();
    }

    @Test
    @DisplayName("Невалидные строки")
    void invalidStrings() {
        boolean answer = StringUtils.isSubstring("", "fdsf");

        assertThat(answer).isFalse();
        assertThrows(IllegalArgumentException.class, () -> {
           StringUtils.isSubstring("notebook", "");
        });
    }
}
