package com.uj.study.rabbit.statistic;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/14 下午12:28
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        RabbitStatisticUserInputReader reader = new RabbitStatisticUserInputReader(lineReader);
        System.out.println(RabbitStatistic.statistic(reader.readMonth()));
    }
}
