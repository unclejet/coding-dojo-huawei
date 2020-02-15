package com.uj.study.approximate.value;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：unclejet
 * @date ：Created in 2020/2/15 12:13
 * @description：
 * @modified By：
 * @version:
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        UserInputReader userInputReader = new UserInputReader(lineReader);
        float v = userInputReader.readAFloatNumber();
        System.out.println("Approximate value is: " + ApproximateValuer.calculate(v));
    }
}
