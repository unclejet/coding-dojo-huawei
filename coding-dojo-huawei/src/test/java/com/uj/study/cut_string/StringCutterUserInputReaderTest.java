package com.uj.study.cut_string;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/6/19 下午12:54
 * @description：
 * * 数据范围：字符串长度满足 1≤n≤1000 1≤n≤1000  ， 1≤k≤n 1≤k≤n
 *  * 输入描述：
 *  *
 *  * 1.输入待截取的字符串
 *  *
 *  * 2.输入一个正整数k，代表截取的长度
 *  * 输出描述：
 *  *
 *  * 截取后的字符串
 *  * 示例1
 *  * 输入：
 *  *
 *  * abABCcDEF
 *  * 6
 *  *
 *  * 输出：
 *  *
 *  * abABCc
 */
public class StringCutterUserInputReaderTest extends BaseUserInputReaderTest {
    StringCutterUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new StringCutterUserInputReader(lineReaderStub);
    }

    @Test
    void readValidString() {
        lineReaderStub.simulateUserInputs("", " ", RandomAlphabetGenerator.generateRandomCharacters(1001), "abc");
        assertThat(reader.readString(), is("abc"));
    }

    @Test
    void readValidNumber() {
        lineReaderStub.simulateUserInputs("0", "1001","49");
        assertThat(reader.readNumber(50), is(49));
    }
}
