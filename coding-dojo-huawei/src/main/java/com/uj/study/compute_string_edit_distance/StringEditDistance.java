package com.uj.study.compute_string_edit_distance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/9/1 下午12:49
 * @description：
 */
public class StringEditDistance {
    public static int calculate(String a, String b) {
        int count;
        if (a.length() == b.length()) {
            count = substitute(a, b);
        } else {
            Operation deleter = delete(a, b);
            int subCnt = substitute(deleter.getData(), b);
            int delCnt = deleter.getCount() + subCnt;

            Operation adder = add(a, b);
            subCnt = substitute(adder.getData(), a);
            int addCnt = adder.getCount() + subCnt;
            count = min(delCnt, addCnt);
        }
        return count;
    }

    private static Operation add(String a, String b) {
        String handle = shortStr(a, b);
        String target = longStr(a, b);
        String appendStr = target.substring(handle.length());
        int count = target.length() - handle.length();
        return new Operation(count, handle + appendStr);
    }

    private static String longStr(String a, String b) {
        return a.length() >= b.length() ? a : b;
    }

    private static String shortStr(String a, String b) {
        return a.length() <= b.length() ? a : b;
    }

    private static int min(int cnt1, int cnt2) {
        return cnt1 > cnt2 ? cnt2 : cnt1;
    }

    private static Operation delete(String a, String b) {
        String handle = longStr(a, b);
        String target = shortStr(a, b);
        int count = 0;
        List<String> listHandle = Arrays.stream(handle.split("")).collect(Collectors.toList());
        List<String> listHandleCopy = new ArrayList<>(listHandle);
        for (String s: listHandle) {
            if (!target.contains(s)) {
                listHandleCopy.remove(s);
                count++;
            }
        }

        String collect = listHandleCopy.stream().collect(Collectors.joining());
        if (collect.length() > target.length()) {
            count += collect.length() - target.length();
            collect = collect.substring(0, target.length());
        }
        return new Operation(count, collect);
    }

    private static int substitute(String a, String b) {
        int count = 0;
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        for (int i = 0; i < aChars.length; i++) {
            if (bChars[i] != aChars[i]) {
                bChars[i] = aChars[i];
                count++;
            }
        }
        return String.copyValueOf(aChars).equals(String.copyValueOf(bChars)) ? count : -1;
    }
}
