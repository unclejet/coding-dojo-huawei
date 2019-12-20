package com.uj.study.decimal.binary.conversion;

import com.uj.study.common.input.LineReader;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LineReader lineReader = ()->new Scanner(System.in).nextLine();
        UserInputReader userInputReader = new UserInputReader(lineReader);
        String[] userInputHex = userInputReader.readHex();
        int[] result = HexToDecimal.hex2Dec(userInputHex);
        Arrays.stream(result).forEach(System.out::println);
    }
}
