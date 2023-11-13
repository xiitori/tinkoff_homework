package edu.hw5;

import edu.hw5.task5.NumberPlateValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {

    static Arguments[] plateNumbers() {
        return new Arguments[]{
            Arguments.of("Р452ВС136"),
            Arguments.of("Н001УМ77"),
            Arguments.of("Х935КО179")
        };
    }

    static Arguments[] illegalPlateNumbers() {
        return new Arguments[]{
            Arguments.of("Н564ОШ123"),
            Arguments.of("НН123О12"),
            Arguments.of("Х000ХХ777"),
            Arguments.of("Х12ВЕ14"),
            Arguments.of("Х1111ХХ34"),
            Arguments.of("О765СР1")
        };
    }

    @ParameterizedTest
    @DisplayName("Валидные данные")
    @MethodSource("plateNumbers")
    void validatePlateNumberTest(String plateNumber) {
        assertThat(NumberPlateValidator.validate(plateNumber)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Невалидные данные")
    @MethodSource("illegalPlateNumbers")
    void illegalPlateNumbersTest(String plateNumber) {


    }
}
