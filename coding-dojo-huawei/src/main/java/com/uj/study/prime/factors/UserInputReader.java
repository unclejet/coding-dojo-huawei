package com.uj.study.prime.factors;

import com.uj.study.common.input.LineReader;

import java.sql.ResultSet;

public class UserInputReader {
    private final LineReader lineReader;

    public UserInputReader(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    public int readANumber() {
        int result = -1;
        do {
            String line = lineReader.readLine();
            try {
                result = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("please input a number");
            }
        } while (result <= 0);
        return result;
    }
}
