package com.uj.study.data.classify;

import com.uj.study.common.input.LineReader;
import com.uj.study.countcharinstring.LinePrinter;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/11/30 下午12:30
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        LinePrinter linePrinter = (String s) -> System.out.println(s);

        DataClassifyUserInputReader reader = new DataClassifyUserInputReader(lineReader);
        linePrinter.printLine("Please input sequence I:");
        String[] si = reader.readSequence();
        linePrinter.printLine("Please input sequence R:");
        String[] sr = reader.readSequence();

        linePrinter.printLine(DataClassifier.classify(sr, si));

    }
}
