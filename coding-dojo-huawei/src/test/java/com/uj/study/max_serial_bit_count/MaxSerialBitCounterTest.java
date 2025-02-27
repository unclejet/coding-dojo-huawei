package com.uj.study.max_serial_bit_count;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 描述
 * 对于给定的十进制整数 n，求解其二进制表示中，最长连续 1段的长度。
 * 输入描述：
 * 输入一个十进制整数 n(1≦n≦5×105)。
 * 输出描述：
 * 输出一个整数，表示 nn 的二进制表示中，最长连续 11 段的长度。
 * 示例1
 * 输入：
 *
 * 200
 *
 * 输出：
 *
 * 2
 *
 * 说明：
 *
 * 在这个样例中，十进制 (200)10(200)10​ 等于二进制 (11 001 000)2(11001000)2​，其中最长连续 11 段的长度为 22。
 *
 * 示例2
 * 输入：
 *
 * 1023
 *
 * 输出：
 *
 * 10
 *
 * 说明：
 *
 * 在这个样例中，十进制 (1023)10(1023)10​ 等于二进制 (1 111 111 111)2(1111111111)2​。
 */
public class MaxSerialBitCounterTest {
    @Test
    void test_decimal2binary() {
        int i = 1023;
        String binary = Integer.toBinaryString(i);
        Assertions.assertEquals("1111111111", binary);
        i = 200;
        binary = Integer.toBinaryString(i);
        Assertions.assertEquals("11001000", binary);
    }

    @Test
    void test_maxSerialBitCount() {
        String binary = "10000000";
        int maxCount = maxSerialBitCount(binary);
        Assertions.assertEquals(1, maxCount);
        binary = "11000000";
        maxCount = maxSerialBitCount(binary);
        Assertions.assertEquals(2, maxCount);
        binary = "11111111";
        maxCount = maxSerialBitCount(binary);
        Assertions.assertEquals(8, maxCount);
        binary = "000111110";
        maxCount = maxSerialBitCount(binary);
        Assertions.assertEquals(5, maxCount);
        int n = 1023;
        Assertions.assertEquals(10, maxSerialBitCount(n));
    }

    int maxSerialBitCount(String binary) {
        return Arrays.stream(binary.split("0"))
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    // 方案3：直接处理整数
    int maxSerialBitCount(int n) {
        int maxCount = 0;
        int currentCount = 0;
        
        while (n != 0) {
            if ((n & 1) == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
            n >>= 1;
        }
        return maxCount;
    }

}
