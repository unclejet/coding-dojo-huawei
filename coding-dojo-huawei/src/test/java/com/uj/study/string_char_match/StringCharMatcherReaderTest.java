package com.uj.study.string_char_match;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * * 输入描述：
 * * 第一行输入一个长度为 1≦len(s)≦2001≦len(s)≦200、仅由小写字母组成的字符串 ss。
 * * 第二行输入一个长度为 1≦len(t)≦2001≦len(t)≦200、仅由小写字母组成的字符串 tt。
 */
public class StringCharMatcherReaderTest extends BaseUserInputReaderTest {
    StringCharMatcherReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new StringCharMatcherReader(lineReaderStub);
    }

    @Test
    public void length() {
        lineReaderStub.simulateUserInputs("", " ", "   ", "a");
        assertThat(reader.readString(), is("a"));
        String input201 = RandomAlphabetGenerator.generateRandomLowercaseCharacters(201);
        String input200 = RandomAlphabetGenerator.generateRandomLowercaseCharacters(200);
        lineReaderStub.simulateUserInputs(input201, input200,"abc");
        assertThat(reader.readString(), is(input200));
    }

    @Test
    void only_lowercase_characters() {
        lineReaderStub.simulateUserInputs( "Ghi", "jkl");
        assertThat(reader.readString(), is("jkl"));
    }
}
