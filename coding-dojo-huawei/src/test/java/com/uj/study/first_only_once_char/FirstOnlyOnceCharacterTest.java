package com.uj.study.first_only_once_char;

import org.junit.jupiter.api.Test;

import static com.uj.study.first_only_once_char.FirstOnlyOnceCharacterFinder.findFirstAppearedOnceChar;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/26 下午12:51
 * @description：
 * 描述
 * 找出字符串中第一个只出现一次的字符
 *
 *
 * 数据范围：输入的字符串长度满足 1≤n≤1000 1≤n≤1000
 *
 *
 * 输入描述：
 *
 * 输入一个非空字符串
 * 输出描述：
 *
 * 输出第一个只出现一次的字符，如果不存在输出-1
 * 示例1
 * 输入：
 *
 * asdfasdfo
 *
 * 输出：
 *
 * o
 */
public class FirstOnlyOnceCharacterTest {

    @Test
    void only_appear_once_character() {
        assertThat(findFirstAppearedOnceChar("a"), is("a"));
        assertThat(findFirstAppearedOnceChar("ab"), is("a"));
        assertThat(findFirstAppearedOnceChar("aba"), is("b"));
        assertThat(findFirstAppearedOnceChar("asdfasdfo"), is("o"));
        assertThat(findFirstAppearedOnceChar("aabb"), is("-1"));
        assertThat(findFirstAppearedOnceChar("3123"), is("1"));
    }
}
