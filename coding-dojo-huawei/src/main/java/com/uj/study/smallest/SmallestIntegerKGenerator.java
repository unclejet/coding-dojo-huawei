package com.uj.study.smallest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SmallestIntegerKGenerator {
    public SmallestIntegerKGenerator() {
    }

    public static String format(List<Integer> smallestNumbers) {
        StringBuilder sb = new StringBuilder();
        smallestNumbers.forEach(
                s -> sb.append(s).append(" ")
        );
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    static List<Integer> smallestNumbers(int[] numArr, int n) {
        return Arrays.stream(numArr).sorted().boxed().limit(n).collect(Collectors.toList());
    }
}