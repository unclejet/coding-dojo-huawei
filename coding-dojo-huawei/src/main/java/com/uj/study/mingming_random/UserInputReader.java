package com.uj.study.mingming_random;

import java.util.regex.Pattern;

public final class UserInputReader {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
    private LineReader lineReader;

    public UserInputReader(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    public int readArraySize() {
        return readANumber();
    }

    private int readANumber() {
        return Integer.parseInt(readNumberString());
    }

    private String readNumberString() {
        String line = lineReader.readLine();
        while (!NUMBER_PATTERN.matcher(line).matches()) {
            System.out.println("Please input a number");
            line = lineReader.readLine();
        }
        return line;
    }

    public int[] createArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = readANumber();
        }
        return result;
    }
}
