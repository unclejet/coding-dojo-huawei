package com.uj.study.password_crack.transformer.old;

import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/22 下午12:21
 * @description：
 */
public class SymbolTransFormerOld extends PwdTransformerOld {
    private static final Pattern ALNUM_PATTERN = Pattern.compile("\\p{Alnum}");

    public SymbolTransFormerOld(PwdTransformerOld nextTransformer) {
        super(nextTransformer);
    }

    @Override
    public char handle(char c) {
        return c;
    }

    @Override
    boolean canHandle(char c) {
        return !ALNUM_PATTERN.matcher(String.valueOf(c)).matches();
    }
}
