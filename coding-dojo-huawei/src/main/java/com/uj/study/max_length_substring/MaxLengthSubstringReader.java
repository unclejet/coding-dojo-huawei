package com.uj.study.max_length_substring;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;
import com.uj.study.common.input.ValidLineReader;

public class MaxLengthSubstringReader extends UserInputReader {
    
    public MaxLengthSubstringReader(LineReader lineReader) {
        super(lineReader);
    }

    public String read() {
        while (true) {
            String input = lineReader.readLine();
            if (isValidInput(input)) {
                return input;
            }
        }
    }

    private boolean isValidInput(String input) {
        // 检查是否为空
        if (input == null || input.trim().isEmpty()) {
            return false;
        }

        input = input.trim();
        
        // 检查长度是否在1到350之间
        if (input.length() < 1 || input.length() > 350) {
            return false;
        }

        // 检查是否只包含小写字母
        return input.matches("^[a-z]+$");
    }
} 