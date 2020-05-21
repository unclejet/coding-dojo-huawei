package com.uj.study.combine.table.record;

import com.uj.study.common.input.LineReader;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        UserInputReader userInputReader = new UserInputReader(lineReader);
        int index = userInputReader.readIndexNumber();
        List<Pair> inputTableRecords = userInputReader.readIndexedNumberKeyValues(index);
        List<Pair> result = TableCombiner.combineTable(inputTableRecords);
        result.forEach(System.out::println);
    }
}
