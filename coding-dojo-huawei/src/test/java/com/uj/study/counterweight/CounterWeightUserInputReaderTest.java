package com.uj.study.counterweight;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/12/14 下午12:21
 * @description：
 */
public class CounterWeightUserInputReaderTest extends BaseUserInputReaderTest {
    CounterWeightUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new CounterWeightUserInputReader(lineReaderStub);
    }

    @Test
    void typeNumberValid() {
        lineReaderStub.simulateUserInputs("a", "0", "11", "1");
        assertThat(reader.readTypeNumber(), is(1));
    }

    @Test
    void weightValid() {
        lineReaderStub.simulateUserInputs("a b", "1 2 3", "0 1", "1 2001", "1   2000");
        assertThat(reader.readWeight(2), contains(1, 2000));
    }

    @Test
    void quantitiesValid() {
        lineReaderStub.simulateUserInputs("a b", "1 2 3", "0 10", "0 9", "1 11", "1 10");
        assertThat(reader.readQuantities(2), contains(1, 10));
    }
}
