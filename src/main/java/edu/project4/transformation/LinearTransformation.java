package edu.project4.transformation;

import edu.project4.pixel.Point;

public class LinearTransformation implements Transformation {

    protected double a;

    protected double b;

    protected double c;

    protected double d;

    protected double e;

    protected double f;

    public LinearTransformation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    @Override
    public Point apply(Point point) {
        double newX = a * point.x() + b * point.y() + c;
        double newY = d * point.x() + e * point.y() + f;

        return new Point(newX, newY);
    }
}
