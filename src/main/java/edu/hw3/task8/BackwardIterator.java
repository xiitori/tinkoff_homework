package edu.hw3.task8;

import java.util.Collection;
import java.util.Iterator;

public class BackwardIterator<T> implements Iterator<T> {

    private final T[] array;

    private int index;

    public BackwardIterator(Collection<? extends T> collection) {
        array = (T[]) collection.toArray();
        index = array.length - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public T next() {
        return array[index--];
    }
}
