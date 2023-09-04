package com.uj.study.compute_string_edit_distance;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * @author ：UncleJet
 * @date ：Created in 2023/9/1 下午12:50
 * @description：
 * 要求：
 *  * 给定任意两个字符串，写出一个算法计算它们的编辑距离。
 *  *
 *  * 数据范围：给定的字符串长度满足 1≤len(str)≤1000 1≤len(str)≤1000
 *  *
 *  *
 *  *
 *  * 输入描述：
 *  *
 *  * 每组用例一共2行，为输入的两个字符串
 *  * 输出描述：
 *  *
 *  * 每组用例输出一行，代表字符串的距离
 *  * 示例1
 *  * 输入：
 *  *
 *  * abcdefg
 *  * abcdef
 *  *
 */
public class StringEditDistanceReaderTest extends BaseUserInputReaderTest {
    StringEditDistanceUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new StringEditDistanceUserInputReader(lineReaderStub);
    }

    @Test
    void strLength() {
        lineReaderStub.simulateUserInputs("", RandomAlphabetGenerator.generateRandomCharacters(1001), "abc");
        assertThat(reader.readString(), is("abc"));
    }
}
