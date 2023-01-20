package com.uj.study.study_english;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午8:55
 * @description：
 */
public class StudyEnglishUserInputReader extends ValidLineReader {
    public StudyEnglishUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public String readNumber() {
        return super.readValidLine("Please input number between 0 and 999,999,999,999");
    }

    @Override
    protected boolean isValidString(String line) {
        if (isLong(line)) {
            long i = Long.parseLong(line);
            return i >= 0 && line.toCharArray().length <= 12;
        }

        return false;
    }
}
