package edu.hw3.task6;

import org.jetbrains.annotations.NotNull;

public class Stock implements Comparable<Stock> {
    private final int value;

    private final String name;

    public Stock(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(@NotNull Stock o) {
        return o.value - this.value;
    }
}
