package com.uj.study.string_wildcard_AI;

public class RegexMatcher {

    public static boolean matched(String regex, String text) {
        // 简单的直接匹配
        return regex.equalsIgnoreCase(text);
    }
}
