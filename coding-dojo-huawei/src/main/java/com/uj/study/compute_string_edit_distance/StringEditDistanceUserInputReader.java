package com.uj.study.compute_string_edit_distance;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/9/1 下午12:51
 * @description：
 */
public class StringEditDistanceUserInputReader extends ValidLineReader {
    public StringEditDistanceUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        return line.length() >= 1 && line.length() <= 1000;
    }

    public String readString() {
        return readValidLine("Please input string 1<=length<=1000:");
    }
}
