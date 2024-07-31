package com.uj.study.string_wildcard_AI.new_fitten_code;

public class SimpleMatchStrategy implements MatchStrategy {
    private final String pattern;

    public SimpleMatchStrategy(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean matches(String text) {
        return pattern.equalsIgnoreCase(text);
    }
}
