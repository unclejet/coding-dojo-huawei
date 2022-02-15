package com.uj.study.sort_string;

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
    void sort() {
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
        assertThat(LineSorter.sort("Type"), is("epTy"));
    }

}