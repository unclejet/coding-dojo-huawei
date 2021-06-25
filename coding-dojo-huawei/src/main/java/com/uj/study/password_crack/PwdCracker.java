package com.uj.study.password_crack;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/24 上午11:51
 * @description：
 */
public class PwdCracker {
    private static PwdTransformer transformers;
    static {
        transformers = new UppercaseTransFormer(
                new LowercaseTransformer(
                        new NumberTransFormer(
                                new SymbolTransFormer(null)
                        )
                )
        );
    }

    public static String crack(String pwd) {
        IntStream is = pwd.chars().map(c-> transformers.transform((char) c));
        return  is.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}
