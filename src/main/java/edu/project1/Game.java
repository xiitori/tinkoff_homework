package edu.project1;

import edu.project1.exceptions.IncorrectQuestionException;
import edu.project1.questions.Question;
import edu.project1.questions.QuestionBox;
import edu.project1.states.CorrectGuess;
import edu.project1.states.Defeat;
import edu.project1.states.Exit;
import edu.project1.states.IncorrectInput;
import edu.project1.states.State;
import edu.project1.states.Victory;
import edu.project1.states.WrongGuess;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {

    private final static Logger LOGGER = LogManager.getLogger();

    private static final int MAX_ATTEMPTS = 5;

    private final Pattern validateRegex = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);

    private final Scanner userInput = new Scanner(System.in);

    private Question guessedQuestion;

    private int attempt = 0;

    public Game() {
    }

    public List<State> run() {
        attempt = 0;
        guessedQuestion = QuestionBox.getRandom();
        if (!guessedQuestion.isValid()) {
            throw new IncorrectQuestionException();
        }
        String letter;
        List<State> stateList = new LinkedList<>();
        while (true) {
            LOGGER.info("> Guess a letter:");
            LOGGER.info("<");
            letter = userInput.nextLine();

            State currentState = getGameState(letter);
            stateList.add(currentState);
            currentState.printState();
            if (currentState.isFinalState()) {
                guessedQuestion.restartQuestion();
                return stateList;
            }
        }
    }

    @SuppressWarnings("ReturnCount")
    private State getGameState(String letter) {
        if (letter.equals("exit")) {
            return new Exit();
        }
        if (letter.length() != 1 || !validateRegex.matcher(letter).find()) {
            return new IncorrectInput();
        }
        if (guessedQuestion.checkLetter(letter)) {
            if (guessedQuestion.isGuessed()) {
                return new Victory();
            } else {
                return new CorrectGuess(guessedQuestion);
            }
        } else {
            attempt++;

            if (attempt == MAX_ATTEMPTS) {
                return new Defeat();
            } else {
                return new WrongGuess(attempt, MAX_ATTEMPTS, guessedQuestion);
            }
        }
    }
}
