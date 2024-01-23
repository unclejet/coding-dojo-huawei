package com.uj.study.string_common_max_substring_length;

import org.junit.jupiter.api.Test;

import static com.uj.study.string_common_max_substring_length.MaxCommonSubStringSearcher.search;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/18 下午12:33
 * @description：
 * 描述
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！
 *
 * 数据范围：字符串长度1≤length≤300 1≤length≤300
 * 进阶：时间复杂度：O(n3) O(n3) ，空间复杂度：O(n) O(n)
 * 输入描述：
 *
 * 输入两个字符串
 * 输出描述：
 * 返回重复出现的字符
 * 示例1
 * 输入：
 *
 * abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 *
 * 输出：
 *
 * jklmnop
 */
public class MaxCommonSubStringLengthSearcherTest {
    @Test
    void no_same() {
        assertThat(search("a", "b"), is(""));
        assertThat(search("ab", "cd"), is(""));
    }

    @Test
    void one_same() {
        assertThat(search("a", "ab"), is("a"));
        assertThat(search("ab", "bc"), is("b"));
    }

    @Test
    void more_same() {
        assertThat(search("abcabcdeh", "cdabcdef"), is("abcde"));
        assertThat(search("abcdefghijklmnop", "abcsafjklmnopqrstuvw"), is("jklmnop"));
        assertThat(search("fs34fesdrr3sfdd", "fsd43rfsdfse"), is("fs"));
        assertThat(search("sf34sfsed3ds4s3rfdsfxde4e", "fdgr5gddr543rsf"), is("fd"));
    }
}
