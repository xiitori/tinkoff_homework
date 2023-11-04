package edu.hw2.task3;

public class DefaultConnectionManager implements ConnectionManager {

    private int faultyConnectionCounter = 0;

    @Override
    public Connection getConnection() {
        if (faultyConnectionCounter == 2) {
            faultyConnectionCounter = 0;
            return new FaultyConnection();
        } else {
            faultyConnectionCounter++;
            return new StableConnection();
        }
    }
}
