package com.uj.study.string.split;

import com.uj.study.common.input.LineReader;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        UserInputReader userInputReader = new UserInputReader(lineReader);
        String[] userInput = userInputReader.read2String();
        List<String> result = StringSplit.splitString(userInput);
        result.forEach(System.out::println);
    }
}
