package edu.project4.save;

import edu.project4.image.FractalImage;
import edu.project4.image.ImageFormat;
import edu.project4.pixel.Pixel;
import edu.project4.pixel.Pixel.Color;
import edu.project4.pixel.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import javax.imageio.ImageIO;

public class SaveUtils {

    private SaveUtils() {
    }

    public static void saveImage(FractalImage map, Path fileName, ImageFormat format) {
        BufferedImage image =
            new BufferedImage(map.resolution().width(), map.resolution().height(), BufferedImage.TYPE_INT_RGB);
        initializeImage(image, map.pixels());
        try {

            String name = fileName.getFileName().toString().split("\\.")[0];
            Path file = fileName.resolveSibling(name + "." + format.name().toLowerCase());

            Files.createDirectories(fileName.getParent());
            File outputfile = file.toFile();
            ImageIO.write(image, format.name().toLowerCase(), outputfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initializeImage(BufferedImage image, Map<Point, Pixel> pixelMap) {
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                Pixel pixel = pixelMap.get(new Point(j, i));
                if (pixel == null) {
                    pixel = new Pixel(Color.BLACK, 0);
                }
                int rgb = new java.awt.Color(pixel.color().r(), pixel.color().g(), pixel.color().b()).getRGB();
                image.setRGB(j, i, rgb);
            }
        }
    }
}
