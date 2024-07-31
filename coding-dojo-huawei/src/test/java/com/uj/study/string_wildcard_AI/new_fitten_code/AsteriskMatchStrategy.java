package com.uj.study.string_wildcard_AI.new_fitten_code;

public class AsteriskMatchStrategy implements MatchStrategy {

    private final String pattern;

    public AsteriskMatchStrategy(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean matches(String text) {
        if (isAllAsterisks(pattern)) {
            return matchesAsterisk(text);
        } else if (pattern.startsWith("*") && pattern.length() > 1) {
            return matchesAsteriskSuffix(text);
        } else if (pattern.endsWith("*") && pattern.length() > 1) {
            return matchesPrefixAsterisk(text);
        } else if (pattern.contains("*") && pattern.length() > 1) {
            return matchesComplexPattern(text);
        }
        return false;
    }

    private boolean isAllAsterisks(String pattern) {
        for (char c : pattern.toCharArray()) {
            if (c != '*') {
                return false;
            }
        }
        return true;
    }

    private boolean matchesAsterisk(String text) {
        for (char c : text.toCharArray()) {
            if (!StringUtils.isAlphanumeric(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean matchesAsteriskSuffix(String text) {
        String suffix = pattern.substring(1);
        return text.toLowerCase().endsWith(suffix.toLowerCase()) && isAlphanumericPrefix(text, suffix.length());
    }

    private boolean matchesPrefixAsterisk(String text) {
        String prefix = pattern.substring(0, pattern.length() - 1);
        return text.toLowerCase().startsWith(prefix.toLowerCase()) && isAlphanumericSuffix(text, prefix.length());
    }


    private boolean matchesComplexPattern(String text) {
        String[] parts = pattern.split("\\*");
        if (parts.length == 2) {
            String prefix = parts[0];
            String suffix = parts[1];
            return text.startsWith(prefix) && text.endsWith(suffix) && isAlphanumericMiddle(text, prefix.length(), suffix.length());
        }
        return false;
    }

    private boolean isAlphanumericPrefix(String text, int suffixLength) {
        for (int i = 0; i < text.length() - suffixLength; i++) {
            if (!StringUtils.isAlphanumeric(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphanumericSuffix(String text, int prefixLength) {
        for (int i = prefixLength; i < text.length(); i++) {
            if (!StringUtils.isAlphanumeric(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphanumericMiddle(String text, int prefixLength, int suffixLength) {
        for (int i = prefixLength; i < text.length() - suffixLength; i++) {
            if (!StringUtils.isAlphanumeric(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

