package edu.project4.pixel;

public record Pixel(Color color, int hitCount) {

    public record Color(int r, int g, int b) {
        public static final Color BLACK = new Color(0, 0, 0);
    }
}
