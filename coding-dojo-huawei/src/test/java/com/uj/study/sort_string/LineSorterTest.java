package com.uj.study.sort_string;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/2/14 上午11:41
 * @description：
 */
class LineSorterTest {
    @Test
    void bubbleSort() {
        assertThat(LineSorter.sort(""), is(""));
        assertThat(LineSorter.sort("a"), is("a"));
        assertThat(LineSorter.sort("ab"), is("ab"));
        assertThat(LineSorter.sort("ba"), is("ab"));
        //挑选位置调整1次就完成的优先(挪动是耗能量的)，并且在不同的位置(ba是1,2位置，这里最好在2,3位置进行调整)
        assertThat(LineSorter.sort("abc"), is("abc"));
        assertThat(LineSorter.sort("acb"), is("abc"));
        assertThat(LineSorter.sort("bac"), is("abc"));
        assertThat(LineSorter.sort("bca"), is("abc"));
        assertThat(LineSorter.sort("cba"), is("abc"));
        assertThat(LineSorter.sort("cab"), is("abc"));

    }

    @Test
    void biz() {
        assertThat(LineSorter.sort("Type"), is("epTy"));
        assertThat(LineSorter.sort("BabA"), is("aABb"));
        assertThat(LineSorter.sort("By?e"), is("Be?y"));
        assertThat(LineSorter.sort("A Famous Saying: Much Ado About Nothing (2012/8)."),
                is("A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8)."));
    }

    @Test
    void findNextLetter() {
        assertThat(LineSorter.nextLetter("?Bye".toCharArray(), 0), is(1));
        assertThat(LineSorter.nextLetter("By?e".toCharArray(), 1), is(3));
        assertThat(LineSorter.nextLetter("By?e".toCharArray(), 0), is(1));
        assertThat(LineSorter.nextLetter("Bye?".toCharArray(), 2), is(-1));
        assertThat(LineSorter.nextLetter("Bye? ?c".toCharArray(), 2), is(6));
    }
}