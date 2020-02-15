package com.uj.study.approximate.value;

/**
 * @author ：unclejet
 * @date ：Created in 2020/2/15 12:11
 * @description：
 * @modified By：
 * @version:
 */
public final class ApproximateValuer {
    private ApproximateValuer() {
        throw new IllegalCallerException("private ");
    }
    public static int calculate(float v) {
        return Math.round(v);
    }
}
