package com.uj.study.decimal.binary.conversion;

import com.uj.study.common.input.LineReader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 题目描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述:
 * 输出该数值的十进制字符串。
 */
public class UserInputReaderTest {
    @Test
    void inputMustBe_hexadecimal() {
        LineReaderStub stub = new LineReaderStub();
        UserInputReader reader = new UserInputReader(stub);

        stub.simulateUserInputs("0xA");
        String[] result = reader.readHex();
        assertThat(result[0], is("0xA"));

        stub.simulateUserInputs("123");
        result = reader.readHex();
        assertThat(result[0], is(""));

        stub.simulateUserInputs("0XFF");
        result = reader.readHex();
        assertThat(result[0], is("0XFF"));

        stub.simulateUserInputs("0XG");
        result = reader.readHex();
        assertThat(result[0], is(""));
    }

    @Test
    void userCanInputMultiHexInOneLine() {
        LineReaderStub stub = new LineReaderStub();
        UserInputReader reader = new UserInputReader(stub);

        stub.simulateUserInputs("@#!$ a 0xA  123   0XFF  ");
        String[] result = reader.readHex();
        assertThat(result[0], is("0xA"));
        assertThat(result[1], is("0XFF"));
    }

    static class LineReaderStub implements LineReader {
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
