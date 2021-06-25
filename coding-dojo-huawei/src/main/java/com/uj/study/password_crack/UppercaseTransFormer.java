package com.uj.study.password_crack;

import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/22 下午12:23
 * @description：
 */
public class UppercaseTransFormer extends PwdTransformer {
    private static final Pattern UPPER_PATTERN = Pattern.compile("\\p{Upper}");

    public UppercaseTransFormer(PwdTransformer nextTransformer) {
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
