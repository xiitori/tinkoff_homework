package edu.project1.questions;

public class Question {
    private final String word;
    private boolean[] guessedLetters;

    public Question(String word) {
        this.word = word;
        guessedLetters = new boolean[word.length()];
    }

    public boolean checkLetter(String letter) {
        if (word.contains(letter)) {
            for (int i = 0; i < word.length(); i++) {
                if (String.valueOf(word.charAt(i)).equals(letter)) {
                    guessedLetters[i] = true;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public String getGuessedLetters() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < guessedLetters.length; i++) {
            if (guessedLetters[i]) {
                result.append(word.charAt(i));
            } else {
                result.append("*");
            }
        }
        return result.toString();
    }

    public boolean isGuessed() {
        for (boolean letter : guessedLetters) {
            if (!letter) {
                return false;
            }
        }
        return true;
    }

    public void restartQuestion() {
        guessedLetters = new boolean[word.length()];
    }

    public boolean isValid() {
        return word != null && !word.isEmpty();
    }
}
