package com.uj.study.find_code_error;

import com.uj.study.common.input.LineReader;

import java.util.List;
import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/4/23 下午5:23
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        CodeErrorFinderUserInputReader reader = new CodeErrorFinderUserInputReader(lineReader);
        List<String> results = CodeErrorFinder.report(CodeErrorFinder.handleRecords(reader.readCodeFileErrorRecords()));
        results.forEach(System.out::println);
    }
}
