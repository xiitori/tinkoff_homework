package edu.hw5;

import edu.hw5.task5.NumberPlateValidator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    void test() {
        assertThat(NumberPlateValidator.validate("А001ВЕ777")).isTrue();
    }
}
