package com.uj.study.snake_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static com.uj.study.snake_array.SnakeArrayGenerator.formatUTM;
import static com.uj.study.snake_array.SnakeArrayGenerator.generateUTM;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/10/24 下午12:16
 * @description： 描述
 * <p>
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * <p>
 * 例如，当输入5时，应该输出的三角形为：
 * <p>
 * 1 3 6 10 15
 * <p>
 * 2 5 9 14
 * <p>
 * 4 8 13
 * <p>
 * 7 12
 * 11
 * <p>
 * <p>
 * 输入描述：
 * <p>
 * 输入正整数N（N不大于100）
 * 输出描述：
 * <p>
 * 输出一个N行的蛇形矩阵。
 * 示例1
 * 输入：
 * <p>
 * 4
 * <p>
 * 输出：
 * <p>
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 */
public class SnakeArrayTest {
    @Test
    void upperTriangularMatrix() {
        Assertions.assertArrayEquals(generateUTM(1), new int[]{1});
        Assertions.assertArrayEquals(generateUTM(2), new int[]{1, 3, 2});
        Assertions.assertArrayEquals(generateUTM(3), new int[]{1, 3, 6, 2, 5, 4});
        Assertions.assertArrayEquals(generateUTM(4), new int[]{1, 3, 6, 10, 2, 5, 9, 4, 8, 7});
    }

    @Test
    void formatUpperTriangularMatrix() {
        assertThat(formatUTM(1, new int[]{1}), is("1"));
        assertThat(formatUTM(2, new int[]{1, 3, 2}), is("1 3 \n2"));
        assertThat(formatUTM(3, new int[]{1, 3, 6, 2, 5, 4}), is("1 3 6 \n2 5 \n4"));
        assertThat(formatUTM(4, new int[]{1, 3, 6, 10, 2, 5, 9, 4, 8, 7}), is("1 3 6 10 \n2 5 9 \n4 8 \n7"));
    }
}
