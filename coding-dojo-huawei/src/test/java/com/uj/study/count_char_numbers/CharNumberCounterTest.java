package com.uj.study.count_char_numbers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：unclejet
 * @date ：Created in 2020/9/26 上午7:57
 * @description：
 * 输出范围在(0~127)字符的个数。
 * @modified By：
 * @version:
 */
public class CharNumberCounterTest {
    @Test
    void countAscIICharactersMustBeUnique() {
        assertThat(CharNumberCounter.count("abaca"), is(3L));
        assertThat(CharNumberCounter.count("cea432rfw321re3sa"), is(11L));
        assertThat(CharNumberCounter.count("@#&^DDD@#2q3A"), is(9L));
    }
}
