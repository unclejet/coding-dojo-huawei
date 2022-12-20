package com.uj.study.counterweight;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.uj.study.counterweight.CounterWeight.count;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/12/5 下午12:29
 * @description： 描述
 * <p>
 * 现有n种砝码，重量互不相等，分别为 m1,m2,m3…mn ；
 * 每种砝码对应的数量为 x1,x2,x3...xn 。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 * <p>
 * 注：
 * 称重重量包括 0
 * <p>
 * 数据范围：每组输入数据满足 1≤n≤10 1≤n≤10  ， 1≤mi≤2000 1≤mi​≤2000  ， 1≤xi≤10 1≤xi​≤10
 * 输入描述：
 * 对于每组测试数据：
 * 第一行：n --- 砝码的种数(范围[1,10])
 * 第二行：m1 m2 m3 ... mn --- 每种砝码的重量(范围[1,2000])
 * 第三行：x1 x2 x3 .... xn --- 每种砝码对应的数量(范围[1,10])
 * 输出描述：
 * <p>
 * 利用给定的砝码可以称出的不同的重量数
 * 示例1
 * 输入：
 * <p>
 * 2
 * 1 2
 * 2 1
 * <p>
 * 输出：
 * <p>
 * 5
 * <p>
 * 说明：
 * <p>
 * 可以表示出0，1，2，3，4五种重量。
 */
public class CounterWeightTest {
    @Test
    void type1_quantity1() {
        assertThat(count(Arrays.asList(1), Arrays.asList(1)), contains(0, 1));
        assertThat(count(Arrays.asList(1), Arrays.asList(2)), contains(0, 1, 2));
        assertThat(count(Arrays.asList(1), Arrays.asList(3)), contains(0, 1, 2, 3));
    }

    @Test
    void type1_2_quantity2_1() {
        assertThat(count(Arrays.asList(1, 2), Arrays.asList(2, 1)), contains(0, 1, 2, 3, 4));
    }

    @Test
    void type1_2_quantity2_2() {
        assertThat(count(Arrays.asList(1, 2), Arrays.asList(2, 2)), contains(0, 1, 2, 3, 4, 5, 6));
    }

    @Test
    void type1_2_3_quantity2_2_2() {
        assertThat(count(Arrays.asList(1, 2, 3), Arrays.asList(2, 2, 2)), contains(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
    }
}
