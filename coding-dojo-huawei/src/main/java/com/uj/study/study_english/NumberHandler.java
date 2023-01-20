package com.uj.study.study_english;

import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午8:25
 * @description：
 */
@FunctionalInterface
public interface NumberHandler {
    List<String> handleNumbers(char[] nums);
}
