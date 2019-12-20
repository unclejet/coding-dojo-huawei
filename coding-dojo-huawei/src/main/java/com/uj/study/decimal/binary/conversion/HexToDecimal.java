package com.uj.study.decimal.binary.conversion;

import java.util.Arrays;

public class HexToDecimal {
    public static int[] hex2Dec(String[] input) {
        return Arrays.stream(input).mapToInt(s->Integer.parseInt(s.substring(2), 16)).toArray();
    }
}
