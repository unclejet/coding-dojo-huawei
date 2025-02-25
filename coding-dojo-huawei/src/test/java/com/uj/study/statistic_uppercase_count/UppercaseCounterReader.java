package com.uj.study.statistic_uppercase_count;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

public class UppercaseCounterReader extends UserInputReader {
    public UppercaseCounterReader(LineReader lineReader) {
        super(lineReader);
    }

    public String readInput() {
        String input = lineReader.readLine();

        while (input.length() < 1 || input.length() > 250) {
            System.out.println("Input length must be between 1 and 250 characters. Please try again.");
            input = lineReader.readLine();
        }

        return input;
    }
}
