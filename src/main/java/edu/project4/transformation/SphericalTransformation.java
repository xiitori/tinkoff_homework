package edu.project4.transformation;

import edu.project4.pixel.Point;

public class SphericalTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double theta = point.x() * point.x() + point.y() * point.y();

        double newX = point.x() / theta;
        double newY = point.y() / theta;

        return new Point(newX, newY);
    }
}
