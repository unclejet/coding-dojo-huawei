package com.uj.study.common_substring_computation;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 描述
 * <p>
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 * 数据范围：字符串长度：1≤s≤150 1≤s≤150
 * 进阶：时间复杂度：O(n3) O(n3) ，空间复杂度：O(n) O(n)
 * 输入描述：
 * <p>
 * 输入两个只包含小写字母的字符串
 * 输出描述：
 * <p>
 * 输出一个整数，代表最大公共子串的长度
 * 示例1
 * 输入：
 * <p>
 * asdfas
 * werasdfaswer
 * <p>
 * 输出：
 * <p>
 * 6
 */
public class CSCTest {
    @Test
    void one_char_test() {
        String s1 = "a";
        String s2 = "b";
        int result = CSCTest.commonSubString(s1, s2);
        assertThat(result, is(0));
        s2 = "a";
        result = CSCTest.commonSubString(s1, s2);
        assertThat(result, is(1));
    }

    @Test
    void two_char_test() {
        String s1 = "ab";
        String s2 = "cd";
        int result = CSCTest.commonSubString(s1, s2);
        assertThat(result, is(0));
        s2 = "cb";
        result = CSCTest.commonSubString(s1, s2);
        assertThat(result, is(1));
        s2 = "ac";
        result = CSCTest.commonSubString(s1, s2);
        assertThat(result, is(1));
        s2 = "ab";
        result = CSCTest.commonSubString(s1, s2);
        assertThat(result, is(2));
    }

    @Test
    void common_substring_test() {
        String s1 = "asdfas";
        String s2 = "werasdfaswer";
        int result = CSCTest.commonSubString(s1, s2);
        assertThat(result, is(6));
    }


    public static int commonSubString(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }


}
