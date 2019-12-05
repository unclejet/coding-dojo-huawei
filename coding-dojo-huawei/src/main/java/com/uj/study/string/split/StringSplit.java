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
        if (result.size() == 0)
            fillAll(result);
        return result;
    }

    private static void fillAll(List<String> result) {
        for (int i = 0; i < 2; i++) {
            result.add("00000000");
        }
    }

    private static void split(String s, List<String> result) {
        String zero8 = "00000000";
        int len = s.length() / 8;
        for (int i = 0; i < len; i++) {
            result.add(s.substring(i, i + 8));
        }
        if (s.length() % 8 > 0)
            result.add(s.substring(len * 8) + zero8.substring(s.length() % 8));
    }

    private static int calculateArraySize(String[] userReaderArr) {
        int resultArrLength = 0;
        for (int i = 0; i < 2; i++) {
            String s = userReaderArr[i];
            int l = s.length() % 8 == 0 ? s.length() / 8 : (s.length() / 8) + 1;
            resultArrLength += l;
        }
        return resultArrLength;
    }
}
