package com.uj.study.char_statistic;

import org.junit.jupiter.api.Test;

import static com.uj.study.char_statistic.CharStatistic.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/12/1 下午12:26
 * @description：
 * 描述
 *
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 *
 * 数据范围：输入的字符串长度满足 1≤n≤1000 1≤n≤1000
 * 输入描述：
 *
 * 输入一行字符串，可以有空格
 * 输出描述：
 *
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 * 示例1
 * 输入：
 *
 * 1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
 *
 * 输出：
 *
 * 26
 * 3
 * 10
 * 12
 */
public class CharStatisticTest {
    @Test
    void englishLettersCount() {
        assertThat(engCount("a"), is(1l));
        assertThat(engCount("ab"), is(2l));
        assertThat(engCount("a b"), is(2l));
    }

    @Test
    void spaceCountTest() {
        assertThat(spaceCount("a"), is(0l));
        assertThat(spaceCount("a b"), is(1l));
        assertThat(spaceCount("a  b "), is(3l));
        assertThat(spaceCount("a    b"), is(4l));
    }

    @Test
    void numberCountTest() {
        assertThat(numberCount("a"), is(0l));
        assertThat(numberCount("a 1"), is(1l));
        assertThat(numberCount("a 1 23"), is(3l));
    }

    @Test
    void otherCharsCountTest() {
        assertThat(otherCharsCount("a"), is(0l));
        assertThat(otherCharsCount("1"), is(0l));
        assertThat(otherCharsCount("1 #"), is(1l));

    }

    @Test
    void mixCountTest() {
        assertThat(engCount("1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\]["), is(24l));
        assertThat(spaceCount("1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\]["), is(3l));
        assertThat(numberCount("1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\]["), is(10l));
        assertThat(otherCharsCount("1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\]["), is(12l));
    }
}
