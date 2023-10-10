package com.uj.study.pick7;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/9 下午12:59
 * @description：
 */
public class SevenPickerUserInputReader extends ValidLineReader {
    public SevenPickerUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        int n = getInteger(line);
        return n >= 1 && n <= 30000;
    }

    public int readNumber() {
        String line = readValidLine("please input number like 1<=n<=30000 :");
        return getInteger(line);
    }
}
