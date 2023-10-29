package edu.hw3;

import edu.hw3.task4.DigitConverter;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DigitConverterTest {

    @Test
    void convertToRomanTest() {
        assertThat(DigitConverter.convertToRoman(2)).isEqualTo("II");
        assertThat(DigitConverter.convertToRoman(12)).isEqualTo("XII");
        assertThat(DigitConverter.convertToRoman(16)).isEqualTo("XVI");
        assertThat(DigitConverter.convertToRoman(1986)).isEqualTo("MCMLXXXVI");
        assertThat(DigitConverter.convertToRoman(4324)).isEqualTo("MMMMCCCXXIV");
        assertThat(DigitConverter.convertToRoman(1394)).isEqualTo("MCCCXCIV");
    }
}
