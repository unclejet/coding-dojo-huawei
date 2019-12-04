package com.uj.study.common.utils;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class RandomAlphabetGeneratorTest {
    @Test
    void comprehensive_test() {
        assertThat(RandomAlphabetGenerator.generateRandomAlphabetByUUIDNoDash(0), is(""));
        assertThat(RandomAlphabetGenerator.generateRandomAlphabetByUUIDNoDash(1).length(), is(1));
        assertThat(RandomAlphabetGenerator.generateRandomAlphabetByUUIDNoDash(31).length(), is(31));
        assertThat(RandomAlphabetGenerator.generateRandomAlphabetByUUIDNoDash(32).length(), is(32));
        assertThat(RandomAlphabetGenerator.generateRandomAlphabetByUUIDNoDash(33).length(), is(33));
    }
}