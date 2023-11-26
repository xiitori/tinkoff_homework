package edu.hw7.task4;

import org.junit.jupiter.api.Test;

public class MonteCarloGeneratorTest {
    @Test
    void test() {
        System.out.println(MonteCarloGenerator.getPiParallel(1_000_000_000, 16));
    }
}
