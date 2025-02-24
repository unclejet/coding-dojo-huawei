package com.uj.study.true_fractions_into_egyptian_fractions;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.apache.commons.lang3.math.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 输入描述：
 *  * 以 a/b 的格式输入一个分数 abba​，其中 1≦a<b≦1001≦a<b≦100。不保证分数为最简分数。
 */
public class TrueFractions2EgyptianReaderTest extends BaseUserInputReaderTest {
    TrueFractions2EgyptianReader reader;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        reader = new TrueFractions2EgyptianReader(lineReaderStub);

    }

    @Test
    public void testReadFraction() {
        lineReaderStub.simulateUserInputs("a", "0/2", "2/0", "101/100", "1 /2", "1/100");
        Fraction expected = Fraction.getFraction(1, 100);
        Fraction actual = reader.readFraction();
        assertEquals(expected, actual);
    }
}
