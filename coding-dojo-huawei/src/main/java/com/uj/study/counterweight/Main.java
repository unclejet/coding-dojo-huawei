package com.uj.study.counterweight;

import com.uj.study.common.input.LineReader;

import java.util.List;
import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/12/15 下午12:32
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        CounterWeightUserInputReader reader = new CounterWeightUserInputReader(lineReader);
        int typeNumber = reader.readTypeNumber();
        List<Integer> weights = reader.readWeight(typeNumber);
        List<Integer> quantities = reader.readQuantities(typeNumber);
        System.out.println(CounterWeight.count(weights, quantities));
    }
}
