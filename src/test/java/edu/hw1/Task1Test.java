package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    void minutesToSecondsTest() {
        int time = Task1.minutesToSeconds("13:56");
        assertEquals(13 * 60 + 56, time);
    }

    @Test
    void checkIncorrectString() {
        assertEquals(-1, Task1.minutesToSeconds("fviobfeduif"));
    }

    @Test
    void checkNumbersOver60() {
        assertEquals(-1, Task1.minutesToSeconds("00:61"));
    }

    @Test
    void checkNegativeNumbers() {
        assertEquals(-1, Task1.minutesToSeconds("-7:-10"));
    }

    @Test
    void checkBigNumbers() {
        assertEquals(4564225 * 60 + 1, Task1.minutesToSeconds("4564225:1"));
    }
}
