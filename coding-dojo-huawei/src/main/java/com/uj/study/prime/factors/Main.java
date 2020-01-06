package com.uj.study.prime.factors;

import com.uj.study.common.input.LineReader;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：unclejet
 * @date ：Created in 2020/1/6 12:58
 * @description：
 * @modified By：
 * @version:
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = ()->new Scanner(System.in).nextLine();
        UserInputReader userInputReader = new UserInputReader(lineReader);
        int inputNumber = userInputReader.readANumber();
        List<Integer> result = PrimeFactor.getPrimeFactor(inputNumber);
        result.forEach(System.out::println);
    }

}
