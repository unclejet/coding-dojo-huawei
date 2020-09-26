package com.uj.study.common.input;

/**
 * @author ：unclejet
 * @date ：Created in 2020/9/26 上午7:40
 * @description：
 * @modified By：
 * @version:
 */
public class BaseUserInputReader {
    protected LineReader lineReader;

    public BaseUserInputReader(LineReader lineReader) {
        this.lineReader = lineReader;
    }
}
