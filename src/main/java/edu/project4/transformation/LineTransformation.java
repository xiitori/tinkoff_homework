package edu.project4.transformation;

import edu.project4.pixel.Point;

public class LineTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        return point;
    }
}
