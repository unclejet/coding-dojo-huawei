package com.uj.study.statistic_uppercase_count;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 描述
 * 对于给定的由可见字符和空格构成的字符串 ss，统计其中大写字母的个数。
 *
 * 字符串由 ASCII 码在 3232 到 126126 范围内的字符组成。您可以参阅下表获得其详细信息。
 * ../图片/可见字符集Ascii.png
 * 输入描述：
 * 在一行上输入一个长度为 1≦len(s)≦2501≦len(s)≦250，由可见字符和空格构成的字符串 ss 。
 * 输出描述：
 * 输出一个整数，表示字符串中大写字母的个数。
 * 示例1
 * 输入：
 *
 * A 1 0 1 1150175017(&^%&$vabovbaoadd 123#$%#%#O
 *
 * 输出：
 *
 * 2
 */
public class UppercaseCounterTest {
    @Test
    void testUppercaseCounter() {
        String s = "A 1 0 1 1150175017(&^%&$vabovbaoadd 123#$%#%#O";
        int c = count(s);
        Assertions.assertEquals(2, c);
    }

    private static int count(String  s) {
        return (int) s.chars()
                .filter(c -> c >= 'A' && c <= 'Z')
                .count();
    }
}
