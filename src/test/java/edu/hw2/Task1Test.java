package edu.hw2;

import edu.hw2.task1.Addition;
import edu.hw2.task1.Constant;
import edu.hw2.task1.Exponent;
import edu.hw2.task1.Multiplication;
import edu.hw2.task1.Negate;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    void constantTest() {
        var constant = new Constant(5.3434);

        double result = constant.evaluate();

        assertThat(result).isEqualTo(5.3434, Offset.offset(0.0001));
    }

    @Test
    void negativeTest() {
        var constant = new Constant(4.524);

        var negative = new Negate(constant);
        double result = negative.evaluate();

        assertThat(result).isEqualTo(-4.524, Offset.offset(0.0001));
    }

    @Test
    void additionTest() {
        var first = new Constant(2.4534);
        var second = new Constant(6.543);

        var negativeSecond = new Negate(second);
        var addition = new Addition(first, negativeSecond);
        double result = addition.evaluate();

        assertThat(result).isEqualTo(-4.0896, Offset.offset(0.00001));
    }

    @Test
    void exponentTest() {
        var constant = new Constant(6.431);

        var exponent = new Exponent(constant, 3);
        double result = exponent.evaluate();

        assertThat(result).isEqualTo(265.9717, Offset.offset(0.0001));
    }

    @Test
    void multiplicationTest() {
        var first = new Constant(3.4534);
        var second = new Constant(9.543);

        var multi = new Multiplication(first, second);
        double result = multi.evaluate();

        assertThat(result).isEqualTo(32.9557, Offset.offset(0.0001));
    }
}
