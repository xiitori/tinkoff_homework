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
    void task1Test() {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        assertThat(res.evaluate()).isEqualTo(37.0);
    }

    @Test
    void constantTest() {
        var constant = new Constant(5.3434);
        assertThat(constant.evaluate()).isEqualTo(5.3434, Offset.offset(0.0001));
    }

    @Test
    void negativeTest() {
        var constant = new Constant(4.524);
        var negative = new Negate(constant);
        assertThat(negative.evaluate()).isEqualTo(-4.524, Offset.offset(0.0001));
    }

    @Test
    void additionTest() {
        var first = new Constant(2.4534);
        var second = new Constant(6.543);
        var negativeSecond = new Negate(second);
        var addition = new Addition(first, negativeSecond);
        assertThat(addition.evaluate()).isEqualTo(-4.0896, Offset.offset(0.00001));
    }

    @Test
    void exponentTest() {
        var constant = new Constant(6.431);
        var exponent = new Exponent(constant, 3);
        assertThat(exponent.evaluate()).isEqualTo(265.9717, Offset.offset(0.0001));
    }

    @Test
    void multiplicationTest() {
        var first = new Constant(3.4534);
        var second = new Constant(9.543);
        var multi = new Multiplication(first, second);
        assertThat(multi.evaluate()).isEqualTo(32.9557, Offset.offset(0.0001));
    }
}
