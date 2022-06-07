package com.uj.study.sort_string;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/1/24 下午12:44
 * @description：
 */
public class SortStringsInputReader extends ValidLineReader {
    public SortStringsInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public String readLine() {
        return super.readValidLine("Please input alpha string and length <= 1000 : ");
    }

    protected boolean isValidString(String line) {
        return line.length() <= 1000;
    }
}
