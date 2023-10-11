package com.uj.study.perfect.number;

import org.junit.jupiter.api.Test;

import static com.uj.study.perfect.number.PerfectNumberCounter.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/10 下午12:42
 * @description：
 * 描述
 *
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 *
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 *
 * 输入n，请输出n以内(含n)完全数的个数。
 *
 * 数据范围： 1≤n≤5×105 1≤n≤5×105
 * 输入描述：
 *
 * 输入一个数字n
 * 输出描述：
 *
 * 输出不超过n的完全数的个数
 * 示例1
 * 输入：
 *
 * 1000
 *
 * 输出：
 *
 * 3
 */
public class PerfectNumberTest {
    @Test
    void getDivisorNumbersCorrectly() {
        assertThat(divisors(1), contains(1));
        assertThat(divisors(2), contains(1, 2));
        assertThat(divisors(3), contains(1, 3));
        assertThat(divisors(4), contains(1, 2, 4));
        assertThat(divisors(28), contains(1, 2, 4, 7, 14, 28));
    }

    @Test
    void isPerfectNumberCorrect() {
        assertThat(isPerfectNumber(1), is(false));
        assertThat(isPerfectNumber(2), is(false));
        assertThat(isPerfectNumber(4), is(false));
        assertThat(isPerfectNumber(28), is(true));
        assertThat(isPerfectNumber(6), is(true));
        assertThat(isPerfectNumber(496), is(true));
        assertThat(isPerfectNumber(8128), is(true));
    }

    @Test
    void countPerfectNumber() {
        assertThat(countWithin(1000), is(3L));
    }
}
