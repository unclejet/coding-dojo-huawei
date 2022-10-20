package com.uj.study.ip_number_transition;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/10/18 下午12:28
 * @description：
 */
public class NumberUserInputReader extends UserInputReader {
    public NumberUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public long readNumber() {
        String line = lineReader.readLine();
        while (!isValidNumber(line)) {
            System.out.println("Please input number between 0 and 4294967295");
            line = lineReader.readLine();
        }
        return Long.parseLong(line);
    }

    private boolean isValidNumber(String line) {
        try {
            long l = Long.parseLong(line);
            return l >= 0L && l <= 4294967295L;
        } catch (Exception e) {
            return false;
        }
    }
}
