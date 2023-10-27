package com.uj.study.first_only_once_char;

import org.apache.commons.lang3.StringUtils;

public class FirstOnlyOnceCharacterFinder {
    public static String findFirstAppearedOnceChar(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (StringUtils.countMatches(s, chars[i]) == 1)
                return String.valueOf(chars[i]);
        }
        return "-1";
    }
}