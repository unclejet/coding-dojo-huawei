package com.uj.study.expression.evaluation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/9/27 下午12:29
 * @description：
 * 描述
 *
 * 给定一个字符串描述的算术表达式，计算出结果值。
 * 输入字符串长度不超过 100 ，合法的字符包括 ”+, -, *, /, (, )” ， ”0-9” 。
 *
 * 数据范围：运算过程中和最终结果均满足 ∣val∣≤231−1 ∣val∣≤231−1  ，即只进行整型运算，确保输入的表达式合法
 * 输入描述：
 *
 * 输入算术表达式
 * 输出描述：
 *
 * 计算出结果值
 * 示例1
 * 输入：
 *
 * 400+5
 *
 * 输出：
 *
 * 405
 */
public class ExpressionEvaluationTest {
    private Operations fo;

    @BeforeEach
    void setUp() {
        fo = new Operations();
    }

    @Test
    void max_integer() {
        String s = String.valueOf(Integer.MAX_VALUE);
        String op = s + "+1";
        int r = fo.calculate(op);
        assertThat(r, is(-2147483648));
    }


    @Test
    void add() {
        String op = "1+2";
        int r = fo.calculate(op);
        assertThat(r, is(3));
        op = "1+2+3";
        r = fo.calculate(op);
        assertThat(r, is(6));

        op = "-2+7";
        r = fo.calculate(op);
        assertThat(r, is(5));

        op = "400+5";
        r = fo.calculate(op);
        assertThat(r, is(405));
    }

    @Test
    void subtract() {
        String op = "2-1";
        int r = fo.calculate(op);
        assertThat(r, is(1));
        op = "3-2-1";
        r = fo.calculate(op);
        assertThat(r, is(0));
    }

    @Test
    void multiply() {
        String op = "3*4";
        int r = fo.calculate(op);
        assertThat(r, is(12));
        op = "3*40*5*20";
        r = fo.calculate(op);
        assertThat(r, is(12000));
    }

    @Test
    void divide() {
        String op = "20/4";
        int r = fo.calculate(op);
        assertThat(r, is(5));
        op = "100/20/5";
        r = fo.calculate(op);
        assertThat(r, is(1));
    }

    @Test
    void four_ops() {
        String op = "1+3*4/2";
        int r = fo.calculate(op);
        assertThat(r, is(7));

        op = "1+3*4/2-2*3";
        r = fo.calculate(op);
        assertThat(r, is(1));

        op = "-4/2+7";
        r = fo.calculate(op);
        assertThat(r, is(5));
    }

    @Test
    void parentheses() {
        String op = "(1+3)*4/2";
        int r = fo.calculate(op);
        assertThat(r, is(8));

        op = "((1+3)*(4+5))*4/2";
        r = fo.calculate(op);
        assertThat(r, is(72));

        op = "2*3/(4-2)*3";
        r = fo.calculate(op);
        assertThat(r, is(1));

        op = "2*3/(9-2)";
        r = fo.calculate(op);
        assertThat(r, is(0));
    }
}
