package com.uj.study.string.split;

import com.uj.study.common.input.LineReader;

public class UserInputReader {
    public static final int SPECIFY_MAX_INPUT_LENGTH = 100;
    private LineReader lineReader;

    public UserInputReader(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    public String[] read2String() {
        String[] result = new String[2];
        int i = 0;
        while (i < 2) {
            String input = lineReader.readLine();
            while (input.length() > SPECIFY_MAX_INPUT_LENGTH) {
                System.out.println("please input string less than 100");
                input = lineReader.readLine();
            }
            result[i++] = input;

        }

        return result;
    }
}
