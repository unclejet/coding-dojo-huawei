package com.uj.study.high_precision_integer_add;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HighPrecisionIntegerAdder {
    public HighPrecisionIntegerAdder() {
    }

    public static String add(String a, String b) {
        StringBuilder result = new StringBuilder();
        List<Integer> longList = a.length() >= b.length() ? generateReverseIntegerList(a) : generateReverseIntegerList(b);
        List<Integer> shortList = b.length() <= a.length() ? generateReverseIntegerList(b) : generateReverseIntegerList(a);

        boolean isCarryOver = false;
        for (int i = 0, data; i < longList.size(); i++) {
            data = shortList.size() > i ? longList.get(i) + shortList.get(i) : longList.get(i);
            if (isCarryOver) {
                data++;
                isCarryOver = false;
            }
            if (data >= 10) {
                result.append(String.valueOf(data).substring(1));
                isCarryOver = true;
            } else {
                result.append(data);
            }
        }
        if (isCarryOver) {
            result.append("1");
        }
        return result.reverse().toString();
    }

    private static List<Integer> generateReverseIntegerList(String a) {
        List<Integer> aList = Arrays.stream(a.split("")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
        Collections.reverse(aList);
        return aList;
    }
}