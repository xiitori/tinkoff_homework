package edu.hw2.task1;

public record Exponent(Expr value, int index) implements Expr {
    @Override
    public double evaluate() {
        return Math.pow(value.evaluate(), index);
    }
}
