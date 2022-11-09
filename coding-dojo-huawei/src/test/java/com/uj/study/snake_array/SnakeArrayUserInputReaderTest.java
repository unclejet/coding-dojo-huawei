package com.uj.study.snake_array;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/1 下午12:11
 * @description：
 */
public class SnakeArrayUserInputReaderTest extends BaseUserInputReaderTest {
    SnakeArrayUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new SnakeArrayUserInputReader(lineReaderStub);
    }

    @Test
    void name() {
        lineReaderStub.simulateUserInputs("a", "0", "101", "100");
        assertThat(reader.readNumber(), is(100));
    }
}
