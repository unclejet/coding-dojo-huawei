package com.uj.study.delete_shortest_char_in_string;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/9/17 下午12:20
 * @description：
 * 描述
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开
 * 输入描述：
 *
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * 输出描述：
 *
 * 删除字符串中出现次数最少的字符后的字符串。
 * 示例1
 * 输入：
 *
 * abcdd
 * aabcddd
 *
 * 输出：
 *
 * dd
 * aaddd
 */
public class UserInputReaderTest extends BaseUserInputReaderTest {
    ShortestStringReader reader;
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new ShortestStringReader(lineReaderStub);
    }

    @Test
    void inputLowercaseAndGetIt() {
        lineReaderStub.simulateUserInputs("abc", "deff", "q");
        assertThat(reader.readStrings(), contains("abc" ,"deff"));
    }

    @Test
    void inputShouldBeLowercase() {
        lineReaderStub.simulateUserInputs("abc", "dAF", "deff", "q");
        assertThat(reader.readStrings(), contains("abc", "daf" ,"deff"));
    }

    @Test
    void inputEmpty() {
        lineReaderStub.simulateUserInputs("", "q");
        assertThat(reader.readStrings(), contains(""));
    }

    @Test
    void inputShouldLessThan20() {
        String str19 = RandomAlphabetGenerator.generateRandomLowercaseCharacters(19);
        String str20 = RandomAlphabetGenerator.generateRandomLowercaseCharacters(20);
        String str21 = RandomAlphabetGenerator.generateRandomLowercaseCharacters(21);
        lineReaderStub.simulateUserInputs(str19, str20, str21, "q");
        assertThat(reader.readStrings(), contains(str19, str20));
    }
}
