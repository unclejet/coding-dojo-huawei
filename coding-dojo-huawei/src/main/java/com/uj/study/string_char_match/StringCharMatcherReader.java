package com.uj.study.string_char_match;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.regex.Pattern;

public class StringCharMatcherReader extends ValidLineReader {
    private static final Pattern PATTERN = Pattern.compile("^[a-z]{1,200}$");

    public StringCharMatcherReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        if (line == null) {
            return false;
        }
        String trimmed = line.trim();
        return PATTERN.matcher(trimmed).matches();
    }

    public String readString() {
        while (true) {
            String input = lineReader.readLine();
            if (input == null) {
                continue;
            }
            input = input.trim();
            if (isValidString(input)) {
                return input;
            }
        }
    }
} 