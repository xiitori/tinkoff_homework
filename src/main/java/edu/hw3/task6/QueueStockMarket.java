package edu.hw3.task6;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueStockMarket implements StockMarket {

    private final PriorityQueue<Stock> queue = new PriorityQueue<>();

    @Override
    public void add(Stock stock) {
        queue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        queue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return queue.peek();
    }
}
