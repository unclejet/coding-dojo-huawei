package com.uj.study.string_char_match;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



/**
 * 描述
 * 对于给定的字符串 ss 和 tt，检查 ss 中的所有字符是否都在 tt 中出现。
 * 输入描述：
 * 第一行输入一个长度为 1≦len(s)≦2001≦len(s)≦200、仅由小写字母组成的字符串 ss。
 * 第二行输入一个长度为 1≦len(t)≦2001≦len(t)≦200、仅由小写字母组成的字符串 tt。
 * 输出描述：
 * 如果 ss 中的所有字符都在 tt 中出现，则输出 truetrue，否则输出 falsefalse。
 * 示例1
 * 输入：
 *
 * bc
 * abc
 *
 * 输出：
 *
 * true
 */
public class StringCharMatcherTest {
    @Test
    void nothing() {

    }

    @Test
    void one_s_one_t() {
        String s = "b";
        String t = "a";
        Assertions.assertFalse(match(s, t));
        t = "b";
        Assertions.assertTrue(match(s, t));
    }

    @Test
    void one_s_two_t() {
        String s = "b";
        String t = "ab";
        Assertions.assertTrue(match(s, t));
        t = "cd";
        Assertions.assertFalse(match(s, t));
    }

    @Test
    void two_s_one_t() {
        String s = "bc";
        String t = "a";
        Assertions.assertFalse(match(s, t));
        t = "b";
        Assertions.assertFalse(match(s, t));
    }

    @Test
    void mixed() {
        String s = "bc";
        String t = "abc";
        Assertions.assertTrue(match(s, t));
        s = "bcd";
        Assertions.assertFalse(match(s, t));
    }


    private boolean match(String s, String t) {
        int tIndex = 0;
        for (char c : s.toCharArray()) {
            tIndex = t.indexOf(c, tIndex);
            if (tIndex == -1) {
                return false;
            }
            tIndex++; // Move to the next character in t
        }
        return true;
    }
}
