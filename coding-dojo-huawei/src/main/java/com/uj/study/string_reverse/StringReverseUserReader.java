package com.uj.study.string_reverse;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/8/10 下午12:24
 * @description：
 */
public class StringReverseUserReader extends ValidLineReader {
    public StringReverseUserReader(LineReader lineReader) {
        super(lineReader);
    }

    public String read() {
        return readValidLine("Please input string length >= 1 and <= 10000 ");
    }

    @Override
    protected boolean isValidString(String line) {
        return line.length() >= 1 && line.length() <= 10000;
    }
}
