package com.uj.study.matrix_multiply_computation;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/3/21 下午12:47
 * @description：
 */
public class InvalidMultiRuleException extends RuntimeException {
    private String rule;

    public InvalidMultiRuleException(String rule) {
        this.rule = rule;
    }

    @Override
    public String toString() {
        return "InvalidMultiRuleException{" +
                "rule='" + rule + '\'' +
                '}' + "PARENTHESES not matched or only one character";
    }
}
