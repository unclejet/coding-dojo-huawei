package com.uj.study.revert_sentence;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/3 下午3:30
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        SentenceReverseInputReader inputReader = new SentenceReverseInputReader(lineReader);
        System.out.println(SentenceReverse.revert(inputReader.readAlpha()));
    }
}
