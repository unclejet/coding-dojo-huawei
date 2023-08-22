package com.uj.study.four_operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/7/12 下午12:42
 * @description：
 * 描述
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 *
 * 数据范围：表达式计算结果和过程中满足 ∣val∣≤1000 ∣val∣≤1000  ，字符串长度满足 1≤n≤1000 1≤n≤1000
 * 输入描述：
 *
 * 输入一个算术表达式
 * 输出描述：
 *
 * 得到计算结果
 * 示例1
 * 输入：
 *
 * 3+2*{1+2*[-4/(8-6)+7]}
 *
 * 输出：
 *
 * 25
 *
 *
 * add, subtract, multiply and divide
 * 操作数：operand
 * 操作符：operator
 * 算式：equation
 * 加减乘除是最简单的互动关系，先从简单的开始
 * 其次是先乘除，后加减
 * 再其次才是连加之类的多个操作符
 * 最后是括号框定的优先级
 * 小括号： parentheses
 * 中括号：bracket
 * 大括号：brace
 */
public class OperationsTest {
    private Operations fo;

    @BeforeEach
    void setUp() {
        fo = new Operations();
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

    @Test
    void bracket() {
        String op = "[1+3]*4/2";
        int r = fo.calculate(op);
        assertThat(r, is(8));

        op = "[[1+3]*[4+5]]*4/2";
        r = fo.calculate(op);
        assertThat(r, is(72));
    }

    @Test
    void brace() {
        String op = "{1+3}*4/2";
        int r = fo.calculate(op);
        assertThat(r, is(8));

        op = "{{1+3}*{4+5}}*4/2";
        r = fo.calculate(op);
        assertThat(r, is(72));
    }

    @Test
    void parentheses_and_bracket() {
        String op = "2*[4/(8-6)+7]";
        int r = fo.calculate(op);
        assertThat(r, is(18));
    }

    @Test
    void parentheses_and_brace() {
        String op = "2*{4/(8-6)+7}";
        int r = fo.calculate(op);
        assertThat(r, is(18));
    }

    @Test
    void bracket_and_brace() {
        String op = "3+2*{1+2*[6+7]}";
        int r = fo.calculate(op);
        assertThat(r, is(57));
    }

    @Test
    void fourOperations() {
        String op = "3+2*{1+2*[4/(8-6)+7]}";
        int r = fo.calculate(op);
        assertThat(r, is(41));

        op = "3+2*{1+2*[-4/(8-6)+7]}";
        r = fo.calculate(op);
        assertThat(r, is(25));
    }
}
