package com.uj.study.extract.nonrepeat.integer;

import com.uj.study.common.utils.LineReaderStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：unclejet
 * @date ：Created in 2020/8/10 上午7:13
 * @description：
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 *
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入
 * 复制
 * 9876673
 * 输出
 * 复制
 * 37689
 * @modified By：
 * @version:
 */
public class UserInputReaderTest {
    private LineReaderStub lineReaderStub;
    private UserInputReader userInputReader;

    @BeforeEach
    void setUp() {
        lineReaderStub = new LineReaderStub();
        userInputReader = new UserInputReader(lineReaderStub);
    }

    @Test
    void inputMustBeInteger() {
        lineReaderStub.simulateUserInputs("1", String.valueOf(Integer.MAX_VALUE), String.valueOf(Integer.MIN_VALUE));
        assertThat(userInputReader.readInteger(), is(1));
        assertThat(userInputReader.readInteger(), is(Integer.MAX_VALUE));
        assertThat(userInputReader.readInteger(), is(Integer.MIN_VALUE));
    }
}
