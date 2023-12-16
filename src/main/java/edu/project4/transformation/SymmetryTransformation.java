package edu.project4.transformation;

import edu.project4.pixel.Point;

public class SymmetryTransformation {
    public Point apply(Point point, double theta) {
        double xRot = point.x() * StrictMath.cos(theta) - point.y() * StrictMath.sin(theta);
        double yRot = point.x() * StrictMath.sin(theta) + point.y() * StrictMath.cos(theta);

        return new Point(xRot, yRot);
    }
}
