package com.uj.study.pick7;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/10 下午12:38
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        SevenPickerUserInputReader reader = new SevenPickerUserInputReader(lineReader);
        System.out.println(SevenPicker.count7(reader.readNumber()));
    }
}
