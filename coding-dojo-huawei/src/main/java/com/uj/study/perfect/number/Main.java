package com.uj.study.perfect.number;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/11 下午12:52
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        PerfectNumberUserInputReader reader = new PerfectNumberUserInputReader(lineReader);
        System.out.println(PerfectNumberCounter.countWithin(reader.readNumber()));
    }
}
