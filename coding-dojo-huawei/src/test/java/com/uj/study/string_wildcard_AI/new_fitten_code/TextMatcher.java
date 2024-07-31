package com.uj.study.string_wildcard_AI.new_fitten_code;

public class TextMatcher {

    public static boolean matched(String pattern, String text) {
        MatchStrategy strategy = MatchStrategyFactory.getStrategy(pattern);
        return strategy.matches(text);
    }
}



