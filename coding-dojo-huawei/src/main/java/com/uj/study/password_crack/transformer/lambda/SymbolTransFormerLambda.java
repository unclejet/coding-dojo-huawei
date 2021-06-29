package com.uj.study.password_crack.transformer.lambda;

import java.util.function.UnaryOperator;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/29 下午12:19
 * @description：
 */
public class SymbolTransFormerLambda implements UnaryOperator<Character> {
    @Override
    public Character apply(Character character) {
        return character;
    }
}
