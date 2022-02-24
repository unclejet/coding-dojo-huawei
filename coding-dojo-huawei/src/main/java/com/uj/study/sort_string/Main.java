package com.uj.study.sort_string;

import com.uj.study.common.input.LineReader;
import com.uj.study.countcharinstring.LinePrinter;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/2/24 上午11:49
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        LinePrinter linePrinter = (String s) -> System.out.println(s);
        SortStringsInputReader reader = new SortStringsInputReader(lineReader);

        String input = reader.readLine();
        while (!finished(input)) {
            linePrinter.printLine(LineSorter.sort(input));
            input = reader.readLine();
        }
    }

    private static boolean finished(String input) {
        return input.equals("exit");
    }
}
