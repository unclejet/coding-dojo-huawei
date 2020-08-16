package com.uj.study.extract.nonrepeat.integer;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：unclejet
 * @date ：Created in 2020/8/16 上午9:59
 * @description：
 * @modified By：
 * @version:
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        UserInputReader userInputReader = new UserInputReader(lineReader);
        int inputNumber = userInputReader.readInteger();

        int revertedNum = new NonRepeatExtractor().extract(inputNumber);

        System.out.println(revertedNum);
    }
}
