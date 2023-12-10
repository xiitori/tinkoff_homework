package edu.project4.transformation;

import edu.project4.pixel.Point;

public class HeartTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double sqrt = StrictMath.sqrt(point.x() * point.x() + point.y() * point.y());
        double theta = StrictMath.atan(point.y() / point.x());

        double newX = sqrt * StrictMath.sin(sqrt * theta);
        double newY = -sqrt * StrictMath.cos(sqrt * theta);

        return new Point(newX, newY);
    }
}
