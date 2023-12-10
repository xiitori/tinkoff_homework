package edu.hw9.task1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StatsCollector {
    private Map<String, Double[]> map = new ConcurrentHashMap<>();

    public synchronized void push(String metricName, Double[] metrics) {
        map.put(metricName, metrics);
    }

    private class Metrics {
        private String metricName;

        private double[] metrics;


    }
}
