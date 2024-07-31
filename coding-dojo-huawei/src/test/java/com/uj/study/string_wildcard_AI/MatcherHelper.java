package com.uj.study.string_wildcard_AI;

public class MatcherHelper {
    public static boolean matches(String pattern, String text, int patternIndex, int textIndex) {
        int patternLength = pattern.length();
        int textLength = text.length();

        while (patternIndex < patternLength && textIndex < textLength) {
            char p = pattern.charAt(patternIndex);
            if (p == '*') {
                // 跳过所有的 '*'
                while (patternIndex < patternLength && pattern.charAt(patternIndex) == '*') {
                    patternIndex++;
                }
                // 如果模式结束，返回 true
                if (patternIndex == patternLength) {
                    return text.substring(textIndex).matches("[a-zA-Z0-9]*");
                }
                //跳过的*后面的字符必须与text的第一个字符匹配，text*号跳过的部分只能是字母和数字
                for (int i = textIndex; i < patternIndex; i++) {
                    if (i >= textLength || pattern.charAt(patternIndex) == text.charAt(i)) {
                        continue;
                    }
                    if (!Character.isLetterOrDigit(text.charAt(textIndex))) {
                        return false;
                    }
                }
                // 尝试匹配剩余的模式
                for (int i = textIndex; i <= textLength; i++) {
                    if (matches(pattern, text, patternIndex, i)) {
                        return true;
                    }
                }
                return false;
            } else if (p == '?') {
                if (textIndex >= textLength || !text.substring(textIndex, textIndex + 1).matches("[a-zA-Z0-9]")) {
                    return false;
                }
                textIndex++;
            } else {
                if (textIndex >= textLength || !Character.toString(p).equalsIgnoreCase(text.substring(textIndex, textIndex + 1))) {
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
