package com.uj.study.password_crack;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/17 下午12:15
 * @description：
 */
public abstract class PwdTransformer {
    private PwdTransformer nextTransformer;

    public PwdTransformer(PwdTransformer nextTransformer) {
        this.nextTransformer = nextTransformer;
    }

    public char transform(char c) {
        return !canHandle(c) && nextTransformer != null ?
                nextTransformer.transform(c) : handle(c);
    }

    abstract char handle(char c);

    abstract boolean canHandle(char c);
}
