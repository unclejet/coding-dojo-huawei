package com.uj.study.password_crack;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/23 下午12:07
 * @description：
 */
public class PwdTransformerFactory {
    private static PwdTransformerFactory instance = new PwdTransformerFactory();

    public static PwdTransformerFactory getInstance() {
        return instance;
    }

    public PwdTransformer getTransformer(char a) {
        return null;
    }
}
