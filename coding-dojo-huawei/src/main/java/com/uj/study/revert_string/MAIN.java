package com.uj.study.revert_string;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/1 下午4:49
 * @description：
 */
public class MAIN {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        StringRevertUserInputReader inputReader = new StringRevertUserInputReader(lineReader);
        System.out.println(StringRevert.revert(inputReader.readLowercaseCharacters()));
    }
}
