package com.uj.study.reverse_number;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/1/26 下午12:02
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        ReverseNumberUserInputReader inputReader = new ReverseNumberUserInputReader(lineReader);
        System.out.println(NumberReverse.reverse(inputReader.readNumberStr()));
    }
}
