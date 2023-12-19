package edu.hw3.task7;

import java.util.Comparator;

public final class NullComparator implements Comparator<String> {

    private static final NullComparator COMPARATOR = new NullComparator();

    private NullComparator() {

    }

    @Override
    public int compare(String o1, String o2) {
        boolean firstNull = o1 == null;
        boolean secondNull = o2 == null;
        return firstNull ? 0 : o1.length() - (secondNull ? 0 : o2.length());
    }

    public static NullComparator getComparator() {
        return COMPARATOR;
    }
}
