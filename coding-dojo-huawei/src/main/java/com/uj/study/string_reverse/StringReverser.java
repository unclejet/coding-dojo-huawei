package com.uj.study.string_reverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/8/10 下午12:40
 * @description：
 */
public class StringReverser {
    public static String reverse(String str) {
        List<String> list = extractWords(str);
        Collections.reverse(list);
        return String.join(" ", list);
    }

    public static List<String> extractWords(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isAlphabet(chars[i])) {
                sb.append(chars[i]);
            }
            else if (sb.length() > 0) {
                result.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() > 0)
            result.add(sb.toString());
        return result;
    }

    private static boolean isAlphabet(char c) {
        return Character.isLowerCase(c) || Character.isUpperCase(c);
    }
}
