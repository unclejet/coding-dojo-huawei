package com.uj.study.password_crack.transformer.lambda;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/29 下午12:01
 * @description：
 */
@FunctionalInterface
public interface PwdTransformerLambda {
    char transform(char c);
}
