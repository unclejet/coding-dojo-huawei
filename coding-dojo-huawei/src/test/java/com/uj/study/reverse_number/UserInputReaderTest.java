package com.uj.study.reverse_number;

import com.uj.study.common.utils.LineReaderStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/1/26 上午11:41
 * @description：
 */
public class UserInputReaderTest {
    private LineReaderStub lineReaderStub;
    private ReverseNumberUserInputReader userInputReader;

    @BeforeEach
    void setUp() {
        lineReaderStub = new LineReaderStub();
        userInputReader = new ReverseNumberUserInputReader(lineReaderStub);
    }

    @Test
    void inputIsPositiveNumber() {
        lineReaderStub.simulateUserInputs("-10", "100");
        assertThat(userInputReader.readNumberStr(), is("100"));
    }
}
