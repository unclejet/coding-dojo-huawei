package com.uj.study.string.split;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 *
 * 输出描述:
 * 输出到长度为8的新字符串数组
 *
 * 示例1
 * 输入
 * abc
 * 123456789
 *
 * 输出
 * abc00000
 * 12345678
 * 90000000
 */
public class StringSplitTest {
    @Test
    void splitString_8character() {
        String[] userReader = {"abcdefgh", "12345678"};
        List<String> actual = StringSplit.splitString(userReader);
        assertThat(actual.size(), is(2));
        assertThat(actual.get(0), is("abcdefgh"));
        assertThat(actual.get(1), is("12345678"));
    }

    @Test
    void splitString_emptyInput() {
        String[] userReader = {"", ""};
        List<String> actual = StringSplit.splitString(userReader);
        assertThat(actual.size(), is(2));
        assertThat(actual.get(0), is("00000000"));
        assertThat(actual.get(1), is("00000000"));
    }

    @Test
    void splitString_oneEmptyInput() {
        String[] userReader = {"a", ""};
        List<String> actual = StringSplit.splitString(userReader);
        assertThat(actual.size(), is(2));
        assertThat(actual.get(0), is("a0000000"));
        assertThat(actual.get(1), is("00000000"));
    }

    @Test
    void splitString_oneBlankInput() {
        String[] userReader = {"a", "  "};
        List<String> actual = StringSplit.splitString(userReader);
        assertThat(actual.size(), is(2));
        assertThat(actual.get(0), is("a0000000"));
        assertThat(actual.get(1), is("  000000"));
    }

    @Test
    void splitString() {
        String[] userReader = {"abc", "123456789"};
        List<String> actual = StringSplit.splitString(userReader);
        assertThat(actual.get(0), is("abc00000"));
        assertThat(actual.get(1), is("12345678"));
        assertThat(actual.get(2), is("90000000"));
    }
}


