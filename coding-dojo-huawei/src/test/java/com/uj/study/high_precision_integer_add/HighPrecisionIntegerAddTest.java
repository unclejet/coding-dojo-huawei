package com.uj.study.high_precision_integer_add;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.uj.study.high_precision_integer_add.HighPrecisionIntegerAdder.add;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/12 下午12:37
 * @description： 描述
 * 输入两个用字符串 str 表示的整数，求它们所表示的数之和。
 * <p>
 * 数据范围： 1≤len(str)≤10000 1≤len(str)≤10000
 * 输入描述：
 * <p>
 * 输入两个字符串。保证字符串只含有'0'~'9'字符
 * 输出描述：
 * <p>
 * 输出求和后的结果
 * 示例1
 * 输入：
 * <p>
 * 9876543210
 * 1234567890
 * <p>
 * 输出：
 * <p>
 * 11111111100
 */
public class HighPrecisionIntegerAddTest {

    @Test
    void addCorrectly() {
        assertThat(add("1", "1"), is("2"));
        assertThat(add("1", "9"), is("10"));
        assertThat(add("12", "9"), is("21"));
        assertThat(add("11", "9"), is("20"));
        assertThat(add("9876543210", "1234567890"), is("11111111100"));
        assertThat(add("1234567899876543210", "98765434211234567890"), is("100000002111111111100"));
        assertThat(add("113", "4567"), is("4680"));
    }
}
