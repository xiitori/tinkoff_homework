package edu.project4;

import edu.project4.image.Resolution;
import edu.project4.render.MultiRenderer;
import edu.project4.render.Renderer;
import edu.project4.render.SingleRenderer;
import edu.project4.transformation.AffineTransformation;
import edu.project4.transformation.SpiralTransformation;
import edu.project4.transformation.Transformation;
import java.util.List;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class RendererTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    void test() {
        Renderer multiRenderer = new MultiRenderer(8);
        Renderer singleRenderer = new SingleRenderer();
        int symmetry = 4;
        int samples = 300;
        int iterations = 10000;
        var affines = Stream.generate(AffineTransformation::getRandomAffine).limit(20).toList();
        List<Transformation> transformations = List.of(new SpiralTransformation());
        Resolution resolution = new Resolution(1920, 1080);

        long multiTime = System.nanoTime();
        multiRenderer.render(resolution, symmetry, samples, iterations, affines, transformations);
        multiTime = System.nanoTime() - multiTime;

        long singleTime = System.nanoTime();
        singleRenderer.render(resolution, symmetry, samples, iterations, affines, transformations);
        singleTime = System.nanoTime() - singleTime;

        LOGGER.info(String.format("Multithreading %s times faster than Single", (double) singleTime / multiTime));
    }
}
