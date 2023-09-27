package com.uj.study.expression.evaluation.bracket;


import static com.uj.study.expression.evaluation.bracket.Bracket.PARENTHESES_LEFT;
import static com.uj.study.expression.evaluation.bracket.Bracket.PARENTHESES_RIGHT;

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

        return null;
    }
}
