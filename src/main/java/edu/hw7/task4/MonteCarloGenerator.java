package edu.hw7.task4;

import java.awt.Point;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class MonteCarloGenerator {

    private static final int MULTIPLIER = 4;

    private static final int SQUARE_SIZE = 1000000;

    private static final int RADIUS = SQUARE_SIZE / 2;

    private MonteCarloGenerator() {
    }

    public static double getPi(int countSimulations) {
        int totalCount = 0;
        int circleCount = 0;

        for (int i = 0; i < countSimulations; i++) {
            Point point = new Point(
                ThreadLocalRandom.current().nextInt(SQUARE_SIZE),
                ThreadLocalRandom.current().nextInt(SQUARE_SIZE)
            );

            if (Math.pow(point.x - RADIUS, 2) + Math.pow(point.y - RADIUS, 2) <= Math.pow(RADIUS, 2)) {
                circleCount++;
            }
            totalCount++;
        }

        return MULTIPLIER * ((double) circleCount / totalCount);
    }

    public static double getPiParallel(int countSimulations, int countThreads) {
        Callable<Result> callable = () -> {
            int totalCount = 0;
            int circleCount = 0;

            for (int i = 0; i < countSimulations / countThreads; i++) {
                int x = ThreadLocalRandom.current().nextInt(SQUARE_SIZE);
                int y = ThreadLocalRandom.current().nextInt(SQUARE_SIZE);

                if (Math.pow(x - RADIUS, 2) + Math.pow(y - RADIUS, 2) <= Math.pow(RADIUS, 2)) {
                    circleCount++;
                }
                totalCount++;
            }

            return new Result(totalCount, circleCount);
        };

        ExecutorService service = Executors.newFixedThreadPool(countThreads);
        var tasks = Stream.generate(() -> callable).limit(countThreads).toList();
        try {
            var futures = service.invokeAll(tasks);
            int totalCount = 0;
            int circleCount = 0;
            for (var future : futures) {
                Result result = future.get();
                totalCount += result.totalCount;
                circleCount += result.circleCount;
            }

            return MULTIPLIER * ((double) circleCount / (double) totalCount);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private record Result(int totalCount, int circleCount) {
    }
}
