package edu.hw5;

import edu.hw5.task7.BinaryStringValidator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    void test() {
        assertThat(BinaryStringValidator.isFirstAndLastSymbolEquals("0100")).isTrue();
        assertThat(BinaryStringValidator.isLengthNoLess1AndNoMore3("101")).isTrue();
        assertThat(BinaryStringValidator.isLengthNoLess3AndThirdSymbolIsZero("1101")).isTrue();
    }
}
