package com.uj.study.password_crack.transformer.old;

import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/22 下午12:23
 * @description：
 */
public class UppercaseTransFormerOld extends PwdTransformerOld {
    private static final Pattern UPPER_PATTERN = Pattern.compile("\\p{Upper}");

    public UppercaseTransFormerOld(PwdTransformerOld nextTransformer) {
        super(nextTransformer);
    }

    @Override
    public char handle(char c) {
        return c + 33 > 122 ? 'a' : (char) (c + 33);
    }

    @Override
    boolean canHandle(char c) {
        return UPPER_PATTERN.matcher(String.valueOf(c)).matches();
    }
}
