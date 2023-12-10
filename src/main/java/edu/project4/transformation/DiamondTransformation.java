package edu.project4.transformation;

import edu.project4.pixel.Point;

public class DiamondTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double sqrt = StrictMath.sqrt(point.x() * point.x() + point.y() * point.y());
        double theta = StrictMath.atan(point.x() / point.y());

        double newX = StrictMath.sin(theta) * StrictMath.cos(sqrt);
        double newY = StrictMath.cos(theta) * StrictMath.sin(sqrt);

        return new Point(newX, newY);
    }
}
