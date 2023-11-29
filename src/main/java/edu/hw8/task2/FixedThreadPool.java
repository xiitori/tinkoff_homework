package edu.hw8.task2;

public class FixedThreadPool implements ThreadPool {

    private final int countThreads;

    private final Thread[] threads;

    private FixedThreadPool(int nThreads) {
        countThreads = nThreads;
        threads = new Thread[countThreads];
    }

    public ThreadPool create(int countThreads) {
        return new FixedThreadPool(countThreads);
    }
    @Override
    public void start() {

    }

    @Override
    public void execute(Runnable runnable) {

    }

    @Override
    public void close() throws Exception {

    }
}
