package com.uj.study.max_length_substring;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

public class MaxLengthSubstringReader extends UserInputReader {
    public MaxLengthSubstringReader(LineReader lineReader) {
        super(lineReader);
    }

    public String read() {
        String input;
        while (true) {
            input = lineReader.readLine();
            if (input.matches("[a-z]{1,350}")) {
                break;
            }
            // Optionally, you can provide feedback to the user here
        }
        return input;
    }
}
