package edu.hw3;

import edu.hw3.task1.Atbash;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtbashTest {
    @Test
    void helloWorldTest() {
        String result = Atbash.atbash("Hello world!");
        assertThat(result).isEqualTo("Svool dliow!");
    }

    @Test
    void notLettersTest() {
        String result = Atbash.atbash("{}}[][!@#$!");
        assertThat(result).isEqualTo("{}}[][!@#$!");
    }

    @Test
    void russianLettersTest() {
        String result = Atbash.atbash("Привет, мир!");
        assertThat(result).isEqualTo("Привет, мир!");
    }

    @Test

    void emptyStringTest() {
        String result = Atbash.atbash("");
        assertThat(result).isEqualTo("");
    }
}
