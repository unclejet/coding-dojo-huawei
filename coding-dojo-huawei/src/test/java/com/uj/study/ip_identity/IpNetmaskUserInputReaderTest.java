package com.uj.study.ip_identity;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.ip_identity.io.IpNetmaskUserInputReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/4/2 上午11:49
 * @description：
 */
public class IpNetmaskUserInputReaderTest extends BaseUserInputReaderTest {
    IpNetmaskUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new IpNetmaskUserInputReader(lineReaderStub);
    }

    @Test
    void userInputShouldBe_ipWithNetmask() {
        lineReaderStub.simulateUserInputs("a.b.c.d~255.255.255.0", "1.2.~1.2.4.4", "19..0.~255.255.255.0", "192.168.0.2~255.255.255.0", "exit");
        Map<String, String> inputs = reader.readInput();
        assertThat(inputs.size(), is(2));
    }

    @Test
    void threeDotButErrorFormat() {
        lineReaderStub.simulateUserInputs("19..0.~255.255.255.0", "exit");
        Map<String, String> inputs = reader.readInput();
        assertThat(inputs.size(), is(1));
    }

    @Test
    void divideIpAndNetmask() {
        lineReaderStub.simulateUserInputs("192.168.0.2~255.255.255.0", "exit");
        Map<String, String> inputs = reader.readInput();
        assertThat(inputs, hasEntry("192.168.0.2", "255.255.255.0"));
    }
}
