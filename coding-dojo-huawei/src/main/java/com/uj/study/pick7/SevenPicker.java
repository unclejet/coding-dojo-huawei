package com.uj.study.pick7;


import java.util.stream.IntStream;



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
public class SevenPicker {

    public static long count7(int total) {
        return IntStream.rangeClosed(1, total).filter(
                (n)->(isTimesOf7(n) ||contains7(String.valueOf(n)))
        ).count();
    }

    static boolean contains7(String str) {
        return str.contains("7");
    }

    static boolean isTimesOf7(int n) {
        return n % 7 == 0;
    }
}
