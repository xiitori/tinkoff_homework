package edu.project4.render;

import edu.project4.image.FractalImage;
import edu.project4.image.Resolution;
import edu.project4.pixel.Pixel;
import edu.project4.pixel.Point;
import edu.project4.transformation.AffineTransformation;
import edu.project4.transformation.SymmetryTransformation;
import edu.project4.transformation.Transformation;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SingleRenderer implements Renderer {

    private static final int PRE_ITERATIONS = 20;

    @Override
    public FractalImage render(
        Resolution resolution,
        int symmetry,
        int samples,
        int iterations,
        List<AffineTransformation> affines,
        List<Transformation> transformations
    ) {
        var random = ThreadLocalRandom.current();
        HashMap<Point, Pixel> pixels = new HashMap<>();
        int width = resolution.width();
        int height = resolution.height();

        double newX;
        double newY;

        for (int n = 0; n < samples; n++) {
            newX = random.nextDouble(X_MIN, X_MAX);
            newY = random.nextDouble(Y_MIN, Y_MAX);
            for (int i = -PRE_ITERATIONS; i < iterations; i++) {
                var affine = affines.get(random.nextInt(affines.size()));
                var transformation = transformations.get(random.nextInt(transformations.size()));

                Point oldPoint = new Point(newX, newY);
                Point newPoint = transformation.apply(affine.apply(oldPoint));

                double theta = 0.0;
                for (int s = 0; s < symmetry; theta += Math.PI * 2 / symmetry, s++) {
                    newPoint = new SymmetryTransformation().apply(newPoint, theta);

                    newX = newPoint.x();
                    newY = newPoint.y();

                    if (i >= 0 && newX >= X_MIN && newX <= X_MAX && newY >= Y_MIN && newY <= Y_MAX) {
                        int x = (int) (width - ((X_MAX - newX) / (X_MAX - X_MIN) * width));
                        int y = (int) (height - ((Y_MAX - newY) / (Y_MAX - Y_MIN) * height));

                        if (x < width && y < height) {
                            Point point = new Point(x, y);
                            if (!pixels.containsKey(point)) {
                                pixels.put(point, new Pixel(affine.getColor(), 1));
                            } else {
                                Pixel oldPixel = pixels.get(point);
                                Pixel.Color newColor = updateColor(oldPixel.color(), affine.getColor());
                                pixels.put(point, new Pixel(newColor, oldPixel.hitCount() + 1));
                            }
                        }
                    }
                }
            }
        }

        return new FractalImage(pixels, resolution);
    }
}
