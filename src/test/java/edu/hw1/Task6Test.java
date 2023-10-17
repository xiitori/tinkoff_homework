package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    void CountKTest() {
        assertEquals(3, Task6.countK(3524));
        assertEquals(5, Task6.countK(6621));
        assertEquals(4, Task6.countK(6554));
        assertEquals(3, Task6.countK(1234));
    }

    @Test
    void check6174Test() {
        assertEquals(0, Task6.countK(6174));
    }

    @Test
    void sameDigitsTest() {
        assertEquals(-1, Task6.countK(6666));
    }

    @Test
    void less1000OrMore9999Test() {
        assertEquals(-1, Task6.countK(10243));
        assertEquals(-1, Task6.countK(45));
        assertEquals(-1, Task6.countK(0000));
    }
}
