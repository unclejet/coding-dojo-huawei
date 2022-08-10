package com.uj.study.string_reverse;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/8/10 下午12:39
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        StringReverseUserReader reader = new StringReverseUserReader(lineReader);
        String line = reader.read();
        System.out.println(StringReverser.reverse(line));
    }
}
