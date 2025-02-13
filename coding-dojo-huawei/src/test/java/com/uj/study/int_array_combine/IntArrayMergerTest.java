package com.uj.study.int_array_combine;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 描述
 * 对于给定的由 nn 个整数组成的数组 {a1,a2,…,an}{a1​,a2​,…,an​} 和 mm 个整数组成的数组 {b1,b2,…,bm}{b1​,b2​,…,bm​}，将它们合并后从小到大排序，并输出去重后的结果。
 *
 * 注意，本题在输出时，元素间不需要输出空格。
 * 输入描述：
 * 第一行输入一个整数 n(1≦n≦150)n(1≦n≦150) 代表数组 aa 中的元素个数。
 * 第二行输入 nn 个整数 a1,a2,…,an(−1≦ai≦105)a1​,a2​,…,an​(−1≦ai​≦105) 代表数组 aa 中的元素。
 * 第三行输入一个整数 m(1≦m≦150)m(1≦m≦150) 代表数组 bb 中的元素个数。
 * 第四行输入 mm 个整数 b1,b2,…,bm(−1≦bi≦105)b1​,b2​,…,bm​(−1≦bi​≦105) 代表数组 bb 中的元素。
 * 输出描述：
 * 输出按升序合并、去重后的数组。
 * 示例1
 * 输入：
 *
 * 3
 * 1 2 5
 * 4
 * -1 0 3 2
 *
 * 输出：
 *
 * -101235
 *
 * 说明：
 *
 * 在这个样例中，拼接后得到 {1,2,5,−1,0,3,2}，去重后得到 {1,2,5,−1,0,3}，排序后得到 {−1,0,1,2,3,5}。
 *
 * 示例2
 * 输入：
 *
 * 1
 * 11
 * 1
 * 111
 *
 * 输出：
 *
 * 11111
 */
public class IntArrayMergerTest {
    @Test
    void nothing() {
    }

    @Test
    void one() {
//        int n = 1;
        int[] a1 = {11};
//        int m = 1;
        int[] b1 = {111};
        String result = sortAndMerge(a1, b1);
        assertThat(result, is("11111"));
    }

    @Test
    void two_one_all_different() {
        int[] a = {1, 2};
        int[] b = {3,};
        String result = sortAndMerge(a, b);
        assertThat(result, is("123"));
    }

    @Test
    void two_one_has_same() {
        int[] a = {1, 2};
        int[] b = {1,};
        String result = sortAndMerge(a, b);
        assertThat(result, is("12"));
    }

    @Test
    void two_one_need_sort() {
        int[] a = {2, 1};
        int[] b = {1,};
        String result = sortAndMerge(a, b);
        assertThat(result, is("12"));
    }

    @Test
    void mixed() {
        int[] a = {2, 1, 5, 3};
        int[] b = {1, 4, 2, 6};
        String result = sortAndMerge(a, b);
        assertThat(result, is("123456"));
    }

    @Test
    void example1() {
        int[] a = {1, 2, 5};
        int[] b = {-1, 0, 3, 2};
        String result = sortAndMerge(a, b);
        assertThat(result, is("-101235"));
    }

    @Test
    void example2() {
        int[] a = {11};
        int[] b = {111};
        String result = sortAndMerge(a, b);
        assertThat(result, is("11111"));
    }


    private String sortAndMerge(int[] a, int[] b) {
        // 合并数组
        int[] combined = new int[a.length + b.length];
        System.arraycopy(a, 0, combined, 0, a.length);
        System.arraycopy(b, 0, combined, a.length, b.length);

        // 去重并排序
        return Arrays.stream(combined)
                .distinct()
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
}
