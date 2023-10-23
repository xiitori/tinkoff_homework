package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AtbashTest {
    @Test
    void atbashTest() {
        String result = Atbash.atbash("Hello World!");
        assertThat(result).isEqualTo("Svool dliow!");
    }
}
