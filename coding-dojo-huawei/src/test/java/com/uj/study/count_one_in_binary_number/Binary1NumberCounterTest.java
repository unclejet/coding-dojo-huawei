package com.uj.study.count_one_in_binary_number;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/22 上午11:39
 * @description：
 * 题目描述
 *
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * 输入描述:
 *
 *  输入一个整数（int类型）
 *
 * 输出描述:
 *
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入
 * 复制
 *
 * 5
 *
 * 输出
 * 复制
 *
 * 2
 */
public class Binary1NumberCounterTest {
    @Test
    void decimal2Binary() {
        assertThat(DecimalToBinary.convert(5), is ("101"));
    }

    @Test
    void count1InBinaryNumber() {
        assertThat(Binary1NumberCounter.count("101"), is(2));
    }
}
