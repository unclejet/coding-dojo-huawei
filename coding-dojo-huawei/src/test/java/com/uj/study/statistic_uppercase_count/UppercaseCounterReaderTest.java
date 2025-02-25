package com.uj.study.statistic_uppercase_count;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 输入描述：
 * 在一行上输入一个长度为 1≦len(s)≦250，由可见字符和空格构成的字符串 s 。
 */
public class UppercaseCounterReaderTest extends BaseUserInputReaderTest {
    UppercaseCounterReader reader;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testReadInput() {
        lineReaderStub.simulateUserInputs("", RandomAlphabetGenerator.generateRandomCharacters(251), "UPPERCASE");
        UppercaseCounterReader reader = new UppercaseCounterReader(lineReaderStub);
        assertEquals("UPPERCASE", reader.readInput());
    }
}
