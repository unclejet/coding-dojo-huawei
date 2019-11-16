package com.uj.study.countcharinstring;

public class UserInputReader {
    private LineReader lineReader;

    public UserInputReader(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    public String readFirstLine() {
        return lineReader.readLine();
    }

    public String readSecondLine() {
        return lineReader.readLine();
    }
}
