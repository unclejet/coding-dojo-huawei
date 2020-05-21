package com.uj.study.combine.table.record;

import com.uj.study.common.input.LineReader;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserInputReader {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    public static final Pattern KEY_VALUE_PATTERN = Pattern.compile("\\d+\\s+\\d+");
    private LineReader lineReader;

    public UserInputReader(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    public int readIndexNumber() {
        String line = lineReader.readLine();
        while (!NUMBER_PATTERN.matcher(line).matches()) {
            System.out.println("Please input a number");
            line = lineReader.readLine();
        }
        return Integer.parseInt(line);
    }

    private Pair readKeyValuePair() {
        String line = lineReader.readLine();
        while (!KEY_VALUE_PATTERN.matcher(line).matches()) {
            System.out.println("Please input key value separated by blank");
            line = lineReader.readLine();
        }
        String[] strings = line.split("\\s+");
        return new Pair(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]));
    }

    public List<Pair> readIndexedNumberKeyValues(int index) {
        List<Pair> pairs = new ArrayList<>(index);
        for (int i = 0; i < index; i++) {
            pairs.add(readKeyValuePair());
        }
        return pairs;
    }
}
