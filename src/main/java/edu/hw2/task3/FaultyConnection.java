package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final int EXCEPTION_FREQUENCY = 3;

    private static int exceptionCounter = 0;

    @Override
    public void execute(String command) {
        if (exceptionCounter != EXCEPTION_FREQUENCY) {
            LOGGER.info("Connection failed!");
            exceptionCounter++;
            throw new ConnectionException();
        } else {
            LOGGER.info("Connection successful!");
            exceptionCounter = 0;
        }
    }

    @Override
    public void close() {

    }
}
