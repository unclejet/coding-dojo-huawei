package com.uj.study.four_operations;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/16 下午12:54
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        FourOperationsUserInputReader reader = new FourOperationsUserInputReader(lineReader);
        Operations operations = new Operations();
        System.out.println(operations.calculate(reader.readOperation()));
    }
}
