package com.uj.study.lastwordlength;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开
 * 输入描述:
 *字符串非空，长度要不大于5000
 * 输出描述:
 * 整数N，最后一个单词的长度
 */
class LastWordLengthTest {

    private LastWordLength lastWordLength;

    @BeforeEach
    void setUp() {
        lastWordLength = new LastWordLength();
    }

    @Test
    void givenStringIsEmpty_thenThrowIllLegalException() {
        var exception = assertThrows(IllegalArgumentException.class, ()-> lastWordLength.calculateLastWordLength(""));
        assertEquals("invalid input", exception.getMessage());
    }

    @Test
    void givenOneWord() {
        assertEquals("abc".length(), lastWordLength.calculateLastWordLength("abc"));
        assertEquals("abc".length(), lastWordLength.calculateLastWordLength("   abc"));
        assertEquals("abc".length(), lastWordLength.calculateLastWordLength("    abc    "));
    }

    @Test
    void givenTwoWord() {
        assertEquals("abc".length(), lastWordLength.calculateLastWordLength("cccc abc"));
//        assertEquals("abc".length(), lastWordLength.calculateLastWordLength("   abc"));
//        assertEquals("abc".length(), lastWordLength.calculateLastWordLength("    abc    "));
    }

    @Test
    void givenAllWord() {
        assertEquals("abcd".length(), lastWordLength.calculateLastWordLength("abc abcd"));
        assertEquals("abcd".length(), lastWordLength.calculateLastWordLength(" ewrwe sdf3 sefsd s3e3  abcd"));
        assertEquals("abcd".length(), lastWordLength.calculateLastWordLength("  sdfdser  abc   abcd "));
    }

    @Test
    void givenWordEquals5000() {
        String input = getRandomString(5000);
        assertDoesNotThrow(()-> lastWordLength.calculateLastWordLength(input));
    }

    @Test
    void givenWordMoreThan5000() {
        String input = getRandomString(5001);
        var exception = assertThrows(IllegalArgumentException.class, ()-> lastWordLength.calculateLastWordLength(input));
        assertEquals("invalid input", exception.getMessage());
    }


    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}