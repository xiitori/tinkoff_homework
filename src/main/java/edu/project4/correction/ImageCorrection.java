package edu.project4.correction;

import edu.project4.image.FractalImage;
import edu.project4.pixel.Pixel;
import edu.project4.pixel.Pixel.Color;
import edu.project4.pixel.Point;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ImageCorrection implements ImageProcessor {

    private static final double GAMMA = 2.2;

    public FractalImage process(FractalImage image) {
        double max = 0.0;
        var pixels = image.pixels();

        LinkedList<CorrectionPixel> correction = new LinkedList<>();
        for (var entry : pixels.entrySet()) {
            var point = entry.getKey();
            var pixel = entry.getValue();
            double normal = StrictMath.log10(pixel.hitCount());
            if (normal > max) {
                max = normal;
            }

            correction.add(new CorrectionPixel(pixel, point, normal));
        }

        double finalMax = max;
        var newPixels = correction.stream().collect(Collectors.toMap(c -> c.point, c -> {
            c.normal = c.normal / finalMax;
            Color oldColor = c.pixel.color();
            int red = (int) (oldColor.r() * StrictMath.pow(c.normal, (1.0 / GAMMA)));
            int green = (int) (oldColor.g() * StrictMath.pow(c.normal, (1.0 / GAMMA)));
            int blue = (int) (oldColor.b() * StrictMath.pow(c.normal, (1.0 / GAMMA)));
            return new Pixel(new Color(red, green, blue), c.pixel.hitCount());
        }));

        return new FractalImage(newPixels, image.resolution());
    }

    private static class CorrectionPixel {
        private final Pixel pixel;

        private final Point point;

        private double normal;

        private CorrectionPixel(Pixel pixel, Point point, double normal) {
            this.pixel = pixel;
            this.point = point;
            this.normal = normal;
        }
    }
}
