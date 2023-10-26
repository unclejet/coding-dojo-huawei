package com.uj.study.smallest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/23 下午12:56
 * @description：
 * 描述
 * 输入n个整数，找出其中最小的k个整数并按升序输出
 *
 * 本题有多组输入样例
 *
 * 数据范围：1≤n≤1000 1≤n≤1000  ，输入的整数满足 1≤val≤10000 1≤val≤10000
 * 输入描述：
 *
 * 第一行输入两个整数n和k
 * 第二行输入一个整数数组
 * 输出描述：
 *
 * 从小到大输出最小的k个整数，用空格分开。
 * 示例1
 * 输入：
 *
 * 5 2
 * 1 3 5 7 2
 *
 * 输出：
 *
 * 1 2
 */
public class SmallestIntegerKGeneratorTest {

    @Test
    void smallest_numbers_correct() {
        assertThat(smallestNumbers(new int[]{1}, 1), contains(1));
        assertThat(smallestNumbers(new int[]{2, 1}, 2), contains(1, 2));
        assertThat(smallestNumbers(new int[]{1, 3, 5, 7, 2}, 2), contains(1, 2));
    }

    @Test
    void outputFormatCorrect() {
        assertThat(format(smallestNumbers(new int[]{1, 3, 5, 7, 2}, 2)), is("1 2"));
    }

    private String format(List<Integer> smallestNumbers) {
        return SmallestIntegerKGenerator.format(smallestNumbers);
    }

    private List<Integer> smallestNumbers(int[] numArr, int n) {
        return SmallestIntegerKGenerator.smallestNumbers(numArr, n);
    }
}
