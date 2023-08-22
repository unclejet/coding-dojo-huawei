package com.uj.study.four_operations.bracket;

import static com.uj.study.four_operations.bracket.Bracket.*;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/21 下午12:54
 * @description：
 */
public class BracketFactory {
    private BracketFactory() {
    }

    public static Bracket getBracket(String op) {
        int parL = op.lastIndexOf(PARENTHESES_LEFT);
        if (parL >= 0) {
            return new Parentheses(parL, op.indexOf(PARENTHESES_RIGHT, parL));
        }
        int brakL = op.lastIndexOf(BRACKET_LEFT);
        if (brakL >= 0) {
            return new Brackets(brakL, op.indexOf(BRACKET_RIGHT, brakL));
        }
        int braceL = op.lastIndexOf(BRACE_LEFT);
        if (braceL >= 0) {
            return new Braces(braceL, op.indexOf(BRACE_RIGHT, braceL));
        }
        return null;
    }
}
