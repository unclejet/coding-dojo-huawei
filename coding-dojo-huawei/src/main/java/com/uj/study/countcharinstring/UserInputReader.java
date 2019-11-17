package com.uj.study.countcharinstring;

public class UserInputReader {
    private LineReader lineReader;
    private static final String FIRST_REGEX = "[a-zA-Z0-9\\s]+";
    private static final String SECOND_REGEX = "[a-zA-Z0-9\\s]";

    public UserInputReader(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    public String readFirstLine() {
        String s = lineReader.readLine();
        while (!s.matches(FIRST_REGEX)) {
            s = lineReader.readLine();
        }
        return s;
    }

    public String readSecondLine() {
        String s = lineReader.readLine();
        while (!s.matches(SECOND_REGEX)) {
            s = lineReader.readLine();
        }
        return s;
    }
}
