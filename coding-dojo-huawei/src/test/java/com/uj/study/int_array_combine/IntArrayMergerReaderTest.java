package com.uj.study.int_array_combine;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import com.uj.study.high_precision_integer_add.HighPrecisionIntegerReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntArrayMergerReaderTest extends BaseUserInputReaderTest {
    IntArrayMergerReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new IntArrayMergerReader(lineReaderStub);
    }

    @Test
    public void readOnePositiveNumber() {
        lineReaderStub.simulateUserInputs("a", "-1", "0", "1");
        int number = reader.readPositiveNumber();
        assertEquals(1, number);
    }

    @Test
    public void string2Array() {
        int n = 2;
        int[] result = reader.readIntArray(n,"1 2");
        assertArrayEquals(new int[]{1,2}, result);
    }


//    @Test
//    public void testReadIntArray() {
//        IntArrayMergerReader reader = new IntArrayMergerReader(lineReaderStub);
//        int[] result = reader.readIntArray();
//        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result);
//    }
}
