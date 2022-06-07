package com.uj.study.prime.partner;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/4/28 下午12:57
 * @description：
 * 描述
 *
 * 题目描述
 * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，从已有的 N （ N 为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
 *
 * 输入:
 *
 * 有一个正偶数 n ，表示待挑选的自然数的个数。后面给出 n 个具体的数字。
 *
 * 输出:
 *
 * 输出一个整数 K ，表示你求得的“最佳方案”组成“素数伴侣”的对数。
 *
 * 数据范围： 1≤n≤100 1 \le n \le 100 \ 1≤n≤100  ，输入的数据大小满足 2≤val≤30000 2 \le val \le 30000 \ 2≤val≤30000
 * 输入描述：
 *
 * 输入说明
 * 1 输入一个正偶数 n
 * 2 输入 n 个整数
 * 输出描述：
 *
 * 求得的“最佳方案”组成“素数伴侣”的对数。
 * 示例1
 * 输入：
 *
 * 4
 * 2 5 6 13
 *
 * 输出：
 *
 * 3
 *
 * 示例2
 * 输入：
 *
 * 2
 * 3 6
 *
 * 输出：
 *
 * 0
 */
public class PrimeFactorUserInputNumberReaderTest extends BaseUserInputReaderTest {
    PrimeFactorUserInputNumberReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new PrimeFactorUserInputNumberReader(lineReaderStub);
    }

    @Test
    void inputNumberIsEven() {
        lineReaderStub.simulateUserInputs("9", "2");
        assertThat(reader.readEvenTotalNumber(), is(2));
    }

    @Test
    void inputNumberLessThan_100() {
        lineReaderStub.simulateUserInputs("102", "100", "98");
        assertThat(reader.readEvenTotalNumber(), is(100));
    }

    @Test
    void inputNumberGreaterThan_1() {
        lineReaderStub.simulateUserInputs("0", "1", "2");
        assertThat(reader.readEvenTotalNumber(), is(2));
    }

    @Test
    void inputNumbers() {
        lineReaderStub.simulateUserInputs("4");
        assertThat(reader.readNumbers(1), contains(4));

        lineReaderStub.simulateUserInputs("4 5");
        assertThat(reader.readNumbers(2), contains(4, 5));

        lineReaderStub.simulateUserInputs("4     5");
        assertThat(reader.readNumbers(2), contains(4, 5));

        lineReaderStub.simulateUserInputs("2 5 6 13");
        assertThat(reader.readNumbers(4), contains(2, 5, 6, 13));

        lineReaderStub.simulateUserInputs("4", "4 5");
        assertThat(reader.readNumbers(2), contains(4, 5));

        lineReaderStub.simulateUserInputs("4.1", "a", "4");
        assertThat(reader.readNumbers(1), contains(4));

        lineReaderStub.simulateUserInputs("4,6", "4 5");
        assertThat(reader.readNumbers(2), contains(4, 5));

        lineReaderStub.simulateUserInputs("5 1", "4 5");
        assertThat(reader.readNumbers(2), contains(4, 5));
    }

    /**
     * 素数又叫质数。素数，指的是“大于1的整数中，只能被1和这个数本身整除的数
     */
    @Test
    void isPrime() {
        Assertions.assertFalse(PrimeIdentifier.isPrime(0));
        Assertions.assertFalse(PrimeIdentifier.isPrime(1));
        Assertions.assertTrue(PrimeIdentifier.isPrime(2));
        Assertions.assertTrue(PrimeIdentifier.isPrime(3));
        Assertions.assertFalse(PrimeIdentifier.isPrime(4));
        Assertions.assertTrue(PrimeIdentifier.isPrime(5));
        Assertions.assertFalse(PrimeIdentifier.isPrime(6));
        Assertions.assertTrue(PrimeIdentifier.isPrime(7));
        Assertions.assertFalse(PrimeIdentifier.isPrime(8));
        Assertions.assertTrue(PrimeIdentifier.isPrime(6113));
        Assertions.assertFalse(PrimeIdentifier.isPrime(6112));
    }

    @Test
    void primePartner() {
        assertThat(PrimePartner.bestPartner(Arrays.asList(2)), is(0));
        assertThat(PrimePartner.bestPartner(Arrays.asList(3, 6)), is(0));
        assertThat(PrimePartner.bestPartner(Arrays.asList(2, 3)), is(1));
        assertThat(PrimePartner.bestPartner(Arrays.asList(2, 3, 5)), is(1)); //(2, 3)
        assertThat(PrimePartner.getPartners(), contains(2, 3));
        assertThat(PrimePartner.bestPartner(Arrays.asList(2, 4, 5)), is(1)); //(2, 5)
        assertThat(PrimePartner.getPartners(), contains(2, 5));
        assertThat(PrimePartner.bestPartner(Arrays.asList(2, 6, 7)), is(1)); //(6, 7)
        assertThat(PrimePartner.getPartners(), contains(6, 7));
        assertThat(PrimePartner.bestPartner(Arrays.asList(2, 5, 6, 13)), is(2));
        assertThat(PrimePartner.getPartners(), contains(2, 5, 6, 13));
    }
}
