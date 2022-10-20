package com.uj.study.ip_number_transition;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/10/17 下午12:25
 * @description：
 */
public class IpUserInputReaderTest extends BaseUserInputReaderTest {
    IpUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new IpUserInputReader(lineReaderStub);
    }

    @Test
    void inputIsIp() {
        lineReaderStub.simulateUserInputs("10", "10.0.3", "a.b.c.d", "10.0.3.256", "10.0.3.130");
        assertThat(reader.readIp(), is("10.0.3.130"));
    }
}
