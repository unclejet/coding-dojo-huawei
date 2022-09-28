package com.uj.study.password_interception;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/9/27 下午12:45
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        PasswordInterceptionUserInputReader reader = new PasswordInterceptionUserInputReader(lineReader);
        SymmetryFinder finder = new SymmetryFinder();
        System.out.println(finder.findMaxSymmetryLength(reader.readLine()));
    }
}
