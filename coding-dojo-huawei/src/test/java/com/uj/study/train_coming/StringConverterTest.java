package com.uj.study.train_coming;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringConverterTest {

    @Test
    void testConvertSingleElement() {
        String input = "[1]";
        String expected = "1";
        String actual = StringConverter.convert(input);
        assertEquals(expected, actual);
    }

    @Test
    void testConvertMultipleElements() {
        String input = "[1,2,3]";
        String expected = "1 2 3";
        String actual = StringConverter.convert(input);
        assertEquals(expected, actual);
    }

    @Test
    void testConvertWithSpaces() {
        String input = "[ 1, 2, 3 ]";
        String expected = "1 2 3";
        String actual = StringConverter.convert(input);
        assertEquals(expected, actual);
    }

    @Test
    void testConvertEmptyString() {
        String input = "[]";
        String expected = "";
        String actual = StringConverter.convert(input);
        assertEquals(expected, actual);
    }

    @Test
    void testConvertNoBrackets() {
        String input = "1,2,3";
        String expected = "1 2 3";
        String actual = StringConverter.convert(input);
        assertEquals(expected, actual);
    }

    @Test
    void testConvertMixedCharacters() {
        String input = "[a,b,c]";
        String expected = "a b c";
        String actual = StringConverter.convert(input);
        assertEquals(expected, actual);
    }

    @Test
    void testConvertSpecialCharacters() {
        String input = "[!,@,#]";
        String expected = "! @ #";
        String actual = StringConverter.convert(input);
        assertEquals(expected, actual);
    }
}

