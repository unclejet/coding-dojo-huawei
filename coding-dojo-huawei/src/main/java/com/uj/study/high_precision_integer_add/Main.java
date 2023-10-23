package com.uj.study.high_precision_integer_add;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/23 下午12:51
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        HighPrecisionIntegerReader reader = new HighPrecisionIntegerReader(lineReader);
        System.out.println(HighPrecisionIntegerAdder.add(reader.readNumString(), reader.readNumString()));
    }
}
