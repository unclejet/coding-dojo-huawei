package com.uj.study.perfect.number;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PerfectNumberCounter {
    public PerfectNumberCounter() {
    }

    public static long countWithin(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> isPerfectNumber(i))
                .peek(x -> System.out.println(x)).count();
    }

    static boolean isPerfectNumber(int n) {
        List<Integer> divisors = divisors(n);
        int sum = divisors.stream().limit(divisors.size() - 1).mapToInt(Integer::intValue).sum();
        return sum == n && n != 1;
    }

    static List<Integer> divisors(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for (int i = 2; i <= n; i++) {
            if (n % i == 0)
                result.add(i);
        }
        return result;
    }
}