package com.uj.study.char_statistic;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/12/5 下午12:24
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        CharStatisticUserInputReader reader = new CharStatisticUserInputReader(lineReader);
        String str = reader.readString();
        System.out.println(CharStatistic.engCount(str));
        System.out.println(CharStatistic.spaceCount(str));
        System.out.println(CharStatistic.numberCount(str));
        System.out.println(CharStatistic.otherCharsCount(str));
    }
}
