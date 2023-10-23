package com.uj.study.high_precision_integer_add;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/23 下午12:40
 * @description：
 * * 输入两个用字符串 str 表示的整数，求它们所表示的数之和。
 *  * <p>
 *  * 数据范围： 1≤len(str)≤10000 1≤len(str)≤10000
 *  * 输入描述：
 *  * <p>
 *  * 输入两个字符串。保证字符串只含有'0'~'9'字符
 */
public class HighPrecisionIntegerReaderTest extends BaseUserInputReaderTest {
    HighPrecisionIntegerReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new HighPrecisionIntegerReader(lineReaderStub);
    }

    @Test
    void formatValid() {
        lineReaderStub.simulateUserInputs("", " ", "a","%^","-1","9090");
        assertThat(reader.readNumString(), is("9090"));
    }

    @Test
    void lengthValid() {
        lineReaderStub.simulateUserInputs(RandomAlphabetGenerator.generateRandomNumbers(10001), "9999");
        assertThat(reader.readNumString(), is("9999"));
    }
}
