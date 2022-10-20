package com.uj.study.ip_number_transition;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/10/18 下午12:27
 * @description：
 */
public class NumberUserInputReaderTest extends BaseUserInputReaderTest {
    NumberUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new NumberUserInputReader(lineReaderStub);
    }

    @Test
    void validNumber() {
        lineReaderStub.simulateUserInputs("-1", "4294967295", "10");
        assertThat(reader.readNumber(), is(10l));
    }
}
