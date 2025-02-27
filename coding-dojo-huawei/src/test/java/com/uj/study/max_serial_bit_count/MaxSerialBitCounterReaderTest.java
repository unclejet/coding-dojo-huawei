package com.uj.study.max_serial_bit_count;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSerialBitCounterReaderTest extends BaseUserInputReaderTest {
    MaxSerialBitCounterReader reader;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        reader = new MaxSerialBitCounterReader(lineReaderStub);
    }

    @Test
    public void testReadInput() {
        int max = 5 * (int)Math.pow(10, 5);
        lineReaderStub.simulateUserInputs("0", String.valueOf(max + 1), String.valueOf(max));
        int maxSerialBitCount = reader.readInput();
        assertEquals(max, maxSerialBitCount);
    }
}
