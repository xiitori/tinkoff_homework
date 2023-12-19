package edu.hw7.task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class IncrementerTest {
    @Test
    void incrementTest() {
        Incrementer incrementer = new Incrementer(0);

        var first = incrementer.incrementByThreads(1000, 10);
        var second = incrementer.incrementByThreads(23000, 5);

        assertThat(first).isEqualTo(10000);
        assertThat(second).isEqualTo(125000);
    }
}
