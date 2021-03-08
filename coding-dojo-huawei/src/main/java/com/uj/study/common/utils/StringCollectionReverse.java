package com.uj.study.common.utils;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/3 下午3:28
 * @description：
 */
public class StringCollectionReverse {
    public static String[] revertByForLoop(String[] words) {
        String[] revertWords = words.clone();
        for (int i = 0; i < revertWords.length / 2; i++) {
            String temp = revertWords[i];
            revertWords[i] = words[words.length - 1 - i];
            revertWords[words.length - 1 - i] = temp;
        }
        return revertWords;
    }

    public static Object[] invertUsingStreams(Object[] array) {
        return IntStream.rangeClosed(1, array.length)
                .mapToObj(i -> array[array.length - i])
                .toArray();
    }

    public static List<String> invertUsingCollectionsReverse(String[] array) {
        List<String> list = Arrays.asList(array);
        Collections.reverse(list);
        return list;
    }

    public static String[] invertUsingCommonsLang(String[] array) {
        String[] result = array.clone();
        ArrayUtils.reverse(result);
        return result;
    }

    public static List<String> invertUsingGuava(String[] array) {
        List<String> list = Arrays.asList(array);
        return Lists.reverse(list);
    }
}
