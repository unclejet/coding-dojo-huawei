package com.uj.study.password_crack;

import com.uj.study.common.input.BaseUserInputReader;
import com.uj.study.common.input.LineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/16 下午12:04
 * @description：
 */
public class PwdCrackUserInputReader extends BaseUserInputReader {
    public PwdCrackUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public String readPwd() {
        String line = lineReader.readLine();
        while (!isValid(line)) {
            System.out.println("Please input pwd not more than 100");
            line = lineReader.readLine();
        }
        return line;
    }

    private boolean isValid(String line) {
        return line.length() <= 100;
    }
}
