package com.uj.study.matrix__multiplication;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/2/28 下午12:49
 * @description：
 * * 矩阵的大小不超过100*100
 *  * 输入描述：
 *  * 第一行包含一个正整数x，代表第一个矩阵的行数
 *  * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
 *  * 第三行包含一个正整数z，代表第二个矩阵的列数
 *  * 之后x行，每行y个整数，代表第一个矩阵的值
 *  * 之后y行，每行z个整数，代表第二个矩阵的值
 *  *
 *  * 输出描述：
 *  * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
 *  * 示例1
 *  * 输入：
 *  *
 *  * 2
 *  * 3
 *  * 2
 *  * 1 2 3
 *  * 3 2 1
 *  * 1 2
 *  * 2 1
 *  * 3 3
 *  *
 *  * 输出：
 *  *
 *  * 14 13
 *  * 10 11
 */
public class MatrixMultiUserReaderTest extends BaseUserInputReaderTest {
    MatrixMultiUserReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new MatrixMultiUserReader(lineReaderStub);
    }

    @Test
    void readXYZ() {
        lineReaderStub.simulateUserInputs("a", "!", "0", "101", "100");
        assertThat(reader.readPositiveNumber(), is(100));
    }

    @Test
    void readMatrix() {
        lineReaderStub.simulateUserInputs("1 2 3 4", "1 2 3", "a 2 1", "3 2", " 3 2  1 ");
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 3, 2, 1}, reader.readMatrix(2, 3));
    }
}
