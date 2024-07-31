package com.uj.study.string_wildcard_AI.new_fitten_code;

public class QuestionMarkMatchStrategy implements MatchStrategy {
    private final String pattern;

    public QuestionMarkMatchStrategy(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean matches(String text) {
        if (isAllQuestionMarks(pattern)) {
            int questionMarkCount = countQuestionMarks(pattern);
            return matchesQuestionMark(text, questionMarkCount);
        } else if (pattern.contains("?")) {
            return matchesComplexPattern(text);
        }
        return false;
    }

    private boolean isAllQuestionMarks(String pattern) {
        for (char c : pattern.toCharArray()) {
            if (c != '?') {
                return false;
            }
        }
        return true;
    }

    private int countQuestionMarks(String pattern) {
        return pattern.length();
    }

    private boolean matchesQuestionMark(String text, int questionMarkCount) {
        if (text.length() != questionMarkCount) {
            return false;
        }
        for (char c : text.toCharArray()) {
            if (!StringUtils.isAlphanumeric(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean matchesComplexPattern(String text) {
        int questionMarkIndex = pattern.indexOf('?');
        if (questionMarkIndex == -1) {
            return false;
        }

        String prefix = pattern.substring(0, questionMarkIndex);
        String suffix = pattern.substring(questionMarkIndex + 1);

        if (prefix.length() + suffix.length() + 1 != text.length()) {
            return false;
        }

        if (!text.substring(0, questionMarkIndex).equalsIgnoreCase(prefix) || !text.substring(questionMarkIndex + 1).equalsIgnoreCase(suffix)) {
            return false;
        }

        if (!StringUtils.isAlphanumeric(text.charAt(questionMarkIndex))) {
            return false;
        }

        return true;
    }

}
