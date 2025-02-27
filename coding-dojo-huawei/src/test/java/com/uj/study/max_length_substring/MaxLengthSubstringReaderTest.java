package com.uj.study.max_length_substring;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 输入描述：
 * 在一行上输入一个长度为 1≦len(s)≦350、仅由小写字母构成的字符串 s。
 */
public class MaxLengthSubstringReaderTest extends BaseUserInputReaderTest {
    MaxLengthSubstringReader maxLengthSubstringReader;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        maxLengthSubstringReader = new MaxLengthSubstringReader(lineReaderStub);
    }

    @Test
    public void testRead() {
        lineReaderStub.simulateUserInputs("", RandomAlphabetGenerator.generateRandomLowercaseCharacters(351), "UPPERCASE", "z");
        String result = maxLengthSubstringReader.read();
        assertEquals("z", result);
    }
}
