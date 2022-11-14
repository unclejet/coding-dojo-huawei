package com.uj.study.rabbit.statistic;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/14 下午12:18
 * @description：
 */
public class RabbitStatisticUserInputReaderTest extends BaseUserInputReaderTest {
    RabbitStatisticUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new RabbitStatisticUserInputReader(lineReaderStub);
    }

    @Test
    void monthInputValid() {
        lineReaderStub.simulateUserInputs("a","0","32","31");
        assertThat(reader.readMonth(), is(31));
    }
}
