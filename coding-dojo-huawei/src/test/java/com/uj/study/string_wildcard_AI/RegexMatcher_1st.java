package com.uj.study.string_wildcard_AI;

public class RegexMatcher_1st {
    public static boolean matched(String regex, String text) {
        if (regex.equals("**")) {
            return isValidText(regex, text);
        } else if (regex.equals("*")) {
            return isValidText(regex, text);
        } else if (regex.contains("*")) {
            return matchAsteriskRegex(regex, text);
        } else if (regex.contains("?")) {
            return matchQuestionMarkRegex(regex, text);
        } else if (regex.length() == 1 && text.length() == 1) {
            return regex.equalsIgnoreCase(text);
        } else if (regex.length() == 1 && text.length() > 1) {
            return false;
        } else {
            return regex.equalsIgnoreCase(text);
        }
    }

    private static boolean matchAsteriskRegex(String regex, String text) {
        if (!isValidText(regex, text)) {
            return false;
        }
        String[] parts = regex.split("\\*");
        int index = 0;
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.isEmpty()) {
                continue;
            }
            if (i == parts.length - 1) {
                return text.toLowerCase().endsWith(part.toLowerCase());
            } else {
                index = text.toLowerCase().indexOf(part.toLowerCase(), index);
                if (index == -1) {
                    return false;
                }
                index += part.length();
            }
        }
        return true;
    }

    private static boolean matchQuestionMarkRegex(String regex, String text) {
        if (!isValidText(text)) {
            return false;
        }
        String[] parts = regex.split("\\?");
        int index = 0;
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.isEmpty()) {
                if (index >= text.length() || !isValidChar(text.charAt(index))) {
                    return false;
                }
                index++;
                continue;
            }
            if (i == parts.length - 1) {
                return text.toLowerCase().endsWith(part.toLowerCase());
            } else {
                index = text.toLowerCase().indexOf(part.toLowerCase(), index);
                if (index == -1) {
                    return false;
                }
                index += part.length();
            }
        }
        return true;
    }

    private static boolean isValidText(String regex, String text) {
        for (char c : text.toCharArray()) {
            if (!isValidChar(c)) {
                return regex.contains(String.valueOf(c));
            }
        }
        return true;
    }

    private static boolean isValidText(String text) {
        if (text.isEmpty())
            return false;
        for (char c : text.toCharArray()) {
            if (!isValidChar(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidChar(char c) {
        return Character.isLetterOrDigit(c);
    }
}








