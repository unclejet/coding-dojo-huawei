package com.uj.study.password_crack.transformer.lambda;

import com.uj.study.password_crack.transformer.old.PwdTransformerOld;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/29 下午12:24
 * @description：
 */
public class UppercaseTransFormerLambda implements UnaryOperator<Character> {
    private static final Pattern UPPER_PATTERN = Pattern.compile("\\p{Upper}");

    @Override
    public Character apply(Character character) {
        return canHandle(character) ?  handle(character) : character;
    }


    private char handle(char c) {
        return c + 33 > 122 ? 'a' : (char) (c + 33);
    }

    private boolean canHandle(char c) {
        return UPPER_PATTERN.matcher(String.valueOf(c)).matches();
    }
}
