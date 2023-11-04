package edu.hw2;

import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle(20, 10)),
            Arguments.of(new Square(15))
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect = rect.setWidth(10);
        rect = rect.setHeight(15);

        double area = rect.area();

        assertThat(area).isEqualTo(150.0);
    }
}
