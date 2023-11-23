package edu.project1.states;

public sealed interface State permits Victory, Defeat, CorrectGuess, WrongGuess, IncorrectInput, Exit {
    void printState();

    boolean isFinalState();
}
