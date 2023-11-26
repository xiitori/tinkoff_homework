package edu.hw7.task2;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.assertj.core.api.Assertions.assertThat;

public class FactorialCalculatorTest {
    @Test
    void calculateFactorialTest() {
        int n = 10000;

        BigInteger factorial = FactorialCalculator.factorial(n);

        System.out.println(factorial);
    }
}
