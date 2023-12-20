package com.uj.study.binary_1_count;

public class BinaryOneCounter {

    static int count(String bin) {
        return (int) bin.codePoints().filter(c -> c == 49).count();
    }

    static String dec2Bin(String decStr) {
        return String.format("%8s", Integer.toBinaryString(Integer.parseInt(decStr))).replaceAll(" ", "0");
    }
}