package com.uj.study.four_operations.bracket;

import lombok.Data;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/21 下午12:54
 * @description：
 */
@Data
public abstract class Bracket {
    public static final String PARENTHESES_LEFT = "(";
    public static final String PARENTHESES_RIGHT = ")";
    public static final String BRACKET_LEFT = "[";
    public static final String BRACKET_RIGHT = "]";
    public static final String BRACE_LEFT = "{";
    public static final String BRACE_RIGHT = "}";

    private int lIdx;
    private int rIdx;

    public Bracket(int lIdx, int rIdx) {
        this.lIdx = lIdx;
        this.rIdx = rIdx;
    }

    public String getEquation(String op) {
        return op.substring(lIdx + 1, rIdx);
    }
}
