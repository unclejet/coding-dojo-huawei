package com.uj.study.two_prime_makeup_even_number;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TwoPrimesNearestOneEvenNumber {

    public static TwoPrimes nearestPrimes(int number) {
        List<TwoPrimes> matchPrimes = matchPrimes(number);
        return matchPrimes.stream().min(Comparator.comparing(p -> p.getPrime2() - p.getPrime1())).get();
    }

    static List<TwoPrimes> matchPrimes(int n) {
        List<TwoPrimes> result = new ArrayList<TwoPrimes>();
        List<Integer> primes = getPrimeList(n);
        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i) + primes.get(i) == n) {
                result.add(new TwoPrimes(primes.get(i), primes.get(i)));
            }
            for (int j = i + 1; j < primes.size(); j++) {
                if ((primes.get(i) + primes.get(j)) == n) {
                    result.add(new TwoPrimes(primes.get(i), primes.get(j)));
                }
            }
        }
        return result;
    }

    static List<Integer> getPrimeList(int n) {
        List<Integer> result = new ArrayList<Integer>();
        boolean isPrime;
        for (Integer i = 2; i <= n; i++) {
            if (i % 2 == 0 && i != 2)
                continue; //偶数和1排除
            isPrime = true;
            for (Integer j = 2; j <= Math.sqrt(i); j++) {
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
}