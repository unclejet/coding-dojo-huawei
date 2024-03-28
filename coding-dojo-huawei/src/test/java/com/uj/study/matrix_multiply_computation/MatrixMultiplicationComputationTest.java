package com.uj.study.matrix_multiply_computation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/3/5 下午12:33
 * @description： 描述
 * <p>
 * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
 * 例如：
 * <p>
 * A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 * <p>
 * 计算A*B*C有两种顺序：((AB)C)或者(A(BC))，前者需要计算15000次乘法，后者只需要3500次。
 * 编写程序计算不同的计算顺序需要进行的乘法次数。
 * <p>
 * 数据范围：矩阵个数：1≤n≤15 1≤n≤15 ，行列数：1≤rowi,coli≤100 1≤rowi​,coli​≤100 ，保证给出的字符串表示的计算顺序唯一。
 * 进阶：时间复杂度：O(n) O(n) ，空间复杂度：O(n) O(n)
 * <p>
 * <p>
 * 输入描述：
 * <p>
 * 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
 * 计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，保证括号是匹配的且输入合法！
 * 输出描述：
 * <p>
 * 输出需要进行的乘法次数
 * 示例1
 * 输入：
 * <p>
 * 3
 * 50 10
 * 10 20
 * 20 5
 * (A(BC))
 * <p>
 * 输出：
 * <p>
 * 3500
 */
public class MatrixMultiplicationComputationTest {
    static HashMap<String, Matrix> alphabetMatrix = new HashMap<>(3);
    static Matrix a = new Matrix(50, 10);
    static Matrix b = new Matrix(10, 20);
    static Matrix c = new Matrix(20, 5);

    private MatrixMultiCounter matrixMultiCounter;

    @BeforeAll
    static void beforeAll() {
        alphabetMatrix.put("A", a);
        alphabetMatrix.put("B", b);
        alphabetMatrix.put("C", c);
    }

    @Test
    void multiplyCount() {
        matrixMultiCounter = new MatrixMultiCounter(alphabetMatrix, null);
        assertThat(matrixMultiCounter.multiCount(a, b), is(10000));
        assertThat(matrixMultiCounter.multiCount(b, a), is(10000));
        assertThat(matrixMultiCounter.multiCount(b, c), is(1000));
        Assertions.assertThrows(
                InvalidMatrixRuleException.class,
                () -> {
                    matrixMultiCounter.multiCount(a, c);
                }
        );
        Assertions.assertThrows(
                InvalidMatrixRuleException.class,
                () -> {
                    matrixMultiCounter.multiCount(a, a);
                }
        );
    }

    @Test
    void parseMultiplyRule() {
        String rule = "AB";
        matrixMultiCounter = new MatrixMultiCounter(alphabetMatrix, rule);
        matrixMultiCounter.parseMultiplyRule(rule);
        assertThat(matrixMultiCounter.getRules(), contains("A", "B"));

        rule = "(AB)";
        matrixMultiCounter = new MatrixMultiCounter(alphabetMatrix, rule);
        matrixMultiCounter.parseMultiplyRule(rule);
        assertThat(matrixMultiCounter.getRules(), contains("A", "B"));

        rule = "(C(AB))";
        matrixMultiCounter = new MatrixMultiCounter(alphabetMatrix, rule);
        matrixMultiCounter.parseMultiplyRule(rule);
        assertThat(matrixMultiCounter.getRules(), contains("A", "B", "C"));

        //exception scenarios
        rule = "(A(BC)";
        matrixMultiCounter = new MatrixMultiCounter(alphabetMatrix, rule);
        String finalRule = rule;
        Assertions.assertThrows(
                InvalidMultiRuleException.class,
                () -> {
                    matrixMultiCounter.parseMultiplyRule(finalRule);
                }
        );

        rule = "A(BC))";
        matrixMultiCounter = new MatrixMultiCounter(alphabetMatrix, rule);
        String finalRule1 = rule;
        Assertions.assertThrows(
                InvalidMultiRuleException.class,
                () -> {
                    matrixMultiCounter.parseMultiplyRule(finalRule1);
                }
        );
    }

    @Test
    void multiplyComputation() {
        matrixMultiCounter = new MatrixMultiCounter(alphabetMatrix, "(A(BC))");
        assertThat(matrixMultiCounter.count(), is(3500));

        matrixMultiCounter = new MatrixMultiCounter(alphabetMatrix, "A");
        Assertions.assertThrows(
                InvalidMultiRuleException.class,
                () -> {
                    matrixMultiCounter.count();
                }
        );
    }
}

