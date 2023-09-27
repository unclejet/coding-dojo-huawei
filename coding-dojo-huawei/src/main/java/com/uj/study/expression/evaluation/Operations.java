package com.uj.study.expression.evaluation;


import com.uj.study.expression.evaluation.arithmetic.Arithmetic;
import com.uj.study.expression.evaluation.arithmetic.ArithmeticFactory;
import com.uj.study.expression.evaluation.bracket.Bracket;
import com.uj.study.expression.evaluation.bracket.BracketFactory;

import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/7/12 下午12:58
 * @description：
 */
public class Operations {
    public static final Pattern OPERATOR_PATTERN = Pattern.compile("[\\+\\-\\*\\/]");
    public static final Pattern PAR_PATTERN = Pattern.compile("[\\(\\[\\{]");

    private int result = -1;

    public int calculate(String op) {
        Bracket bracket = BracketFactory.getBracket(op);
        if (bracket != null) {
            arithmetic(bracket.getEquation(op));
            op = formatOp(bracket.getLIdx(), bracket.getRIdx(), op);
        }
        if (hasBracket(op)) {
            calculate(op);
        }
        else {
            arithmetic(op);
        }
        return result;
    }

    private boolean hasBracket(String op) {
        return PAR_PATTERN.matcher(op).find();
    }

    public int arithmetic(String op) {
        Arithmetic arithmetic = ArithmeticFactory.getArithmetic(op);
        result = arithmetic.calculate();
        op = formatOp(arithmetic, op);
        if (hasOperator(op)) {
            arithmetic(op);
        }
        return result;
    }

    private String formatOp(Arithmetic ar, String op) {
        String part1 = op.substring(0, ar.getOp1().getIndex());
        String part2 = op.substring(ar.getOptIdx() + ar.getOp2().getLength() + 1);
        return String.format("%s%s%s", part1, result, part2);
    }

    private String formatOp(int leftIdx, int rightIdx, String op) {
        String part1 = op.substring(0, leftIdx);
        String part2 = op.substring(rightIdx + 1);
        return String.format("%s%s%s", part1, result, part2);
    }

    private boolean hasOperator(String op) {
        return OPERATOR_PATTERN.matcher(op).find() &&
                (op.startsWith("-") ? OPERATOR_PATTERN.matcher(op).find(1) : true);
    }
}
