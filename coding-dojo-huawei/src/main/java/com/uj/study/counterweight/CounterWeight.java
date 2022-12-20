package com.uj.study.counterweight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/12/14 下午12:19
 * @description：
 */
public class CounterWeight {
    public static Set<Integer> count(List<Integer> weights, List<Integer> quantities) {
        Set<Integer> result = new HashSet<>();
        result.add(0);
        for (int i = 0; i < weights.size(); i++) {
            int weight = weights.get(i);
            int quantity = quantities.get(i);
            listWeightsWithQuantity(result, weight, quantity);
        }
        return result;
    }

    private static void listWeightsWithQuantity(Set<Integer> result, int weight, int quantity) {
        List<Integer> list = new ArrayList<>(quantity);
        for (int r : result) {
            for (int q = 0; q < quantity; q++) {
                r += weight;
                list.add(r);
            }
        }
        result.addAll(list);
    }
}
