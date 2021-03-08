package com.uj.study.count_one_in_binary_number;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/22 下午1:51
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        IntegerNumberUserInputReader reader = new IntegerNumberUserInputReader(lineReader);
        int count = Binary1NumberCounter.count(DecimalToBinary.convert(reader.readInteger()));
        System.out.println(count);
    }
}
