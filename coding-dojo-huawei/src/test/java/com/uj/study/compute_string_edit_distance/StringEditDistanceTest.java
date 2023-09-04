package com.uj.study.compute_string_edit_distance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.uj.study.compute_string_edit_distance.StringEditDistance.calculate;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/28 下午12:35
 * @description：
 * 描述
 *
 * Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。编辑距离的算法是首先由俄国科学家 Levenshtein 提出的，故又叫 Levenshtein Distance 。
 *
 * 例如：
 *
 * 字符串A: abcdefg
 *
 * 字符串B: abcdef
 *
 * 通过增加或是删掉字符 ”g” 的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
 *
 * 要求：
 * 给定任意两个字符串，写出一个算法计算它们的编辑距离。
 *
 * 数据范围：给定的字符串长度满足 1≤len(str)≤1000 1≤len(str)≤1000
 *
 *
 *
 * 输入描述：
 *
 * 每组用例一共2行，为输入的两个字符串
 * 输出描述：
 *
 * 每组用例输出一行，代表字符串的距离
 * 示例1
 * 输入：
 *
 * abcdefg
 * abcdef
 *
 * 输出：
 *
 * 1
 *
 * 替换
 * 插入
 * 删除
 */
public class StringEditDistanceTest {
    @Test
    void one_letter() {
        assertThat(calculate("a", "b"), is(1));
        assertThat(calculate("a", "a"), is(0));
    }

    @Test
    void two_letter() {
        assertThat(calculate("ab", "bb"), is(1));
        assertThat(calculate("ab", "b"), is(1));
    }

    @Test
    void more_letter() {
        assertThat(calculate("abc", "abc"), is(0));
        assertThat(calculate("abc", "ab"), is(1));
        assertThat(calculate("abc", "ac"), is(1));
        assertThat(calculate("abc", "bc"), is(1));
        assertThat(calculate("abb", "ab"), is(1));
        assertThat(calculate("aaa", "a"), is(2));
        assertThat(calculate("bba", "ab"), is(2));

        assertThat(calculate("abbc", "ab"), is(2));
        assertThat(calculate("bbbabbb", "a"), is(6));
        assertThat(calculate("abcdefg", "abcdef"), is(1));

    }
}