package com.uj.study.decimal.binary.conversion;

import com.uj.study.common.input.LineReader;

import java.util.Arrays;
import java.util.regex.Pattern;

public class UserInputReader {
    public static final Pattern HEX = Pattern.compile("^[0][xX][0-9a-fA-F]+$");
    private LineReader lineReader;

    public UserInputReader(LineReader lineReader) {
        this.lineReader = lineReader;
    }


    public String[] readHex() {
        String line = lineReader.readLine();
        String[] temp = line.trim().split("\\s+");
        String[] result = Arrays.stream(temp).filter(s -> HEX.matcher(s).matches()).toArray(String[]::new);
        return result.length > 0 ? result : new String[]{""};
    }
}
