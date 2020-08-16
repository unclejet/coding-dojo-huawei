package com.uj.study.extract.nonrepeat.integer;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author ：unclejet
 * @date ：Created in 2020/8/15 上午11:30
 * @description：
 *
 * @modified By：
 * @version:
 */
public class NonRepeatExtractor {
    public int extract(int input) {
        String revertedNumber = revertNumber(input);
        String numArray[] = revertedNumber.split("");
        String joinStr = Arrays.stream(numArray).distinct().collect(Collectors.joining());
        return Integer.parseInt(joinStr);
    }

    private String revertNumber(int input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        return sb.reverse().toString();
    }
}
