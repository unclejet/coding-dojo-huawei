package com.uj.study.four_operations;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/16 下午12:35
 * @description：
 */
public class OperationsUserInputReaderTest extends BaseUserInputReaderTest {
    FourOperationsUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new FourOperationsUserInputReader(lineReaderStub);
    }

    @Test
    void input() {
        lineReaderStub.simulateUserInputs("a+b", "^", "-1+ 2", "-1+[(2+3)*4]");
        assertThat(reader.readOperation(), is("-1+[(2+3)*4]"));
    }
}
