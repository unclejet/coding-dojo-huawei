package com.uj.study.string_wildcard_AI;

public class QuestionMarkMatcher {
    public static boolean matches(String pattern, String text, int patternIndex, int textIndex) {
        if (textIndex >= text.length() || !text.substring(textIndex, textIndex + 1).matches("[a-zA-Z0-9]")) {
            return false;
        }
        return true;
    }
}
