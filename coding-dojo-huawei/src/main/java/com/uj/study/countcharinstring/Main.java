package com.uj.study.countcharinstring;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        LinePrinter linePrinter = (String s) -> System.out.println(s);

        UserInputReader reader = new UserInputReader(lineReader);
        String firstLine = reader.readFirstLine();
        String secondLine = reader.readSecondLine();
        long count = CharCounter.count(firstLine, secondLine);

        linePrinter.printLine(String.valueOf(count));
    }
}
