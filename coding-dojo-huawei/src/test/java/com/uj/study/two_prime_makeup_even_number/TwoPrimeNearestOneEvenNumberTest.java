package com.uj.study.two_prime_makeup_even_number;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.uj.study.two_prime_makeup_even_number.TwoPrimesNearestOneEvenNumber.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/27 下午1:01
 * @description： 描述
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 * <p>
 * 数据范围：输入的数据满足 4≤n≤1000 4≤n≤1000
 * 输入描述：
 * <p>
 * 输入一个大于2的偶数
 * 输出描述：
 * <p>
 * 从小到大输出两个素数
 * 示例1
 * 输入：
 * <p>
 * 20
 * <p>
 * 输出：
 * <p>
 * 7
 * 13
 * <p>
 * 示例2
 * 输入：
 * <p>
 * 4
 * <p>
 * 输出：
 * <p>
 * 2
 * 2
 */
public class TwoPrimeNearestOneEvenNumberTest {

    @Test
    void primeListCorrect() {
        assertThat(getPrimeList(2), contains(2));
        assertThat(getPrimeList(8), contains(2, 3, 5, 7));
    }

    @Test
    void twoPrimesAddIsEvenNumber() {
        assertThat(matchPrimes(4).size(), is(1));
        assertThat(matchPrimes(6).size(), is(1));
        assertThat(matchPrimes(8).size(), is(1));
        assertThat(matchPrimes(10).size(), is(2));
        assertThat(matchPrimes(20).size(), is(2));
    }

    @Test
    void nearestTwoPrimesAddIsEvenNumber() {
        TwoPrimes tw = nearestPrimes(4);
        assertThat(tw.getPrime1(), is(2));
        assertThat(tw.getPrime2(), is(2));
        tw = nearestPrimes(10);
        assertThat(tw.getPrime1(), is(5));
        assertThat(tw.getPrime2(), is(5));
        tw = nearestPrimes(20);
        assertThat(tw.getPrime1(), is(7));
        assertThat(tw.getPrime2(), is(13));
    }
}

