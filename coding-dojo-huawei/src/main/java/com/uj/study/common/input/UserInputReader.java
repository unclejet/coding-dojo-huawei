package com.uj.study.common.input;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/1/26 上午11:41
 * @description：
 */
public abstract class UserInputReader {
    protected LineReader lineReader;

    public UserInputReader(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    protected boolean isInteger(String inputStr) {
        try {
            Integer.parseInt(inputStr);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    protected boolean isLong(String inputStr) {
        try {
            Long.parseLong(inputStr);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    protected int getInteger(String inputStr) {
        try {
            return Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
