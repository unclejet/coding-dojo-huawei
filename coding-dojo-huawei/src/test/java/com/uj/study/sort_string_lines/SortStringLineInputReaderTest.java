package com.uj.study.sort_string_lines;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.common.utils.RandomAlphabetGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/5 下午1:44
 * @description：
 */
public class SortStringLineInputReaderTest extends BaseUserInputReaderTest {
    private SortStringLineUserInputReader inputReader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        inputReader = new SortStringLineUserInputReader(lineReaderStub);
    }

    @Test
    void firstLine_mustInputInteger() {
        lineReaderStub.simulateUserInputs("abc", "1");
        assertThat(inputReader.readFirstLine(), is(1));
    }

    @Test
    void firstLine_mustInputInteger_between1to1000() {
        lineReaderStub.simulateUserInputs("0", "1001", "1000");
        assertThat(inputReader.readFirstLine(), is(1000));
    }

    @Test
    void inputStringLines_onlyUpperLowercase() {
        lineReaderStub.simulateUserInputs("1", "123", "abc");
        assertThat(inputReader.readMultiLines().get(0), is("abc"));
    }

    @Test
    void inputString_lessThan100() {
        lineReaderStub.simulateUserInputs("1", RandomAlphabetGenerator.generateRandomAlphabetByUUIDNoDash(101), "abc");
        assertThat(inputReader.readMultiLines().get(0), is("abc"));
    }

    @Test
    void inputTwoLines() {
        lineReaderStub.simulateUserInputs("2", "bc", "#@$%234", "AB");
        assertThat(inputReader.readMultiLines(), contains("bc", "AB"));
    }
}
