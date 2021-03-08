package com.uj.study.reverse_number;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/1/26 上午11:58
 * @description：
 */
public class NumberReverse {
    public static String reverse(String numberStr) {
        StringBuilder sb = new StringBuilder(numberStr);
        return sb.reverse().toString();
    }
}
