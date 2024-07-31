package com.uj.study.string_wildcard_AI;

public class AsteriskMatcher {
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
                    if (StringMatcher.matchedHelper(pattern, text, patternIndex, i)) {
                        return true;
                    }
                }
                return false;
            } else {
                return StringMatcher.matchedHelper(pattern, text, patternIndex, textIndex);
            }
        }

        // 跳过剩余的 '*'
        while (patternIndex < patternLength && pattern.charAt(patternIndex) == '*') {
            patternIndex++;
        }

        return patternIndex == patternLength && textIndex == textLength;
    }

}
