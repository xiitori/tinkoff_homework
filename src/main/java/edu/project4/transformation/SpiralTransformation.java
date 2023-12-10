package edu.project4.transformation;

import edu.project4.pixel.Point;

public class SpiralTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double radius = StrictMath.sqrt(point.x() * point.x() + point.y() * point.y());
        double theta = StrictMath.atan(point.x() / point.y());

        double newX = (StrictMath.cos(theta) + StrictMath.sin(radius)) / radius;
        double newY = (StrictMath.sin(theta) - StrictMath.cos(radius)) / radius;

        return new Point(newX, newY);
    }
}
