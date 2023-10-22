package edu.hw2.task2;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle setWidth(int width) {
        if (width == height) {
            return new Square(width);
        } else {
            return new Rectangle(width, height);
        }
    }

    public Rectangle setHeight(int height) {
        if (height == width) {
            return new Square(height);
        } else {
            return new Rectangle(width, height);
        }
    }

    public double area() {
        return width * height;
    }
}
