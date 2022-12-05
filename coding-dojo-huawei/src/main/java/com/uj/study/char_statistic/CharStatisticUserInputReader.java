package com.uj.study.char_statistic;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/12/5 下午12:18
 * @description：
 */
public class CharStatisticUserInputReader extends ValidLineReader {
    public CharStatisticUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public String readString() {
        return readValidLine("");
    }

    @Override
    protected boolean isValidString(String line) {
        return true;
    }
}
