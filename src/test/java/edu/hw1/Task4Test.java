package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task4Test {
    @Test
    void fixStringTest() {
        assertEquals("214365", Task4.fixString("123456"));
        assertEquals("This is a mixed up string.", Task4.fixString("hTsii  s aimex dpus rtni.g"));
        assertEquals("abcde", Task4.fixString("badce"));
    }

    @Test
    void nullStringTest() {
        assertNull(Task4.fixString(null));
    }

    @Test
    void zeroLengthStringTest() {
        assertEquals("", Task4.fixString(""));
    }
}
