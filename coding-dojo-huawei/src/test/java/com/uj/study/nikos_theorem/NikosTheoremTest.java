package com.uj.study.nikos_theorem;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 描述
 *
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *
 * 例如：
 *
 * 1^3=1
 *
 * 2^3=3+5
 *
 * 3^3=7+9+11
 *
 * 4^3=13+15+17+19
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 数据范围：1≤m≤100 1≤m≤100
 * 进阶：时间复杂度：O(m) O(m) ，空间复杂度：O(1) O(1)
 *
 *
 * 输入描述：
 *
 * 输入一个int整数
 * 输出描述：
 *
 * 输出分解后的string
 * 示例1
 * 输入：
 *
 * 6
 *
 * 输出：
 *
 * 31+33+35+37+39+41
 */
public class NikosTheoremTest {
    @Test
    void nikosTest() {
        int m = 1;
        String result = NikosTheorem.decompose(m);
        assertThat(result, is("1"));
        m = 2;
        result = NikosTheorem.decompose(m);
        assertThat(result, is("3+5"));
        m = 3;
        result = NikosTheorem.decompose(m);
        assertThat(result, is("7+9+11"));
        m = 4;
        result = NikosTheorem.decompose(m);
        assertThat(result, is("13+15+17+19"));
        m = 5;
        result = NikosTheorem.decompose(m);
        assertThat(result, is("21+23+25+27+29"));
        m = 6;
        result = NikosTheorem.decompose(m);
        assertThat(result, is("31+33+35+37+39+41"));
    }
}
