package com.uj.study.approximate.value;

import com.uj.study.common.utils.LineReaderStub;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：unclejet
 * @date ：Created in 2020/2/15 11:26
 * @description：
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 *
 * 输入描述:
 * 输入一个正浮点数值
 *
 * 输出描述:
 * 输出该数值的近似整数值
 *
 * 示例1
 * 输入
 * 复制
 * 5.5
 * 输出
 * 复制
 * 6
 * @modified By：
 * @version:
 */
public class UserInputReaderTest {
    @Test
    void userInput_mustBe_a_positive_floatNumber() {
        LineReaderStub stub = new LineReaderStub();
        stub.simulateUserInputs("abc", "1", "#@", "-5.5", ".1", "5.5");
        UserInputReader reader = new UserInputReader(stub);
        assertThat(reader.readAFloatNumber(), is(0.1F));
    }
}
