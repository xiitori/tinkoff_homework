package edu.project1.states;

import edu.project1.questions.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public record WrongGuess(int attempt, int maxAttempts, Question question) implements State {

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void printState() {
        LOGGER.info(String.format("> Missed, mistake %d out of %d", attempt, maxAttempts));
        LOGGER.info(">");
        LOGGER.info("> The word: " + question.getGuessedLetters());
        LOGGER.info(">");
    }

    @Override
    public boolean isFinalState() {
        return false;
    }
}
