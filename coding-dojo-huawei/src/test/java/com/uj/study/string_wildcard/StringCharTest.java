package com.uj.study.string_wildcard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/4/2 下午1:17
 * @description：
 */
public class StringCharTest {
    @Test
    void nothing() {
        String s = "abc";
        Assertions.assertArrayEquals(s.chars().toArray(), new int[]{97, 98, 99});
        Assertions.assertEquals(s.codePointAt(0), 97);
    }
}
