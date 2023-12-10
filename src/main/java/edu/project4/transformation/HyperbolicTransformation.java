package edu.project4.transformation;

import edu.project4.pixel.Point;

public class HyperbolicTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double sqrt = StrictMath.sqrt(point.x() * point.x() + point.y() * point.y());
        double theta = StrictMath.atan(point.x() / point.y());

        double newX = StrictMath.sin(theta) / sqrt;
        double newY = sqrt * StrictMath.cos(theta);

        return new Point(newX, newY);
    }
}
