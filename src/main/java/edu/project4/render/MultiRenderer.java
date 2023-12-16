package edu.project4.render;

import edu.project4.image.FractalImage;
import edu.project4.image.Resolution;
import edu.project4.pixel.Pixel;
import edu.project4.transformation.AffineTransformation;
import edu.project4.transformation.Transformation;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultiRenderer implements Renderer {

    private final int countThreads;

    public MultiRenderer(int countThreads) {
        this.countThreads = countThreads;
    }

    @Override
    public FractalImage render(
        Resolution resolution,
        int symmetry,
        int samples,
        int iterations,
        List<AffineTransformation> affines,
        List<Transformation> transformations
    ) {
        ExecutorService service = Executors.newFixedThreadPool(countThreads);

        Callable<FractalImage> task = () -> new SingleRenderer().render(
            resolution,
            symmetry,
            samples / countThreads,
            iterations,
            affines,
            transformations
        );

        var tasks = Stream.generate(() -> task).limit(countThreads).toList();
        var images = new LinkedList<FractalImage>();
        try {
            var futures = service.invokeAll(tasks);

            for (var future : futures) {
                images.add(future.get());
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        service.shutdown();
        service.close();

        var result =
            images.stream().map(FractalImage::pixels).flatMap(map -> map.entrySet().stream()).collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue,
                (pixel, pixel2) -> new Pixel(
                    updateColor(pixel.color(), pixel2.color()),
                    pixel.hitCount() + pixel2.hitCount()
                )
            ));

        return new FractalImage(result, resolution);
    }
}
