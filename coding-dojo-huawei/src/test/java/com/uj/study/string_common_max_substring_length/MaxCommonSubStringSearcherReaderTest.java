package com.uj.study.string_common_max_substring_length;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/22 下午12:49
 * @description：
 * * 数据范围：字符串长度1≤length≤300 1≤length≤300
 *  * 进阶：时间复杂度：O(n3) O(n3) ，空间复杂度：O(n) O(n)
 *  * 输入描述：
 *  *
 *  * 输入两个字符串
 *  * 输出描述：
 *  * 返回重复出现的字符
 *  * 示例1
 *  * 输入：
 *  *
 *  * abcdefghijklmnop
 *  * abcsafjklmnopqrstuvw
 *  *
 *  * 输出：
 *  *
 *  * jklmnop
 */
public class MaxCommonSubStringSearcherReaderTest extends BaseUserInputReaderTest {
    private MaxCommonSubStringSearcherReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new MaxCommonSubStringSearcherReader(lineReaderStub);
    }

    @Test
    void readString_valid() {
        lineReaderStub.simulateUserInputs("", RandomAlphabetGenerator.generateRandomCharacters(301), "abcde");
        assertThat(reader.readString(), is("abcde"));
    }
}
