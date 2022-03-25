package com.uj.study.brother_word;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/3/9 下午12:42
 * @description：
 */
public class BrowserWordFinderTest {
    @Test
    void findBrowserWords() {
        assertThat(BrowserWordFinder.find(Arrays.asList("a"), "a"), empty());
        assertThat(BrowserWordFinder.find(Arrays.asList("ab", "a", "ba"), "ab"), contains("ba"));
        assertThat(BrowserWordFinder.find(Arrays.asList("abc", "bca", "cab"), "abc"), contains("bca", "cab"));
    }

    @Test
    void findSpecialBrother() {
        assertThat(BrowserWordFinder.findSpecialBrother(Arrays.asList("abc", "bca", "cab"), "abc", 1), is("2,bca"));
        assertThat(BrowserWordFinder.findSpecialBrother(Arrays.asList("cab", "ad", "abcd", "cba", "abc", "bca"), "abc", 1), is("3,bca"));
    }
}
