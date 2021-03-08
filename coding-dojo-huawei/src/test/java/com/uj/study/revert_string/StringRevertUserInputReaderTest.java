package com.uj.study.revert_string;

import com.uj.study.common.utils.LineReaderStub;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/1/27 上午11:58
 * @description：
 */
public class StringRevertUserInputReaderTest {
    private LineReaderStub lineReaderStub;
    private StringRevertUserInputReader inputReader;

    @BeforeEach
    void setUp() {
        lineReaderStub = new LineReaderStub();
        inputReader = new StringRevertUserInputReader(lineReaderStub);
    }

    @Test
    void input_lowercaseCharacters() {
        lineReaderStub.simulateUserInputs("A", "123", "dcBa", "abcd");
        assertThat(inputReader.readLowercaseCharacters(), is("abcd"));
    }

    @Test
    void stringLength_lessThan1000() {
        lineReaderStub.simulateUserInputs(RandomAlphabetGenerator.generateRandomLowercaseCharacters(1001), "abc");
        assertThat(inputReader.readLowercaseCharacters(), is("abc"));
    }
}
