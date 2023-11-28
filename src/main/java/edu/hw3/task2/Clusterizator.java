package edu.hw3.task2;

import java.util.LinkedList;
import java.util.List;

public class Clusterizator {

    private Clusterizator() {

    }

    public static List<String> clusterize(String braceString) {
        List<String> result = new LinkedList<>();
        int braceCount = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char brace : braceString.toCharArray()) {
            if (brace == '(') {
                braceCount++;
            } else if (brace == ')') {
                braceCount--;
            } else {
                throw new IllegalArgumentException();
            }
            if (braceCount < 0) {
                throw new IllegalArgumentException();
            }
            stringBuilder.append(brace);
            if (braceCount == 0) {
                result.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }
        if (!stringBuilder.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
