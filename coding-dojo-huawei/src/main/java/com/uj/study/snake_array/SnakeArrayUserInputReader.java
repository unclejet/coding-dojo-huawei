package com.uj.study.snake_array;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/1 下午12:14
 * @description：
 */
public class SnakeArrayUserInputReader extends ValidLineReader {
    public SnakeArrayUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public int readNumber() {
        return Integer.parseInt(super.readValidLine("please input number 0 < n <= 100"));
    }

    @Override
    protected boolean isValidString(String line) {
        try {
            int number = Integer.parseInt(line);
            return number > 0 && number <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
