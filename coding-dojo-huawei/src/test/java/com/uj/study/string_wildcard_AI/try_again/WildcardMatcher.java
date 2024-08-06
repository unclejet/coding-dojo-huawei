package com.uj.study.string_wildcard_AI.try_again;

public class WildcardMatcher {
    public static boolean matched(String pattern, String text) {
        return matchMixed(pattern, text);
    }

    private static boolean matchMixed(String pattern, String text) {
        int pLen = pattern.length();
        int tLen = text.length();
        int pIndex = 0, tIndex = 0;

        while (pIndex < pLen && tIndex < tLen) {
            char pChar = pattern.charAt(pIndex);
            char tChar = text.charAt(tIndex);

            if (pChar == '*') {
                // 处理*号
                if (findNextNoAsteriskChar(pattern, pIndex) != tChar && !Character.isLetterOrDigit(tChar)) {
                    return false;
                }
                return matchAsterisk(pattern.substring(pIndex + 1), text.substring(tIndex));
            } else if (pChar == '?') {
                // 处理?号
                if (!matchQuestionMark(String.valueOf(tChar))) {
                    return false;
                }
                pIndex++;
                tIndex++;
            } else {
                // 处理普通字符
                if (Character.toLowerCase(pChar) != Character.toLowerCase(tChar)) {
                    return false;
                }
                pIndex++;
                tIndex++;
            }
        }

        // 处理剩余的*号
        while (pIndex < pLen && pattern.charAt(pIndex) == '*') {
            pIndex++;
        }

        return pIndex == pLen && tIndex == tLen;
    }

    private static boolean matchAsterisk(String pattern, String text) {
        if (pattern.isEmpty()) {
            return true;
        }
        int nextCharIndex = findNextNoAsteriskCharIdx(pattern, 0);
        if (nextCharIndex == pattern.length()) {
            return true;
        }
        char nextChar = pattern.charAt(nextCharIndex);
        for (int i = 0; i <= text.length(); i++) {
            if (i < text.length() && (Character.toLowerCase(text.charAt(i)) == Character.toLowerCase(nextChar) || nextChar == '?')) {
                if (matchMixed(pattern.substring(nextCharIndex + 1), text.substring(i + 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean matchQuestionMark(String text) {
        if (text.length() != 1) {
            return false;
        }
        char c = text.charAt(0);
        return Character.isLetterOrDigit(c);
    }

    private static int findNextNoAsteriskCharIdx(String pattern, int startIndex) {
        for (int i = startIndex; i < pattern.length(); i++) {
            if (pattern.charAt(i) != '*') {
                return i;
            }
        }
        return pattern.length();
    }

    private static char findNextNoAsteriskChar(String pattern, int startIndex) {
        for (int i = startIndex; i < pattern.length(); i++) {
            if (pattern.charAt(i) != '*') {
                return pattern.charAt(i);
            }
        }
        return '\0'; // 返回一个空字符表示没有找到非*号的字符
    }

}




