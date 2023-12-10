package edu.project4.render;

import edu.project4.image.FractalImage;
import edu.project4.image.Resolution;
import edu.project4.pixel.Pixel;
import edu.project4.pixel.Pixel.Color;
import edu.project4.transformation.AffineTransformation;
import edu.project4.transformation.Transformation;
import java.util.List;

public interface Renderer {
    FractalImage render(
            double XMin,
            double XMax,
            double YMin,
            double YMax,
            Resolution resolution,
            int symmetry,
            int samples,
            int iterations,
            List<AffineTransformation> affines,
            List<Transformation> transformations);

    default Pixel.Color updateColor(Color old, Color affine) {
        int newRed = ((old.r() + affine.r()) / 2);
        int newGreen = ((old.g() + affine.g()) / 2);
        int newBlue = ((old.b() + affine.b()) / 2);

        return new Pixel.Color(newRed, newGreen, newBlue);
    }
}
