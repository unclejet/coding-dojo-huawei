package com.uj.study.two_prime_makeup_even_number;

import com.uj.study.common.SuperMain;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/11/1 下午12:51
 * @description：
 */
public class Main extends SuperMain {
    public static void main(String[] args) {
        TwoPrimeNearestOneEvenNumberReader reader = new TwoPrimeNearestOneEvenNumberReader(lineReader);
        TwoPrimes tw = TwoPrimesNearestOneEvenNumber.nearestPrimes(reader.readEvenNumber());
        System.out.println(tw.getPrime1());
        System.out.println(tw.getPrime2());
    }
}
