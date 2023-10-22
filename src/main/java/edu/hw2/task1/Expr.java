package edu.hw2.task1;

public sealed interface Expr permits Constant, Negate, Addition, Exponent, Multiplication {
    double evaluate();
}
