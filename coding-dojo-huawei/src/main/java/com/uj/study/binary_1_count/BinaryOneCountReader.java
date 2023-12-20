package com.uj.study.binary_1_count;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/12/20 下午12:35
 * @description：
 */
public class BinaryOneCountReader extends ValidLineReader {

    public BinaryOneCountReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        int n = getInteger(line);
        return n >= 1 && n <= Integer.MAX_VALUE;
    }

    public String readNumberStr() {
        return readValidLine("please input a number >=1 and <= 2147483647");
    }
}
