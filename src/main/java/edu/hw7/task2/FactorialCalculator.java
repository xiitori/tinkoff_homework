package edu.hw7.task2;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class FactorialCalculator {

    private FactorialCalculator() {
    }

    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n < 2) {
            return new BigInteger("1");
        }

        List<BigInteger> list = new LinkedList<>();
        for (BigInteger i = new BigInteger("2"); i.intValue() <= n; i = i.add(new BigInteger("1"))) {
            list.add(i);
        }
        return list.parallelStream().reduce(BigInteger::multiply).get();
    }

}
