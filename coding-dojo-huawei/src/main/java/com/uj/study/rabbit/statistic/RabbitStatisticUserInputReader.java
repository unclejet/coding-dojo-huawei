package com.uj.study.rabbit.statistic;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/14 下午12:18
 * @description：
 */
public class RabbitStatisticUserInputReader extends ValidLineReader {
    public RabbitStatisticUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        try {
            int number = Integer.parseInt(line);
            return number >= 1 && number <= 31;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int readMonth() {
        return Integer.parseInt(super.readValidLine("please input month between 1 and 31"));
    }
}
