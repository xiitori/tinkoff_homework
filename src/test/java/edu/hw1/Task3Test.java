package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {
    @Test
    void isNestableTest() {
        assertTrue(Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6}));
        assertTrue(Task3.isNestable(new int[] {3, 1}, new int[] {4, 0}));
        assertFalse(Task3.isNestable(new int[] {9, 9, 8}, new int[] {8, 9}));
        assertFalse(Task3.isNestable(new int[] {1, 2 , 3 ,4}, new int[] {2, 3}));
        assertFalse(Task3.isNestable(new int[10], new int[2]));
    }

    @Test
    void checkExceptionsTest() {
        assertThrows(RuntimeException.class, () -> Task3.isNestable(null, new int[] {1, 2, 3 ,4}));
        assertThrows(RuntimeException.class, () -> Task3.isNestable(null, null));
        assertThrows(RuntimeException.class, () -> Task3.isNestable(new int[] {1, 5, 3 ,-8}, null));
        assertThrows(RuntimeException.class, () -> Task3.isNestable(new int[10], new int[0]));
    }
}
