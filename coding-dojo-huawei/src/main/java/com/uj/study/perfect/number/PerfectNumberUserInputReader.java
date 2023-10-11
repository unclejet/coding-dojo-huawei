package com.uj.study.perfect.number;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/11 下午12:48
 * @description：
 */
public class PerfectNumberUserInputReader extends ValidLineReader {
    public PerfectNumberUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        int n = getInteger(line);
        int max = 5 * 10 * 10 * 10 * 10 * 10;
        return n >= 1 && n<= max;
    }

    public int readNumber() {
        return getInteger(readValidLine("Please input number between 1 and 500000:"));
    }

}
