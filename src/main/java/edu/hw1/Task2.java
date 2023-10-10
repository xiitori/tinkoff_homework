package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {

    private static final Logger LOGGER = LogManager.getLogger();

    private Task2() {

    }

    private static final int NUMBER_SYSTEM = 10;

    public static int countDigits(int number) {
        int currentNumber = number;
        int count = 1;
        while (currentNumber / NUMBER_SYSTEM != 0) {
            count++;
            currentNumber = currentNumber / NUMBER_SYSTEM;
        }
        return count;
    }
}
