package com.uj.study.password_crack;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/17 下午12:15
 * @description：
 */
public class NumberTransFormer extends PwdTransformer {
    public NumberTransFormer(PwdTransformer nextTransformer) {
        super(nextTransformer);
    }

    @Override
    public char handle(char c) {
        return c;
    }

    @Override
    boolean canHandle(char c) {
        return "0123456789".contains(String.valueOf(c));
    }
}
