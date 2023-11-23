package edu.project1.states;

import edu.project1.questions.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public record CorrectGuess(Question question) implements State {

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void printState() {
        LOGGER.info("> Hit!");
        LOGGER.info(">");
        LOGGER.info("> The word: " + question.getGuessedLetters());
        LOGGER.info(">");
    }

    @Override
    public boolean isFinalState() {
        return false;
    }
}
