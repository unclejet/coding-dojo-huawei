package com.uj.study.sort_string;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/1/24 下午12:44
 * @description：
 */
public class SortStringsInputReader extends UserInputReader {
    public SortStringsInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public String readLine() {
        String line = lineReader.readLine();
        while (!isValidString(line)) {
            System.out.println("Please input alpha string and length <= 1000 : ");
            line = lineReader.readLine();
        }
        return line;
    }

    private boolean isValidString(String line) {
        return line.length() <= 1000;
    }
}
