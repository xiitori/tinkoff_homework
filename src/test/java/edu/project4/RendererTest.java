package edu.project4;

import edu.project4.correction.ImageCorrection;
import edu.project4.image.ImageFormat;
import edu.project4.image.Resolution;
import edu.project4.render.MultiRenderer;
import edu.project4.render.Renderer;
import edu.project4.transformation.AffineTransformation;
import edu.project4.transformation.SpiralTransformation;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static edu.project4.save.SaveUtils.saveImage;

public class RendererTest {

    @Test
    void test() {
        Renderer renderer = new MultiRenderer(8);
        var image = renderer.render(-1.777, 1.777, -1, 1, new Resolution(1920, 1080),
            4, 200, 30000, Stream.generate(AffineTransformation::getRandomAffine).limit(50).toList(),
            List.of(new SpiralTransformation())
        );

        image = new ImageCorrection().process(image);

        saveImage(image, Path.of("C://Users/weuret/Desktop/fractal5.png"), ImageFormat.PNG);
    }
}
