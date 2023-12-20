package com.uj.study.binary_1_count;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/12/19 下午12:44
 * @description：
 * 描述
 * 输入一个正整数，计算它在二进制下的1的个数。
 * 注意多组输入输出！！！！！！
 *
 * 数据范围： 1≤n≤231−1 1≤n≤231−1
 * 输入描述：
 *
 * 输入一个整数
 * 输出描述：
 *
 * 计算整数二进制中1的个数
 * 示例1
 * 输入：
 *
 * 5
 *
 * 输出：
 *
 * 2
 *
 * 说明：
 *
 * 5的二进制表示是101，有2个1
 *
 * 示例2
 * 输入：
 *
 * 0
 *
 * 输出：
 *
 * 0
 */
public class BinaryOneCounterTest {

    @Test
    void decimal2Binary_correctly() {
        assertThat(dec2Bin("1"), is("00000001"));
        assertThat(dec2Bin("5"), is("00000101"));
        assertThat(dec2Bin(String.valueOf(Integer.MAX_VALUE)), is("1111111111111111111111111111111"));
    }

    @Test
    void count1() {
        assertThat(count("00000101"), is(2));
        assertThat(count("1111111111111111111111111111111"), is(31));
    }

    int count(String bin) {
        return BinaryOneCounter.count(bin);
    }

    String dec2Bin(String decStr) {
        return BinaryOneCounter.dec2Bin(decStr);
    }
}
