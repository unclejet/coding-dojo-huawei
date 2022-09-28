package com.uj.study.password_interception;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/9/27 下午12:55
 * @description：
 */
public class PasswordInterceptionUserInputReader extends ValidLineReader {
    public PasswordInterceptionUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public String readLine() {
        return readValidLine("please input string length >= 1 and <= 2500");
    }

    @Override
    protected boolean isValidString(String line) {
        return line.length() >= 1 && line.length() <= 2500;
    }


}
