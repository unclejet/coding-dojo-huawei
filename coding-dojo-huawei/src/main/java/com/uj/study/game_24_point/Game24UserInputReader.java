package com.uj.study.game_24_point;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.Arrays;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/2/2 下午12:50
 * @description：
 */
public class Game24UserInputReader extends ValidLineReader {
    public Game24UserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        String[] sArr = line.split("\\s");
        return sArr.length == 4 &&
                !Arrays.stream(line.split("\\p{Space}")).anyMatch(s->isInvalid(s));
        }

    private boolean isInvalid(String s) {
        int n = getInteger(s);
        return !isInteger(s) || n < 1 || n > 10;
    }

    public int[] readNumber() {
        String line = readValidLine("please input 4 number >= 1 && <= 10:");
        return StrArr2IntArr(line);
    }

    private int[] StrArr2IntArr(String line) {
        try {
            return Arrays.stream(line.split("\\p{Space}")).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            return null;
        }
    }
}
