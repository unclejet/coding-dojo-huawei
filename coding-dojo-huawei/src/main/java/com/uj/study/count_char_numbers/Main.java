package com.uj.study.count_char_numbers;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：unclejet
 * @date ：Created in 2020/9/26 上午8:33
 * @description：
 * @modified By：
 * @version:
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        UserInputReader userInputReader = new UserInputReader(lineReader);
        String input = userInputReader.readAscII();
        long count = CharNumberCounter.count(input);
        System.out.println(count);
    }
}
