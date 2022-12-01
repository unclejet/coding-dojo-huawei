package com.uj.study.ip_is_same_subnet;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.uj.study.common.input.BaseUserInputReader.EXIT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/30 下午12:10
 * @description：
 */
public class IpSameSubnetUserInputReaderTest extends BaseUserInputReaderTest {
    IpSameSubnetUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new IpSameSubnetUserInputReader(lineReaderStub);
    }

    @Test
    void read3Ips() {
        lineReaderStub.simulateUserInputs("255.255.255.0", "192.168.224.256", "192.168.10.4", EXIT);
        assertThat(reader.readIps(), contains("255.255.255.0", "192.168.224.256", "192.168.10.4"));
    }

    @Test
    void read1Ips() {
        lineReaderStub.simulateUserInputs("255.255.255.0",  EXIT);
        assertThat(reader.readIps(), contains("255.255.255.0", "", ""));
    }

    @Test
    void read2Ips() {
        lineReaderStub.simulateUserInputs("255.255.255.0",  "192.168.224.256", EXIT);
        assertThat(reader.readIps(), contains("255.255.255.0", "192.168.224.256", ""));
    }

    @Test
    void read4Ips() {
        lineReaderStub.simulateUserInputs("255.255.255.0", "192.168.224.256", "192.168.10.4", "255.0.0.0", EXIT);
        assertThat(reader.readIps(), contains("255.255.255.0", "192.168.224.256", "192.168.10.4", "255.0.0.0", "", ""));
    }
}
