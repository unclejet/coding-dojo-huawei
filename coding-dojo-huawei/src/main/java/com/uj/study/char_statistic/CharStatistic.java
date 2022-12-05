package com.uj.study.char_statistic;

import java.util.function.IntPredicate;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/12/5 下午12:22
 * @description：
 */
public class CharStatistic {
    public static long otherCharsCount(String str) {
        return str.chars().filter(is -> !(isNumber().or(isSpace()).or(isEnglish()).test(is))).count();
    }

    public static long numberCount(String str) {
        return str.chars().filter(isNumber()).count();
    }

    private static IntPredicate isNumber() {
        return is -> is >= 48 && is <= 57;
    }

    public static long spaceCount(String str) {
        return str.chars().filter(isSpace()).count();
    }

    private  static IntPredicate isSpace() {
        return is -> is == 32;
    }

    public static long engCount(String str) {
        return str.chars().filter(isEnglish()).count();
    }

    private static IntPredicate isEnglish() {
        return is -> (is >= 65 && is <= 90) || (is >= 97 && is <= 120);
    }
}
