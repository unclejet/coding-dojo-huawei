package com.uj.study.string_wildcard_AI.new_fitten_code;

public class MatchStrategyFactory {
    public static MatchStrategy getStrategy(String pattern) {
        if (pattern.contains("*")) {
            return new AsteriskMatchStrategy(pattern);
        } else if (pattern.contains("?"))  {
            return new QuestionMarkMatchStrategy(pattern);
        } else {
            return new SimpleMatchStrategy(pattern);
        }
    }
}


