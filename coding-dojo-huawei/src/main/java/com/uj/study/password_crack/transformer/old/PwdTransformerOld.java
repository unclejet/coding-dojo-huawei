package com.uj.study.password_crack.transformer.old;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/17 下午12:15
 * @description：
 */
public abstract class PwdTransformerOld {
    private PwdTransformerOld nextTransformer;

    public PwdTransformerOld(PwdTransformerOld nextTransformer) {
        this.nextTransformer = nextTransformer;
    }

    public char transform(char c) {
        return !canHandle(c) && nextTransformer != null ?
                nextTransformer.transform(c) : handle(c);
    }

    public abstract char handle(char c);

    abstract boolean canHandle(char c);
}
