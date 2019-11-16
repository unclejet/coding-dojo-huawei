package com.uj.study.countcharinstring;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
/**
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串
 * 第二行输入一个字符.
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数.
 */
public class CharInStringCounterTest {


    public static final String STRING1 = "random string";
    public static final String CHAR_A = "a";

    @Test
    void userMustInputTwoLines() {
        LineReaderStub stub = new LineReaderStub();
        stub.simulateUserInputs(STRING1, CHAR_A);
        UserInputReader reader = new UserInputReader(stub);
        String firstLine = reader.readFirstLine();
        String secondLine = reader.readSecondLine();
        assertEquals(STRING1, firstLine);
        assertEquals(CHAR_A, secondLine);
    }

    @Test
    void firstLineMustBe_Char_number_space() {
        assertTrue(false);
    }
}
