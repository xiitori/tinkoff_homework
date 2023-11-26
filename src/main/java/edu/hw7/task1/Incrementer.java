package edu.hw7.task1;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Incrementer {

    private static final int COUNT_THREADS = 5;

    private final AtomicInteger counter;

    public Incrementer(AtomicInteger integer) {
        counter = integer;
    }


    public AtomicInteger increment100_000() {
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREADS);
        Callable<Void> task = () -> {
            for (int i = 0; i < 20000; i++) {
                counter.incrementAndGet();
            }
            return null;
        };

        var tasks = Stream.generate(() -> task).limit(COUNT_THREADS).toList();

        try {
            List<Future<Void>> futures = executorService.invokeAll(tasks);
            for (var future : futures) {
                future.get();
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();

        return counter;
    }
}
