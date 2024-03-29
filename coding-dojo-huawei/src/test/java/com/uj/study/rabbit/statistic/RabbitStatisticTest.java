package com.uj.study.rabbit.statistic;

import org.junit.jupiter.api.Test;

import static com.uj.study.rabbit.statistic.RabbitStatistic.statistic;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/9 下午12:08
 * @description： 描述
 * 有一种兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子。
 * 例子：假设一只兔子第3个月出生，那么它第5个月开始会每个月生一只兔子。
 * 一月的时候有一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
 * 数据范围：输入满足 1≤n≤31 1 \le n \le 31 \ 1≤n≤31
 * 输入描述：
 * <p>
 * 输入一个int型整数表示第n个月
 * 输出描述：
 * <p>
 * 输出对应的兔子总数
 * 示例1
 * 输入：
 * <p>
 * 3
 * <p>
 * 输出：
 * <p>
 * 2
 */
public class RabbitStatisticTest {
    @Test
    void statisticRabbits() {
        assertThat(statistic(1), is(1));
        assertThat(statistic(2), is(1));
        assertThat(statistic(3), is(2));
        assertThat(statistic(4), is(3));
        assertThat(statistic(5), is(5));
        assertThat(statistic(9), is(23));
    }

}
