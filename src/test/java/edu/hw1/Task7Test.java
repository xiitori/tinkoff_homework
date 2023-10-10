package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @Test
    void rotateTest() {
        assertEquals(1, Task7.rotateLeft(16, 1));
        assertEquals(4, Task7.rotateRight(8, 1));
        assertEquals(6, Task7.rotateLeft(17,2));
        assertEquals(1, Task7.rotateLeft(8, 5));
    }

    @Test
    void zeroTest() {
        assertEquals(0, Task7.rotateLeft(0, 1));
        assertEquals(0, Task7.rotateRight(0, 1));
    }

    @Test
    void minusTest() {
        assertEquals(-1, Task7.rotateLeft(-7, 1));
        assertEquals(-1, Task7.rotateRight(-7, 1));
    }
}
