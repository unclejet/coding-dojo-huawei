package com.uj.study.study_english;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午8:40
 * @description：
 */
public class EnglishNumberDict {
    public static final String SPACE = " ";
    public static final String AND = "and";
    public static final String HUNDRED = "hundred";
    public static final String THOUSAND = "thousand";
    public static final String MILLION = "million";
    public static final String BILLION = "billion";

    static Map<String, String> englishDigits;

    static {
        englishDigits = new HashMap<>();
        englishDigits.put("0", "zero");
        englishDigits.put("1", "one");
        englishDigits.put("2", "two");
        englishDigits.put("3", "three");
        englishDigits.put("4", "four");
        englishDigits.put("5", "five");
        englishDigits.put("6", "six");
        englishDigits.put("7", "seven");
        englishDigits.put("8", "eight");
        englishDigits.put("9", "nine");

        englishDigits.put("10", "ten");
        englishDigits.put("11", "eleven");
        englishDigits.put("12", "twelve");
        englishDigits.put("13", "thirteen");
        englishDigits.put("14", "fourteen");
        englishDigits.put("15", "fifteen");
        englishDigits.put("16", "sixteen");
        englishDigits.put("17", "seventeen");
        englishDigits.put("18", "eighteen");
        englishDigits.put("19", "nineteen");
        englishDigits.put("20", "twenty");
        englishDigits.put("30", "thirty");
        englishDigits.put("40", "forty");
        englishDigits.put("50", "fifty");
        englishDigits.put("60", "sixty");
        englishDigits.put("70", "seventy");
        englishDigits.put("80", "eighty");
        englishDigits.put("90", "ninety");

        englishDigits.put(AND, AND);
        englishDigits.put(HUNDRED, HUNDRED);
        englishDigits.put(THOUSAND, THOUSAND);
        englishDigits.put(MILLION, MILLION);
        englishDigits.put(BILLION, BILLION);
    }
}
