package com.uj.study.cut_string;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/6/20 下午12:44
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        StringCutterUserInputReader reader = new StringCutterUserInputReader(lineReader);
        String line = reader.readString();
        System.out.println(StringCutter.cutString(line, reader.readNumber(line.length())));
    }
}
