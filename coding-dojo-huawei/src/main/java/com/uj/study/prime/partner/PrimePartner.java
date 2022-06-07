package com.uj.study.prime.partner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/5/30 下午12:01
 * @description：
 */
public class PrimePartner {
    private static List<Integer> partners;
    public static int bestPartner(List<Integer> numbers) {
        partners = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < numbers.size(); i++)
            for (int j = i + 1; j < numbers.size(); j++)
                if (PrimeIdentifier.isPrime(numbers.get(i) + numbers.get(j)))
                    if (!(partners.contains(numbers.get(i)) || partners.contains(numbers.get(j)))) {
                        count++;
                        partners.add(numbers.get(i));
                        partners.add(numbers.get(j));
                        i = j;
                        break;
                    }
        return count;
    }

    public static List<Integer> getPartners() {
        return partners;
    }
}
