package com.uj.study.compute_string_edit_distance;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/9/1 下午12:56
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        StringEditDistanceUserInputReader reader = new StringEditDistanceUserInputReader(lineReader);
        System.out.println(StringEditDistance.calculate(reader.readString(), reader.readString()));
    }
}
