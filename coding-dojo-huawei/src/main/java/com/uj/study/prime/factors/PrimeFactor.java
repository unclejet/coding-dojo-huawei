package com.uj.study.prime.factors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    public static List<Long> getPrimeList(long n) {
        List<Long> result = new ArrayList<>();
        boolean isPrime;
        for (long i = 2; i <= n; i++) {
            if (i % 2 == 0 && i != 2)
                continue; //偶数和1排除
            isPrime = true;
            for (long j = 2; j <= Math.sqrt(i); j++) {
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

    public static List<Long> getPrimeFactor(long n) {
        List<Long> result = new ArrayList<>();
        List<Long> primes = getPrimeList(n);
        long number = n;
        for (Long prime : primes) {
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
