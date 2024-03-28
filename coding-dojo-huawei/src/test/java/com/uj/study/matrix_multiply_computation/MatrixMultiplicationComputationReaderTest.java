package com.uj.study.matrix_multiply_computation;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/3/20 下午12:49
 * @description：
 * <p>
 *  * 数据范围：矩阵个数：1≤n≤15 1≤n≤15 ，行列数：1≤rowi,coli≤100 1≤rowi​,coli​≤100 ，保证给出的字符串表示的计算顺序唯一。
 *  * 进阶：时间复杂度：O(n) O(n) ，空间复杂度：O(n) O(n)
 *  * <p>
 *  * <p>
 *  * 输入描述：
 *  * <p>
 *  * 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
 *  * 计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，保证括号是匹配的且输入合法！
 *  * 输出描述：
 *  * <p>
 *  * 输出需要进行的乘法次数
 *  * 示例1
 *  * 输入：
 *  * <p>
 *  * 3
 *  * 50 10
 *  * 10 20
 *  * 20 5
 *  * (A(BC))
 *  * <p>
 *  * 输出：
 *  * <p>
 *  * 3500
 */
public class MatrixMultiplicationComputationReaderTest extends BaseUserInputReaderTest {
    MatrixMultiplicationComputationReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new MatrixMultiplicationComputationReader(lineReaderStub);
    }

    @Test
    void readMatrix() {
        lineReaderStub.simulateUserInputs("0", "16", "3", "50 10", "0 20", "1 101", "10  20", "20 5");
        Map<String, Matrix> stringMatrixMap = reader.readMatrix();
        assertThat(stringMatrixMap.size(), is(3));
        assertThat(stringMatrixMap.get("B").getRow(), is(10));
        assertThat(stringMatrixMap.get("B").getColumn(), is(20));
    }

    @Test
    void readRule() {
        lineReaderStub.simulateUserInputs("*A", "(a)", "(A(BC))");
        assertThat(reader.readRule(), is("(A(BC))"));
    }
}
