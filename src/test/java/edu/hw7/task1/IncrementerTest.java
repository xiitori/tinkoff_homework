package edu.hw7.task1;

import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicInteger;
import static org.assertj.core.api.Assertions.assertThat;

public class IncrementerTest {
    @Test
    void incrementTest() {
        Incrementer incrementer = new Incrementer(new AtomicInteger(0));

        var result = incrementer.increment100_000();

        assertThat(result.get()).isEqualTo(100000);
    }
}
