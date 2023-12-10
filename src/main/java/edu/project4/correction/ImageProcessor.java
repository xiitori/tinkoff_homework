package edu.project4.correction;

import edu.project4.image.FractalImage;

@FunctionalInterface
public interface ImageProcessor {
    FractalImage process(FractalImage image);
}
