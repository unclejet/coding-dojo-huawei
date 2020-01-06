package com.uj.study.prime.factors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    public static List<Integer> getPrimeList(int n) {
        List<Integer> result = new ArrayList<>();
        boolean isPrime;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0 && i != 2)
                continue; //偶数和1排除
            isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> getPrimeFactor(int n) {
        List<Integer> result = new ArrayList<>();
        List<Integer> primes = getPrimeList(n);
        int number = n;
        for (Integer prime : primes) {
            while (number % prime == 0) {
                result.add(prime);
                number = number / prime;
            }
            if (primes.contains(number)) {
                result.add(number);
                break;
            }
        }
        return result;
    }
}
