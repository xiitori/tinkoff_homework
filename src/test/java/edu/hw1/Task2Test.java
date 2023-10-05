package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    void countDigitsTest() {
        assertEquals(4, Task2.countDigits(4654));
    }

    @Test
    void zeroNumberTest() {
        assertEquals(1, Task2.countDigits(0));
    }

    @Test
    void oneDigitNumberTest() {
        assertEquals(1, Task2.countDigits(5));
    }

    @Test
    void negativeNumbersTest() {
        assertEquals(6, Task2.countDigits(-123456));
    }
}
