package com.uj.study.sort_string_lines;

import com.uj.study.common.input.LineReader;

import java.util.List;
import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/8 下午5:31
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        SortStringLineUserInputReader inputReader = new SortStringLineUserInputReader(lineReader);
        List<String> sortedStrings = StringLineSorter.sort(inputReader.readMultiLines());
        sortedStrings.stream().forEach(System.out::println);
    }
}
