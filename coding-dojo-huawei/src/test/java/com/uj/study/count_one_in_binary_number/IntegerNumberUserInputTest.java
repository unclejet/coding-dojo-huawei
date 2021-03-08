package com.uj.study.count_one_in_binary_number;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/22 上午11:40
 * @description：
 */
public class IntegerNumberUserInputTest extends BaseUserInputReaderTest {
    private IntegerNumberUserInputReader inputReader;
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        inputReader = new IntegerNumberUserInputReader(lineReaderStub);
    }

    @Test
    void inputIsAInteger() {
        lineReaderStub.simulateUserInputs("abc", "0.5", "5");
        assertThat(inputReader.readInteger(), is(5));
    }
}
