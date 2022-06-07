package com.uj.study.prime.partner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/5/25 下午12:44
 * @description：
 */
public class PrimeIdentifier {
    public static boolean isPrime(int n) {
        if (n > 1) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        }
        return false;
    }
}
