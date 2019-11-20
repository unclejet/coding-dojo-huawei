package com.uj.study.mingming_random;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Business
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，
 * 他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
 * 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
 * 请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 *
 * Input Param
 *
 * n               输入随机数的个数
 *
 * inputArray      n个随机整数组成的数组
 *
 *
 * Return Value
 *
 * OutputArray    输出处理后的随机整数
 *
 * 输入描述:
 * 输入多行，先输入随机整数的个数，再输入相应个数的整数
 *
 * 输出描述:
 * 返回多行，处理后的结果
 */
public class MingMingRandomTest {
    @Test
    void inputArraySize_ShouldBeNumber() {
        LineReaderStub stub = new LineReaderStub();
        stub.simulateUserInputs("abc", "@$#E", "11");
        UserInputReader reader = new UserInputReader(stub);
        assertThat(reader.readArraySize(), is(11));
    }

    @Test
    void createArrayFromUserInput() {
        LineReaderStub stub = new LineReaderStub();
        stub.simulateUserInputs("try", "10", "15", "abc", "30", "40");
        UserInputReader reader = new UserInputReader(stub);
        int[] array = reader.createArray(3);
        assertThat(array, is(new int[]{10, 15, 30}));
    }

    private class LineReaderStub implements LineReader {
        List<String> userInputs = new ArrayList<>();
        private int readOffset = 0;

        @Override
        public String readLine() {
            return userInputs.get(readOffset++);
        }

        void simulateUserInputs(String... inputs) {
            reset();
            Arrays.stream(inputs).forEach(str->userInputs.add(str));
        }

        private void reset() {
            readOffset = 0;
            userInputs.clear();
        }
    }
}
