package com.uj.study.combine.table.record;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class TableCombinerTest {
    @Test
    void combineTable() {
        List<Pair> pairList = Arrays.asList(new Pair(0, 1), new Pair(0, 2), new Pair(1, 2), new Pair(3, 4));
        List<Pair> combineMap = TableCombiner.combineTable(pairList);

        assertThat(combineMap.size(), is(3));
        assertThat(combineMap.get(0).getValue(), is(3));
        assertThat(combineMap.get(1).getValue(), is(2));
        assertThat(combineMap.get(2).getValue(), is(4));
    }
}