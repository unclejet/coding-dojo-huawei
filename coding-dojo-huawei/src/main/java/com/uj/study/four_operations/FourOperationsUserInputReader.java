package com.uj.study.four_operations;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/16 下午12:35
 * @description：
 */
public class FourOperationsUserInputReader extends ValidLineReader {
    public static final Pattern OPERATION_PATTERN = Pattern.compile("[\\d+\\(\\[\\{\\)\\]\\}\\+\\-\\*\\/]");

    public FourOperationsUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        for (char c: line.toCharArray()) {
            if (!OPERATION_PATTERN.matcher(String.valueOf(c)).matches())
                return false;
        }
        return true;
    }

    public String readOperation() {
        return readValidLine("please input like this 3+2*{1+2*[-4/(8-6)+7]}");
    }
}
