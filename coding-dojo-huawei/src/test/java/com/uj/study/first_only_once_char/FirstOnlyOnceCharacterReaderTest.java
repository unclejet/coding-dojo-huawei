package com.uj.study.first_only_once_char;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/27 下午12:48
 * @description：
 * * 数据范围：输入的字符串长度满足 1≤n≤1000 1≤n≤1000
 *  *
 *  *
 *  * 输入描述：
 *  *
 *  * 输入一个非空字符串
 *   * 示例1
 *  * 输入：
 *  *
 *  * asdfasdfo
 *  *
 *  * 输出：
 *  *
 *  * o
 */
public class FirstOnlyOnceCharacterReaderTest extends BaseUserInputReaderTest {
    private FirstOnlyOnceCharacterReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new FirstOnlyOnceCharacterReader(lineReaderStub);
    }

    @Test
    void string_length() {
        lineReaderStub.simulateUserInputs(RandomAlphabetGenerator.generateRandomCharacters(1001), "", "asdfasdfo");
        assertThat(reader.readString(), is("asdfasdfo"));
    }

    @Test
    void not_empty() {
        lineReaderStub.simulateUserInputs(" ", "   ", "", "asdfasdfo");
        assertThat(reader.readString(), is("asdfasdfo"));
    }
}
