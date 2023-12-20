package com.uj.study.put_apple;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/11/1 下午12:54
 * @description： 描述
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 * 注意：如果有7个苹果和3个盘子，（5，1，1）和（1，5，1）被视为是同一种分法。
 * <p>
 * 数据范围：0≤m≤10 0≤m≤10 ，1≤n≤10 1≤n≤10 。
 * <p>
 * <p>
 * 输入描述：
 * <p>
 * 输入两个int整数
 * 输出描述：
 * <p>
 * 输出结果，int型
 */
public class PutAppleTest {

    @Test
    void apples_greaterThan_plates() {
        assertThat(possible(3, 2), is(2));
        assertThat(possible(4, 2), is(3));
        assertThat(possible(5, 2), is(3));
        assertThat(possible(10, 2), is(6));
        assertThat(possible(4, 3), is(4));
        assertThat(possible(7, 3), is(8));
    }

    @Test
    void no_apple_1_plate() {
        assertThat(possible(0, 1), is(0));
    }

    @Test
    void apple_lessThan_plate() {
        assertThat(possible(1, 2), is(1));
        assertThat(possible(1, 3), is(1));
        assertThat(possible(2, 3), is(2));
        assertThat(possible(2, 4), is(2));
        assertThat(possible(1, 3), is(1));
        assertThat(possible(2, 3), is(2));
    }

    @Test
    void apples_equal_plates() {
        assertThat(possible(1, 1), is(1));
        assertThat(possible(2, 2), is(2));
        assertThat(possible(3, 3), is(3));
        assertThat(possible(4, 4), is(5));
    }

    private int possible(int apple, int plate) {
        return ApplePutter.possible(apple, plate);
    }
}
