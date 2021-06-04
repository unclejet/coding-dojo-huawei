package com.uj.study.password_verify;

import com.uj.study.common.input.LineReader;

import java.util.List;
import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/4 下午4:35
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        PwdVerifyUserInputReader inputReader = new PwdVerifyUserInputReader(lineReader);
        List<String> reporter = PwdVerifier.verify(inputReader.readPwdList());
        reporter.stream().forEach(System.out::println);
    }
}
