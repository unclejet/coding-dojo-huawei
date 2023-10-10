package com.uj.study.pick7;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static com.uj.study.pick7.SevenPicker.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/9 下午12:31
 * @description：
 * 描述
 * 输出 1到n之间 的与 7 有关数字的个数。
 * 一个数与7有关是指这个数是 7 的倍数，或者是包含 7 的数字（如 17 ，27 ，37 ... 70 ，71 ，72 ，73...）
 *
 * 数据范围： 1≤n≤30000 1≤n≤30000
 * 输入描述：
 *
 * 一个正整数 n 。( n 不大于 30000 )
 * 输出描述：
 *
 * 一个整数，表示1到n之间的与7有关的数字个数。
 * 示例1
 * 输入：
 *
 * 20
 *
 * 输出：
 *
 * 3
 *
 * 说明：
 *
 * 输入20，1到20之间有关的数字包括7,14,17共3个。
 */
public class Pick7Test {
    @Test
    void timesOf7() {
        assertThat(isTimesOf7(1), is(false));
        assertThat(isTimesOf7(7), is(true));
        assertThat(isTimesOf7(14), is(true));
        assertThat(isTimesOf7(17), is(false));
    }

    @Test
    void contains7Test() {
        assertThat(contains7("1"), is(false));
        assertThat(contains7("7"), is(true));
        assertThat(contains7("14"), is(false));
        assertThat(contains7("17"), is(true));
    }

    @Test
    void count7Test() {
        assertThat(count7(20), is(3l));
        assertThat(count7(50), is(11l));
    }
}
