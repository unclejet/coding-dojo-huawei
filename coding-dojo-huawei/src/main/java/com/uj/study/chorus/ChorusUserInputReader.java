package com.uj.study.chorus;

import com.uj.study.common.input.BaseUserInputReader;
import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/11/10 下午12:40
 * @description：
 */
public class ChorusUserInputReader extends UserInputReader {
    public ChorusUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public int readHeights() {
        return readInteger();
    }

    private int readInteger() {
        String line = lineReader.readLine();
        while (!isInteger(line)) {
            System.out.println("Please input a integer: ");
            line = lineReader.readLine();
        }
        return Integer.parseInt(line);
    }
}
