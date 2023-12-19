package edu.hw7.task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class MonteCarloGeneratorTest {

    private static final int COUNT_TESTS = 10;
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    void speedTest() {
        long timeOneThread = 0;
        for (int i = 0; i < COUNT_TESTS; i++) {
            long time = System.nanoTime();
            MonteCarloGenerator.getPi(100_000_000);
            time = System.nanoTime() - time;
            timeOneThread += time;
        }
        timeOneThread /= COUNT_TESTS * Math.pow(10, 6);
        LOGGER.info("One Thread - " + timeOneThread + "ms");

        long timeTwoThreads = 0;
        for (int i = 0; i < COUNT_TESTS; i++) {
            long time = System.nanoTime();
            MonteCarloGenerator.getPiParallel(100_000_000, 2);
            time = System.nanoTime() - time;
            timeTwoThreads += time;
        }
        timeTwoThreads /= COUNT_TESTS * Math.pow(10, 6);
        LOGGER.info("Two Threads - " + timeTwoThreads + "ms");

        long timeFourThreads = 0;
        for (int i = 0; i < COUNT_TESTS; i++) {
            long time = System.nanoTime();
            MonteCarloGenerator.getPiParallel(100_000_000, 4);
            time = System.nanoTime() - time;
            timeFourThreads += time;
        }
        timeFourThreads /= COUNT_TESTS * Math.pow(10, 6);
        LOGGER.info("Four Threads - " + timeFourThreads + "ms");

        long timeEightThreads = 0;
        for (int i = 0; i < COUNT_TESTS; i++) {
            long time = System.nanoTime();
            MonteCarloGenerator.getPiParallel(100_000_000, 8);
            time = System.nanoTime() - time;
            timeEightThreads += time;
        }
        timeEightThreads /= COUNT_TESTS * Math.pow(10, 6);
        LOGGER.info("Eight Threads - " + timeEightThreads + "ms");
    }

    @Test
    void accuracyTest() {
        double accuracy10Million = 0;
        for (int i = 0; i < COUNT_TESTS; i++) {
            accuracy10Million +=
                Math.abs(Math.PI - MonteCarloGenerator.getPiParallel(10_000_000, 8));
        }
        accuracy10Million /= COUNT_TESTS;
        LOGGER.info("10 Million average accuracy - " + accuracy10Million);

        double accuracy100Million = 0;
        for (int i = 0; i < COUNT_TESTS; i++) {
            accuracy100Million +=
                Math.abs(Math.PI - MonteCarloGenerator.getPiParallel(100_000_000, 8));
        }
        accuracy100Million /= COUNT_TESTS;
        LOGGER.info("100 Million average accuracy - " + accuracy100Million);

        double accuracyBillion = 0;
        for (int i = 0; i < COUNT_TESTS; i++) {
            accuracyBillion +=
                Math.abs(Math.PI - MonteCarloGenerator.getPiParallel(1_000_000_000, 8));
        }
        accuracyBillion /= COUNT_TESTS;
        LOGGER.info("Billion average accuracy - " + accuracyBillion);
    }
}
