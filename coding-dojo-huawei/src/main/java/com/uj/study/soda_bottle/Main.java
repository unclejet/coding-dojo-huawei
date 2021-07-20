package com.uj.study.soda_bottle;

import com.uj.study.common.input.LineReader;

import java.util.List;
import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/7/20 上午11:56
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        SodaBottleUserInputReader reader = new SodaBottleUserInputReader(lineReader);
        List<Integer> bottles = reader.read();
        List<Integer> drinks = DrinkCounter.count(bottles);
        drinks.stream().forEach(System.out::println);
    }
}
