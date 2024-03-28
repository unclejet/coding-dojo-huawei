package com.uj.study.matrix_multiply_computation;

import java.util.*;

public class MatrixMultiCounter {
    private Map<String, Matrix> alphabetMatrix;
    private String rule;

    public static final String PARENTHESES_LEFT = "(";
    public static final String PARENTHESES_RIGHT = ")";

    public List<String> getRules() {
        return rules;
    }

    private List<String> rules;

    public MatrixMultiCounter(Map<String, Matrix> matrix, String rule) {
        alphabetMatrix = matrix;
        this.rule = rule;
        rules = new ArrayList<String>();
    }

    public int count() {
        int c = 0;
        parseMultiplyRule(rule);
        Matrix curMatrix = alphabetMatrix.get(rules.get(0));
        for (int i = 1; i < rules.size(); i++) {
            Matrix next = alphabetMatrix.get(rules.get(i));
            c += multiCount(curMatrix, next);
            curMatrix = new Matrix(curMatrix.getRow(), next.getColumn());
        }
        return c;
    }

    void parseMultiplyRule(String rule) {
        checkRule(rule);
        String order = rule;
        int pl = rule.lastIndexOf(PARENTHESES_LEFT);
        int pr = rule.indexOf(PARENTHESES_RIGHT, pl);

        if (pl >= 0 && pr >= 0) {
            order = rule.substring(pl + 1, pr);
            rule = formatRule(pl, pr, rule);
        }

        rules.addAll(Arrays.asList(order.split("")));
        pl = rule.lastIndexOf(PARENTHESES_LEFT);
        if (pl >= 0) {
            parseMultiplyRule(rule);
        }
        if (rules.size() == 1)
            throw new InvalidMultiRuleException(rule);
    }

    void checkRule(String rule) {
        long countL = rule.chars().filter(ch -> ch == '(').count();
        long countR = rule.chars().filter(ch -> ch == ')').count();
        if (countL != countR)
            throw new InvalidMultiRuleException(rule);
    }

    String formatRule(int leftIdx, int rightIdx, String rule) {
        String part1 = rule.substring(0, leftIdx);
        String part2 = rule.substring(rightIdx + 1);
        return part1 + part2;
    }

    int multiCount(Matrix m1, Matrix m2) {
        if (m1.getColumn() == m2.getRow())
            return m1.getRow() * m1.getColumn() * m2.getColumn();
        else if (m1.getRow() == m2.getColumn())
            return m1.getColumn() * m2.getRow() * m2.getColumn();
        throw new InvalidMatrixRuleException(m1, m2);
    }
}