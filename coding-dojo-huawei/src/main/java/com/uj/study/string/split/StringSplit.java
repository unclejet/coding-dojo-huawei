package com.uj.study.string.split;

import java.util.ArrayList;
import java.util.List;

public final class StringSplit {
    public static List<String> splitString(String[] userReaderArr) {
        assert userReaderArr.length == 2;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            split(userReaderArr[i], result);
        }
        return result;
    }

    private static void split(String s, List<String> result) {
        String zero8 = "00000000";
        if (s.isEmpty())
            result.add(zero8);
        int len = s.length() / 8;
        for (int i = 0; i < len; i++) {
            result.add(s.substring(i * 8, (i * 8) + 8));
        }
        if (s.length() % 8 > 0)
            result.add(s.substring(len * 8) + zero8.substring(s.length() % 8));
    }
}
