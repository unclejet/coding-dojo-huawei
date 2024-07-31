package com.uj.study.string_wildcard_AI;

public class StringMatcher {
    public static boolean matched(String pattern, String text) {
        return matchedHelper(pattern, text, 0, 0);
    }

    public static boolean matchedHelper(String pattern, String text, int patternIndex, int textIndex) {
        int patternLength = pattern.length();
        int textLength = text.length();

        while (patternIndex < patternLength && textIndex < textLength) {
            char p = pattern.charAt(patternIndex);
            if (p == '*') {
                return AsteriskMatcher.matches(pattern, text, patternIndex, textIndex);
            } else if (p == '?') {
                if (!QuestionMarkMatcher.matches(pattern, text, patternIndex, textIndex)) {
                    return false;
                }
                textIndex++;
            } else {
                if (!ExactMatcher.matches(pattern, text, patternIndex, textIndex)) {
                    return false;
                }
                textIndex++;
            }
            patternIndex++;
        }

        // 跳过剩余的 '*'
        while (patternIndex < patternLength && pattern.charAt(patternIndex) == '*') {
            patternIndex++;
        }

        return patternIndex == patternLength && textIndex == textLength;
    }
}





