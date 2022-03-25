package com.uj.study.brother_word;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/3/25 下午12:27
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        BrotherWordUserInputReader reader = new BrotherWordUserInputReader(lineReader);
        InputData inputData = reader.readLine();
        String result = BrowserWordFinder.findSpecialBrother(inputData.getWords(), inputData.getWord(), inputData.getIndex());
        String[] arr = result.split(",");
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }
}
