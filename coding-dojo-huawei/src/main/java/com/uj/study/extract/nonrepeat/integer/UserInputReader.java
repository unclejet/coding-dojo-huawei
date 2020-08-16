package com.uj.study.extract.nonrepeat.integer;

import com.uj.study.common.input.LineReader;

/**
 * @author ：unclejet
 * @date ：Created in 2020/8/10 上午7:23
 * @description：
 * @modified By：
 * @version:
 */
public class UserInputReader {
    private LineReader lineReader;

    public UserInputReader(LineReader lineReader) {
        this.lineReader = lineReader;

    }

    public int readInteger() {
        boolean isInteger = false;
        int result = 0;
        while (!isInteger) {
            try {
                result = Integer.parseInt(lineReader.readLine());
                isInteger = true;
            } catch (NumberFormatException e) {
                System.out.println("please input a integer:");
            }
        }
        return result;
    }
}
