package com.uj.study.snake_array;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/1 下午12:25
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        SnakeArrayUserInputReader reader = new SnakeArrayUserInputReader(lineReader);
        System.out.println(SnakeArrayGenerator.printSnakeArray(reader.readNumber()));
    }
}
