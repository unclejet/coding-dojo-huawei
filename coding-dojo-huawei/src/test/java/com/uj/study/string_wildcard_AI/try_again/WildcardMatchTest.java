package com.uj.study.string_wildcard_AI.try_again;

import com.uj.study.string_wildcard_AI.new_fitten_code.TextMatcher;
import org.junit.jupiter.api.Test;

import static com.uj.study.string_wildcard_AI.try_again.WildcardMatcher.matched;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WildcardMatchTest {



    @Test
    void one_regex_alNum() {
        //匹配字母和数字
        assertTrue(matched("a", "a"));
        assertTrue(matched("0", "0"));
        assertFalse(matched("a", "ab"));

        //匹配非字母和数字
        assertTrue(matched("#", "#"));

        //匹配不区分大小写
        assertTrue(matched("A", "a"));
        assertTrue(matched("a", "A"));
    }

    @Test
    void one_regex_asterisk() {
        // 匹配0个字符
        assertTrue(matched("*", ""));

        // 匹配1个及以上的字符
        assertTrue(matched("*", "t"));
        assertTrue(matched("*", "0"));
        assertTrue(matched("*", "text"));
        assertTrue(matched("*", "123"));

        // 只能匹配英文字母和数字
        assertFalse(matched("*", "#"));
        assertFalse(matched("*", " "));

        // 匹配不区分大小写
        assertTrue(matched("*", "aA"));
    }

    @Test
    void one_regex_questionMark() {
        // 匹配1个字符
        assertTrue(matched("?", "a"));
        assertFalse(matched("?", "ab"));
        assertFalse(matched("?", ""));
        //只能匹配英文字母和数字
        assertTrue(matched("?", "0"));
        assertFalse(matched("?", " "));
        assertFalse(matched("?", "#"));
        //不区分大小写
        assertTrue(matched("?", "A"));
    }


    @Test
    void mixed_regex() {
        // 匹配字母和数字
        assertFalse(matched("a*b?c", "abc"));
        assertTrue(matched("a*b?c", "ab0c"));
        assertFalse(matched("te?t*.*", "txt12.xls"));
        assertTrue(matched("te?t*.*", "text12.xls"));
        assertFalse(matched("z", "zz"));
        assertFalse(matched("pq", "pppq"));
        assertTrue(matched("**Z", "0QZz"));
        assertTrue(matched("?*Bc*?", "abcd"));
        assertFalse(matched("h*?*a", "h#a"));
        assertFalse(matched("p*p*qp**pq*p**p***ppq", "pppppppqppqqppqppppqqqppqppqpqqqppqpqpppqpppqpqqqpqqp"));
    }

    @Test
    void two_regex_alpha() {
        assertTrue(matched("#@", "#@"));
        assertTrue(matched("ab", "ab"));
        assertTrue(matched("0c", "0c"));
        assertTrue(matched("Ab", "aB"));
        assertFalse(matched("Ab", "BA"));
    }

    @Test
    void two_regex_asterisk() {
        // 两个星号
        // 匹配0个字符
        assertTrue(matched("**", ""));

        // 匹配1个及以上的字母或数字
        assertTrue(matched("**", "t"));
        assertTrue(matched("**", "tt"));
        assertTrue(matched("**", "text"));
        assertTrue(matched("**", "te01"));
        assertTrue(matched("**", "0"));
        assertTrue(matched("**", "00"));
        assertTrue(matched("**", "000"));

        // 只能匹配英文字母和数字
        assertFalse(matched("**", "#"));
        assertFalse(matched("**", "##"));
        assertFalse(matched("**", " "));

        // 匹配不区分大小写
        assertTrue(matched("**", "AB"));

        //一个星号，一个字母
        // 匹配0个字符
        assertFalse(matched("*a", ""));
        assertFalse(matched("a*", ""));
        // 匹配1个及以上的字母或数字
        assertTrue(matched("*a", "a"));
        assertTrue(matched("a*", "a"));
        assertFalse(matched("*a", "b"));
        assertFalse(matched("a*", "b"));
        assertTrue(matched("*a", "ba"));
        assertTrue(matched("a*", "ab"));
        assertFalse(matched("*a", "ab"));
        assertFalse(matched("a*", "ba"));
        assertTrue(matched("*a", "cba"));
        assertTrue(matched("a*", "abc"));
        assertFalse(matched("*a", "cab"));
        // 匹配不区分大小写
        assertTrue(matched("*a", "BA"));
        assertTrue(matched("A*", "a"));
        assertTrue(matched("a*", "A"));
        //只能匹配字母和数字
        assertTrue(matched("1*", "1"));
        assertFalse(matched("*a", "#a"));
        assertFalse(matched("a*", "a#"));
        assertTrue(matched("*#", "#"));
        assertTrue(matched("*#", "a#"));
        assertTrue(matched("*#", "aa#"));
        assertTrue(matched("*a", "a"));
        assertTrue(matched("*a", "bca"));
        assertTrue(matched("#*", "#"));
    }

    @Test
    void two_regex_questionMark() {
        // 两个问号
        assertFalse(matched("??", ""));
        assertFalse(matched("??", "a"));
        assertTrue(matched("??", "ab"));
        assertTrue(matched("??", "aB"));
        assertTrue(matched("??", "a0"));
        assertFalse(matched("??", "ab0"));
        assertFalse(matched("??", "a#"));
        assertFalse(matched("??", "*a"));

        // 一个问号，一个字母
        assertFalse(matched("?a", ""));
        assertFalse(matched("?a", "a"));
        assertTrue(matched("?a", "ba"));
        assertTrue(matched("?a", "bA"));
        assertFalse(matched("?a", "aab"));
        assertFalse(matched("?a", "ab"));
        assertFalse(matched("a?", "a"));
        assertFalse(matched("a?", "a&"));
        assertFalse(matched("a?", "b"));
        assertTrue(matched("a?", "ab"));
        assertTrue(matched("a?", "aB"));
    }

    @Test
    void three_regex_asterisk() {
        // 三个星号
        // 匹配0个字符
        assertTrue(matched("***", ""));
        // 匹配1个及以上的字母或数字
        assertTrue(matched("***", "t"));
        assertTrue(matched("***", "tt"));
        assertTrue(matched("***", "text"));
        assertTrue(matched("***", "te01"));
        assertTrue(matched("***", "0"));
        assertTrue(matched("***", "00"));
        assertTrue(matched("***", "000"));
        // 匹配不区分大小写
        assertTrue(matched("***", "AB"));
        // 匹配多个字符
        assertTrue(matched("***", "abc"));
        assertTrue(matched("***", "123"));
        assertTrue(matched("***", "abc123"));
        // 匹配不区分大小写
        assertTrue(matched("***", "ABc123"));
        // 匹配多个字符
        assertTrue(matched("***", "abc123"));
        // 匹配不区分大小写
        assertTrue(matched("***", "ABc123"));
        // 匹配多个字符
        assertTrue(matched("***", "abc123"));


        // 匹配多个字符
        assertFalse(matched("*ab", "abc123"));
        assertTrue(matched("*ab", "ab"));
        assertTrue(matched("*ab", "cab"));
        assertFalse(matched("*ab", "&ab"));
        assertFalse(matched("a*b", "abc123"));
        assertTrue(matched("a*b", "ab"));
        assertTrue(matched("a*b", "acb"));
        assertFalse(matched("a*b", "a&b"));
        assertTrue(matched("ab*", "abc123"));
        assertTrue(matched("ab*", "ab"));
        assertTrue(matched("ab*", "abc"));
        assertFalse(matched("ab*", "ab&"));
    }

    @Test
    void three_regex_questionMark() {
        // 三个问号
        // 匹配0个字符
        assertFalse(matched("???", ""));
        assertFalse(matched("???", "a"));
        assertFalse(matched("???", "ab"));
        assertTrue(matched("???", "ab0"));
        assertTrue(matched("???", "abc"));
        assertTrue(matched("???", "aBc"));
        assertTrue(matched("???", "abC"));
        assertTrue(matched("???", "a0c"));
        assertFalse(matched("???", "ab0c"));
        assertTrue(matched("???", "a0C"));
        assertFalse(matched("???", "a#c"));
        assertFalse(matched("???", "*a"));
        // 匹配不区分大小写
        assertTrue(matched("???", "ABc"));
        assertTrue(matched("???", "aBc"));
        assertTrue(matched("???", "abC"));
        assertTrue(matched("???", "a0c"));
        assertFalse(matched("???", "ab0c"));
        assertTrue(matched("???", "a0C"));
        assertFalse(matched("???", "ab0C"));
        assertFalse(matched("???", "a#c"));
        assertFalse(matched("???", "*a"));
        // 匹配多个字符
        assertTrue(matched("?bc", "abc"));
        assertFalse(matched("?bc", "abcd"));
        assertFalse(matched("?bc", "abd"));
        assertTrue(matched("b?c", "bDc"));
        assertFalse(matched("b?c", "bc"));
        assertFalse(matched("b?c", "b#c"));
        assertFalse(matched("bc?", "bc"));
        assertFalse(matched("bc?", "Abc"));
        assertTrue(matched("bc?", "bcD"));
    }



}
