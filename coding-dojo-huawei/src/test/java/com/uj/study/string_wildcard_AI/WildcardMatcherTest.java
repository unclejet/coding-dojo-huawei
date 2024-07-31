package com.uj.study.string_wildcard_AI;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.uj.study.string_wildcard_AI.StringMatcher.matched;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**

 In computing, wildcards are a special syntax widely used in file searching, databases, and regular expressions. You are now required to implement an algorithm for string matching with wildcards.

 Requirements:
 Implement the following two wildcards:
 *: Matches 0 or more characters (Note: characters that can be matched by * and ? consist only of English letters and digits 0-9, same below)
 ?: Matches exactly 1 character
 Note: Matching is case-insensitive.

 Input:
 A wildcard expression;
 A string to match.

 Output:
 Return the case-insensitive matching result, outputting true if matched successfully, and false if not.
 Data range: String length: 1 ≤ s ≤ 100


 * * @author ：UncleJet
 *  * @date ：Created in 2024/3/28 下午12:44
 *  * @description： 描述
 *  * <p>
 *  * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 *  * 要求：
 *  * 实现如下2个通配符：
 *  * *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
 *  * ？：匹配1个字符
 *  * 注意：匹配时不区分大小写。
 *  * <p>
 *  * 输入：
 *  * 通配符表达式；
 *  * 一组字符串。
 *  * <p>
 *  * 输出：
 *  * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 *  * 数据范围：字符串长度：1≤s≤100 1≤s≤100
 *  * 进阶：时间复杂度：O(n2) O(n2) ，空间复杂度：O(n) O(n)
 *  * 输入描述：
 *  * <p>
 *  * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 *  * 输出描述：
 *  * <p>
 *  * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 *  * 示例1
 *  * 输入：
 *  * <p>
 *  * te?t*.*
 *  * txt12.xls
 *  * <p>
 *  * 输出：
 *  * <p>
 *  * false
 *  * <p>
 *  * 示例2
 *  * 输入：
 *  * <p>
 *  * z
 *  * zz
 *  * <p>
 *  * 输出：
 *  * <p>
 *  * false
 *  * <p>
 *  * 示例3
 *  * 输入：
 *  * <p>
 *  * pq
 *  * pppq
 *  * <p>
 *  * 输出：
 *  * <p>
 *  * false
 *  * <p>
 *  * 示例4
 *  * 输入：
 *  * <p>
 *  * **Z
 *  * 0QZz
 *  * <p>
 *  * 输出：
 *  * <p>
 *  * true
 *  * <p>
 *  * 示例5
 *  * 输入：
 *  * <p>
 *  * ?*Bc*?
 *  * abcd
 *  * <p>
 *  * 输出：
 *  * <p>
 *  * true
 *  * <p>
 *  * 示例6
 *  * 输入：
 *  * <p>
 *  * h*?*a
 *  * h#a
 *  * <p>
 *  * 输出：
 *  * <p>
 *  * false
 *  * <p>
 *  * 说明：
 *  * <p>
 *  * 根据题目描述可知能被*和?匹配的字符仅由英文字母和数字0到9组成，所以?不能匹配#，故输出false
 *  * <p>
 *  * 示例7
 *  * 输入：
 *  * <p>
 *  * p*p*qp**pq*p**p***ppq
 *  * pppppppqppqqppqppppqqqppqppqpqqqppqpqpppqpppqpqqqpqqp
 *  * <p>
 *  * 输出：
 *  * <p>
 *  * false
 */
public class WildcardMatcherTest {
    @Test
    void mixed_regex() {
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
    void one_regex_aplha() {
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


}
