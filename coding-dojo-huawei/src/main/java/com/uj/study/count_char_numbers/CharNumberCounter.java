package com.uj.study.count_char_numbers;

/**
 * @author ：unclejet
 * @date ：Created in 2020/9/26 上午8:12
 * @description：
 * @modified By：
 * @version:
 */
public class CharNumberCounter {
    public static long count(String input) {
        return input.chars().distinct().count();
    }
}
