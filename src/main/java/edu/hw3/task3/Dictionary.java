package edu.hw3.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {

    private Dictionary() {

    }

    public static <T> Map<T, Integer> freqDict(List<T> list) {
        Map<T, Integer> map = new HashMap<>();
        for (T element : list) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }
        return map;
    }
}
