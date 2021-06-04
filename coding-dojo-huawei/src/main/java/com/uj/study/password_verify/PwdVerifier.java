package com.uj.study.password_verify;

import javax.print.DocFlavor;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/2 上午11:59
 * @description：
 */
public class PwdVerifier {

    public static final String OK = "OK";
    public static final String NG = "NG";

    public static List<String> verify(List<String> input) {
        return input.stream().map(s -> verify(s)).collect(Collectors.toList());
    }

    private static String verify(String input) {
        Predicate<String> isLengthValid = s -> s.length() > 8;
        Predicate<String> isTypeValid = s -> isValidType(s);
        Predicate<String> isDupRuleValid = s -> isValidDuplicateRule(s);
        return isLengthValid
                .and(isTypeValid)
                .and(isDupRuleValid)
                .test(input) ? OK : NG;
    }

    static boolean isValidType(String input) {
        int count = 0;
        if (input.matches(".*\\p{Upper}.*")) count++;
        if (input.matches(".*\\p{Lower}.*")) count++;
        if (input.matches(".*\\p{Digit}.*")) count++;
        if (input.matches(".*\\p{Punct}.*")) count++;
        return count >= 3;
    }

    static boolean isValidDuplicateRule(String input) {
        for (int i = 0; i < input.length() - 3; i++) {
            String dup = input.substring(i, i + 2);
            String substring = input.substring(i + 2);
            if (substring.contains(dup)) {
                return false;
            }
        }
        return true;
    }
}
