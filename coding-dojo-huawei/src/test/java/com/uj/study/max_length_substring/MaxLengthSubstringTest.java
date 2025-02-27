package com.uj.study.max_length_substring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 描述
 * 对于给定的由小写字母构成的字符串 ss，求出其最长回文子串的长度。
 *
 * 子串为从原字符串中，连续的选择一段字符（可以全选、可以不选）得到的新字符串。
 * 一个字符串被称作回文串，当且仅当这个字符串从左往右读和从右往左读是相同的。
 * 输入描述：
 * 在一行上输入一个长度为 1≦len(s)≦3501≦len(s)≦350、仅由小写字母构成的字符串 ss。
 * 输出描述：
 * 输出一个整数，表示字符串 ss 的最长回文子串的长度。
 * 示例1
 * 输入：
 *
 * cdabbacc
 *
 * 输出：
 *
 * 4
 *
 * 说明：
 *
 * 在这个样例中，"cdabbacc" 是最长的回文子串。
 *
 * 示例2
 * 输入：
 *
 * a
 *
 * 输出：
 *
 * 1
 */
public class MaxLengthSubstringTest {
    @Test
    void length_1() {
        String input = "a";
        int actual = length(input);
        Assertions.assertEquals(1, actual);
    }

    @Test
    void length_2() {
        String input = "ab";
        Assertions.assertEquals(0, length(input));
        input = "aa";
        Assertions.assertEquals(2, length(input));
    }

    @Test
    void length_3() {
        String input = "abc";
        Assertions.assertEquals(0, length(input));
        input = "abb";
        Assertions.assertEquals(2, length(input));
        input = "aaa";
        Assertions.assertEquals(3, length(input));
        input = "aba";
        Assertions.assertEquals(3, length(input));
    }

    @Test
    void length_random() {
        String input = "cdabbacc";
        Assertions.assertEquals(4, length(input));
    }

//    private int length(String input) {
//        int len = input.length();
//
//        if (len == 1) {
//            return 1;
//        }
//
//        int maxLen = 1;  // 初始化为1，因为单个字符也是回文串
//
//        // 检查长度为2的子串
//        for (int i = 0; i < len - 1; i++) {
//            if (input.charAt(i) == input.charAt(i + 1)) {
//                maxLen = 2;
//            }
//        }
//
//        // 检查长度大于2的子串
//        for (int i = 1; i < len - 1; i++) {
//            // 检查奇数长度的回文串，以i为中心
//            int left = i - 1;
//            int right = i + 1;
//            while (left >= 0 && right < len && input.charAt(left) == input.charAt(right)) {
//                maxLen = Math.max(maxLen, right - left + 1);
//                left--;
//                right++;
//            }
//
//            // 检查偶数长度的回文串，以i和i+1为中心
//            left = i;
//            right = i + 1;
//            while (left >= 0 && right < len && input.charAt(left) == input.charAt(right)) {
//                maxLen = Math.max(maxLen, right - left + 1);
//                left--;
//                right++;
//            }
//        }
//
//        // 如果没有找到任何回文串（长度为1除外），返回0
//        return maxLen == 1 && len > 1 ? 0 : maxLen;
//    }

    private int length(String input) {
        int len = input.length();
        if (len < 2) {
            return len;
        }

        // dp[i][j] 表示子串 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;

        // 所有长度为1的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 检查所有可能的子串
        for (int length = 2; length <= len; length++) {
            for (int start = 0; start <= len - length; start++) {
                int end = start + length - 1;

                // 如果子串长度为2，只需要检查两个字符是否相同
                if (length == 2) {
                    dp[start][end] = (input.charAt(start) == input.charAt(end));
                } else {
                    // 否则，检查首尾字符是否相同，且中间的子串是否为回文
                    dp[start][end] = (input.charAt(start) == input.charAt(end))
                            && dp[start + 1][end - 1];
                }

                // 如果找到回文串，更新最大长度
                if (dp[start][end]) {
                    maxLen = Math.max(maxLen, length);
                }
            }
        }

        return maxLen;
    }
}
