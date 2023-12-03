package edu.hw8.task2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FixedThreadPool implements ThreadPool {
    private final Queue<Runnable> workQueue = new ConcurrentLinkedQueue<>();

    private int countWorkers = 0;

    private final int nThreads;
    private volatile boolean isRunning = true;

    private FixedThreadPool(int nThreads) {
        this.nThreads = nThreads;
    }

    public static FixedThreadPool create(int nThreads) {
        return new FixedThreadPool(nThreads);
    }

    @Override
    public void start() {
        new Thread(new Worker()).start();
    }

    @Override
    public void execute(Runnable command) {
        if (isRunning) {
            if (countWorkers < nThreads) {
                new Thread(new Worker()).start();
            }
            workQueue.offer(command);
        }
    }

    @Override
    public void close() {
        isRunning = false;
    }

    private final class Worker implements Runnable {

        Worker() {
            countWorkers++;
        }

        @Override
        public void run() {
            while (isRunning) {
                Runnable nextTask = workQueue.poll();
                if (nextTask != null) {
                    nextTask.run();
                }
            }
        }
    }
}
