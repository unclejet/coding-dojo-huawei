package com.uj.study.string_wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/5/7 下午12:28
 * @description：
 */
public class Wildcard {
    private Indicator indicator;
    private List<Token> regTokens;
    private List<Token> txtTokens;

    private void init(String regex, String text) {
        regTokens = TokenFactory.parse(regex);
        txtTokens = TokenFactory.parse(text);
        indicator = new Indicator();
    }

    public boolean matched(String regex, String text) {
        init(regex, text);
        return regTokens.stream().allMatch(token -> token.match(indicator, txtTokens)) &&
                indicator.getTxtIdx() == text.length();
    }
}
