package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    void isPalindromeDescendantTest() {
        assertTrue(Task5.isPalindromeDescendant(11211230));
        assertTrue(Task5.isPalindromeDescendant(13001120));
        assertTrue(Task5.isPalindromeDescendant(23336014));
        assertTrue(Task5.isPalindromeDescendant(11));
    }

    @Test
    void oneDigitTest() {
        assertFalse(Task5.isPalindromeDescendant(1));
    }

    @Test
    void oddCountDigitsTest() {
        assertTrue(Task5.isPalindromeDescendant(12321));
        assertFalse(Task5.isPalindromeDescendant(13321));
    }
}
