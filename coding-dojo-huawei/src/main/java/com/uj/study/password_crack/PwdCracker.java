package com.uj.study.password_crack;

import com.uj.study.password_crack.transformer.lambda.LowercaseTransformerLambda;
import com.uj.study.password_crack.transformer.lambda.NumberTransFormerLambda;
import com.uj.study.password_crack.transformer.lambda.SymbolTransFormerLambda;
import com.uj.study.password_crack.transformer.lambda.UppercaseTransFormerLambda;
import com.uj.study.password_crack.transformer.old.*;

import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/24 上午11:51
 * @description：
 */
public class PwdCracker {
    private static PwdTransformerOld transformers;
    static {
        transformers = new UppercaseTransFormerOld(
                new LowercaseTransformerOld(
                        new NumberTransFormerOld(
                                new SymbolTransFormerOld(null)
                        )
                )
        );
    }

    public static String crack(String pwd) {
        IntStream is = pwd.chars().map(c-> transformers.transform((char) c));
        return  is.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    public static String crackLambda(String pwd) {
        IntStream is = pwd.chars().map(c-> transform((char) c));
        return  is.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    public static char transform(char c) {
        UnaryOperator<Character> number = new NumberTransFormerLambda();
        UnaryOperator<Character> symbol = new SymbolTransFormerLambda();
        UnaryOperator<Character> uppercase = new UppercaseTransFormerLambda();
        UnaryOperator<Character> lowercase = new LowercaseTransformerLambda();
        Function<Character, Character> chain = number.andThen(symbol).andThen(lowercase).andThen(uppercase);
        return chain.apply(c);
    }
}
