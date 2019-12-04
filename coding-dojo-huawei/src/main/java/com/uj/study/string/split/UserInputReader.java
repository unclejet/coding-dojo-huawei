package com.uj.study.string.split;

import com.uj.study.common.input.LineReader;

public class UserInputReader {
    private LineReader lineReader;

    public UserInputReader(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    public String[] read2String() {
        String[] result = new String[2];
        int i = 0;
        while (i < 2) {
            result[i++] = lineReader.readLine();
        }

        return result;
    }
}
