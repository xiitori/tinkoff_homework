package edu.project1.states;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public record Exit() implements State {

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void printState() {
        LOGGER.info("You're give up!");
    }

    @Override
    public boolean isFinalState() {
        return true;
    }
}
