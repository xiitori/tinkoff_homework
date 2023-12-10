package edu.project4.transformation;

import edu.project4.pixel.Point;

public class DiskTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double sqrt = StrictMath.sqrt(point.x() * point.x() + point.y() * point.y());
        double theta = StrictMath.atan(point.y() / point.x());

        double newX = theta * StrictMath.sin(sqrt * StrictMath.PI) / StrictMath.PI;
        double newY = theta * StrictMath.cos(sqrt * StrictMath.PI) / StrictMath.PI;

        return new Point(newX, newY);
    }
}
