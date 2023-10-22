package edu.project1;

import edu.project1.exceptions.IncorrectQuestionException;
import edu.project1.questions.QuestionBox;
import edu.project1.questions.Question;
import edu.project1.states.Defeat;
import edu.project1.states.Exit;
import edu.project1.states.IncorrectInput;
import edu.project1.states.State;
import edu.project1.states.Victory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HangmanTest {

    public static final Logger LOGGER = LogManager.getLogger();

    @Test
    void incorrectQuestionTest() {
        Game game = new Game();
        List<Question> defaultList = QuestionBox.setQuestions(new ArrayList<>(List.of(new Question(""))));
        assertThrows(IncorrectQuestionException.class, game::run);
        QuestionBox.setQuestions(defaultList);
    }

    @Test
    void checkDefeatTest() {
        System.setIn(new ByteArrayInputStream("z\nz\nz\nz\nz".getBytes()));
        Game game = new Game();
        List<State> stateList = game.run();
        assertThat(stateList.get(stateList.size() - 1)).isInstanceOf(Defeat.class);
    }

    @Test
    void checkWinTest() {
        System.setIn(new ByteArrayInputStream("q\nw\ne\nr\nt\ny".getBytes()));
        Game game = new Game();
        List<Question> defaultList = QuestionBox.setQuestions(new ArrayList<>(List.of(new Question("qwerty"))));
        List<State> stateList = game.run();
        assertThat(stateList.get(stateList.size() - 1)).isInstanceOf(Victory.class);
        QuestionBox.setQuestions(defaultList);
    }

    @Test
    void checkIncorrectInput() {
        System.setIn(new ByteArrayInputStream("gf\n[\nexit".getBytes()));
        Game game = new Game();
        List<State> stateList = game.run();
        assertThat(stateList.get(0)).isInstanceOf(IncorrectInput.class);
        assertThat(stateList.get(1)).isInstanceOf(IncorrectInput.class);
        assertThat(stateList.get(2)).isInstanceOf(Exit.class);
    }


}
