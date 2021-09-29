package com.uj.study.delete_shortest_char_in_string;

import com.uj.study.common.input.LineReader;

import java.util.List;
import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/9/29 上午11:55
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = ()->new Scanner(System.in).nextLine();
        ShortestStringReader inputReader = new ShortestStringReader(lineReader);
        List<String> inputList = inputReader.readStrings();
        inputList.stream().forEach(input-> System.out.println(ShortestStringDelete.shortIt(input)));
    }
}
