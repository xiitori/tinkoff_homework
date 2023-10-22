package edu.project1.questions;

import edu.project1.exceptions.IncorrectQuestionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionBox {

    private static List<Question> questions = new ArrayList<>(Arrays.asList(new Question("compiler"),
            new Question("integer"), new Question("tinkoff"), new Question("math"),
            new Question("algorithm")));

    private static final Randomizer RANDOMIZER = new Randomizer();

    private QuestionBox() {

    }

    public static Question getRandom() {
        int randInt = RANDOMIZER.getRandom(0, questions.size());
        return questions.get(randInt);
    }

    public static List<Question> setQuestions(List<Question> list) throws IncorrectQuestionException {
        var result = questions;
        questions = list;
        return result;
    }
}
