package com.uj.study.string_wildcard_AI;

public class ExactMatcher {
    public static boolean matches(String pattern, String text, int patternIndex, int textIndex) {
        if (textIndex >= text.length() || !Character.toString(pattern.charAt(patternIndex)).equalsIgnoreCase(text.substring(textIndex, textIndex + 1))) {
            return false;
        }
        return true;
    }
}