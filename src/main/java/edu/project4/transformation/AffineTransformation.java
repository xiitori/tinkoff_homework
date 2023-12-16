package edu.project4.transformation;

import edu.project4.pixel.Pixel.Color;
import java.util.concurrent.ThreadLocalRandom;

public class AffineTransformation extends LinearTransformation {

    private static final double MIN_BORDER = -1.5;

    private static final double MAX_BORDER = 1.5;

    private static final int COLOR_BORDER = 256;

    private final Color color;

    public Color getColor() {
        return color;
    }

    public AffineTransformation(double a, double b, double c, double d, double e, double f, Color color) {
        super(a, b, c, d, e, f);
        this.color = color;
    }

    public static AffineTransformation getRandomAffine() {
        var random = ThreadLocalRandom.current();

        while (true) {
            double a = random.nextDouble(MIN_BORDER, MAX_BORDER);
            double b = random.nextDouble(MIN_BORDER, MAX_BORDER);
            double c = random.nextDouble(MIN_BORDER, MAX_BORDER);
            double d = random.nextDouble(MIN_BORDER, MAX_BORDER);
            double e = random.nextDouble(MIN_BORDER, MAX_BORDER);
            double f = random.nextDouble(MIN_BORDER, MAX_BORDER);

            if ((a * a + d * d < 1) && (b * b + e * e < 1)
                && (a * a + b * b + d * d + e * e < 1 + (a * e - b * d) * (a * e - b * d))) {
                int red = random.nextInt(COLOR_BORDER);
                int green = random.nextInt(COLOR_BORDER);
                int blue = random.nextInt(COLOR_BORDER);
                return new AffineTransformation(a, b, c, d, e, f, new Color(red, green, blue));
            }
        }
    }
}
