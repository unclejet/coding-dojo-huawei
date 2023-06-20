package com.uj.study.cut_string;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/6/19 下午12:46
 * @description：
 * 描述
 * 输入一个字符串和一个整数 k ，截取字符串的前k个字符并输出
 *
 * 数据范围：字符串长度满足 1≤n≤1000 1≤n≤1000  ， 1≤k≤n 1≤k≤n
 * 输入描述：
 *
 * 1.输入待截取的字符串
 *
 * 2.输入一个正整数k，代表截取的长度
 * 输出描述：
 *
 * 截取后的字符串
 * 示例1
 * 输入：
 *
 * abABCcDEF
 * 6
 *
 * 输出：
 *
 * abABCc
 *
 * 示例2
 * 输入：
 *
 * bdxPKBhih
 * 6
 *
 * 输出：
 *
 * bdxPKB
 */
public class StringCutterTest {
    @Test
    void cutString() {
        assertThat(StringCutter.cutString("abABCcDEF", 6), is("abABCc"));
        assertThat(StringCutter.cutString("bdxPKBhih", 6), is("bdxPKB"));
    }
}
