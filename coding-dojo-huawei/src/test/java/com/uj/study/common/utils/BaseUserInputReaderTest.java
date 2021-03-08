package com.uj.study.common.utils;

import org.junit.jupiter.api.BeforeEach;


/**
 * @author ：unclejet
 * @date ：Created in 2020/9/26 上午6:57
 * @description：
 * @modified By：
 * @version:
 */
public class BaseUserInputReaderTest {
    protected LineReaderStub lineReaderStub;

    @BeforeEach
    protected void setUp() {
        lineReaderStub = new LineReaderStub();
    }
}
