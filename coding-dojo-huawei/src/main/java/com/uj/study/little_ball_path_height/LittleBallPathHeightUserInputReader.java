package com.uj.study.little_ball_path_height;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/17 下午12:09
 * @description：
 */
public class LittleBallPathHeightUserInputReader extends ValidLineReader {
    public LittleBallPathHeightUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public int readHeight() {
        return Integer.parseInt(readValidLine("please input number between 1 and 1000"));
    }

    @Override
    protected boolean isValidString(String line) {
        try {
            int h = Integer.parseInt(line);
            return h >= 1 && h <= 1000;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
