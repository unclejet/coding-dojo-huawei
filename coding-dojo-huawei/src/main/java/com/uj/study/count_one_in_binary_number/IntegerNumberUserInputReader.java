package com.uj.study.count_one_in_binary_number;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/22 上午11:41
 * @description：
 */
public class IntegerNumberUserInputReader extends UserInputReader {
    public IntegerNumberUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public int readInteger() {
        String line = lineReader.readLine();
        while (!isInteger(line)) {
            System.out.println("Please input a integer: ");
            line = lineReader.readLine();
        }
        return Integer.parseInt(line);
    }
}
