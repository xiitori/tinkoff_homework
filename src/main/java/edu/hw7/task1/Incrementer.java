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

    private final AtomicInteger counter;

    public Incrementer(int integer) {
        counter = new AtomicInteger(integer);
    }


    public int incrementByThreads(int countIncrement, int countThreads) {
        ExecutorService executorService = Executors.newFixedThreadPool(countThreads);
        Callable<Void> task = () -> {
            for (int i = 0; i < countIncrement; i++) {
                counter.incrementAndGet();
            }
            return null;
        };

        var tasks = Stream.generate(() -> task).limit(countThreads).toList();

        try {
            List<Future<Void>> futures = executorService.invokeAll(tasks);
            for (var future : futures) {
                future.get();
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();

        return counter.get();
    }
}
