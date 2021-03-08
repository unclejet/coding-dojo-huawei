package com.uj.study.sort_string_lines;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/5 下午1:43
 * @description：
 * 题目描述
 * 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入描述:
 *
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 *
 * 输出描述:
 *
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 *
 * 示例1
 * 输入
 * 复制
 *
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 *
 * 输出
 * 复制
 *
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 */
public class StringLineSorterTest {
    @Test
    void sortLines() {
        List<String> lines = Arrays.asList("cap", "to", "cat", "card", "two", "too", "up", "boat", "boot");
        assertThat(StringLineSorter.sort(lines).toString(), is("[boat, boot, cap, card, cat, to, too, two, up]"));
    }
}
