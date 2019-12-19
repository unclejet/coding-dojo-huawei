package com.uj.study.decimal.binary.conversion;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HexToDecimalTest {
    @Test
    void hex2Dec() {
        String[] input = {"0xA", "0Xff", "0xf"};
        int[] result = HexToDecimal.hex2Dec(input);
        assertThat(result[0], is(10));
        assertThat(result[1], is(255));
        assertThat(result[2], is(15));
    }
}
