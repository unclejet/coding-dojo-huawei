package com.uj.study.count_one_in_binary_number;

import com.google.common.base.CharMatcher;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/22 下午12:01
 * @description：
 */
public class Binary1NumberCounter {
    public static final char MATCHED_CHAR = '1';

    public static int count(String binaryNumberStr) {
        return guava(binaryNumberStr);
    }

    private static int simple(String binaryNumberStr) {
        int count = 0;

        for (int i = 0; i < binaryNumberStr.length(); i++) {
            if (binaryNumberStr.charAt(i) == MATCHED_CHAR) {
                count++;
            }
        }
        return count;
    }

    private static int countOccurrences(
            String someString, char searchedChar, int index) {
        if (index >= someString.length()) {
            return 0;
        }

        int count = someString.charAt(index) == searchedChar ? 1 : 0;
        return count + countOccurrences(
                someString, searchedChar, index + 1);
    }

    private static long java8(String someString) {
//        return someString.chars().filter(ch -> ch == MATCHED_CHAR).count();
        return someString.codePoints().filter(ch -> ch == MATCHED_CHAR).count();
    }

    private static int apacheCommonLang3(String someString) {
        return StringUtils.countMatches(someString, MATCHED_CHAR);
    }

    private static int guava(String someString) {
        return CharMatcher.is(MATCHED_CHAR).countIn(someString);
    }

}
