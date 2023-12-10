package edu.project4.transformation;

import edu.project4.pixel.Point;

public class HorsehoeTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double sqrt = StrictMath.sqrt(point.x() * point.x() + point.y() * point.y());

        double newX = (point.x() - point.y()) * (point.x() + point.y()) / sqrt;
        double newY = 2 * point.x() * point.y() / sqrt;

        return new Point(newX, newY);
    }
}
