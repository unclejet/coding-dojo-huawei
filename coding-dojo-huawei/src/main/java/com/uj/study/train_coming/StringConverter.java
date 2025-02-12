package com.uj.study.train_coming;

public class StringConverter {
    public static String convert(String input) {
        String trim = input.replaceAll("[,\\[\\]]", "").trim();
        return format(trim);
    }

    private static String format(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isWhitespace(c)) {
                sb.append(c);
                if (i < input.length() - 1) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}

