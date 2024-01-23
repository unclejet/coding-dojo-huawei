package com.uj.study.string_common_max_substring_length;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/22 下午12:50
 * @description：
 */
public class MaxCommonSubStringSearcherReader extends ValidLineReader {
    public MaxCommonSubStringSearcherReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        return line.length() >= 1 && line.length() <= 300;
    }

    public String readString() {
        return readValidLine("Please input String 1<= length <= 300:");
    }
}
