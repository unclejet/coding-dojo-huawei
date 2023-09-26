package com.uj.study.yanghui_triangle;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/9/25 下午12:54
 * @description：
 */
public class YangHuiTriangleUserInputReader extends ValidLineReader {
    public YangHuiTriangleUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    @Override
    protected boolean isValidString(String line) {
        try {
            int n = Integer.parseInt(line);
            return n >= 1 && n <= 109;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int readRowNumber() {
        return getInteger(readValidLine("please input number between 1<=n<=109"));
    }
}
