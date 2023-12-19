package edu.hw7.task2;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {
    @Test
    void calculateFactorialTest() {
        int n = 5;

        var answer = FactorialCalculator.factorial(n);

        assertThat(answer.intValue()).isEqualTo(120);
    }

    @Test
    void zeroTest() {
        int n = 0;

        var answer = FactorialCalculator.factorial(n);

        assertThat(answer.intValue()).isEqualTo(1);
    }

    @Test
    void bigNumberTest() {
        int n = 100;

        var answer = FactorialCalculator.factorial(n);

        assertThat(answer.toString()).isEqualTo(
            "933262154439441526816992388562667" +
                "00490715968264381621468592963895217599" +
                "99322991560894146397615651828625369792" +
                "08272237582511852109168640000000000000" +
                "00000000000");
    }

    @Test
    void negativeNumberTest() {
        int n = -5;

        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(n);
        });
    }
}
