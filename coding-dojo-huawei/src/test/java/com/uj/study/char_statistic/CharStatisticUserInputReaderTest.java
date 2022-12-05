package com.uj.study.char_statistic;

import com.uj.study.chorus.ChorusUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/12/5 下午12:17
 * @description：
 */
public class CharStatisticUserInputReaderTest extends ChorusUserInputReaderTest {
    CharStatisticUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new CharStatisticUserInputReader(lineReaderStub);
    }

    @Test
    void inputString() {
        lineReaderStub.simulateUserInputs("sdfxc cxvds e324#@#@!");
        assertThat(reader.readString(), is("sdfxc cxvds e324#@#@!"));
    }
}
