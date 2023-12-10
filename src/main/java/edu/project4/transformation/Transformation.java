package edu.project4.transformation;

import edu.project4.pixel.Point;
import java.util.function.Function;

@FunctionalInterface
public interface Transformation extends Function<Point, Point> {
    @Override
    Point apply(Point point);
}
