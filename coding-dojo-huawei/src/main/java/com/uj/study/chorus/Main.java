package com.uj.study.chorus;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/11/18 下午12:29
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        ChorusUserInputReader reader = new ChorusUserInputReader(lineReader);
        int[] heights = reader.readHeights();
        System.out.println(new Chorus(heights).outOfQueue());
    }
}
