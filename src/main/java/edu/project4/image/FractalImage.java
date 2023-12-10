package edu.project4.image;

import edu.project4.pixel.Pixel;
import edu.project4.pixel.Point;
import java.util.Map;

public record FractalImage(Map<Point, Pixel> pixels, Resolution resolution) {
}
