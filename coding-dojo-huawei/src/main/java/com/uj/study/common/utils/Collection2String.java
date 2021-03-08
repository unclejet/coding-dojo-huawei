package com.uj.study.common.utils;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/3 下午3:27
 * @description：
 */
public class Collection2String {
    public static String list2String(List<String> list) {
        return list.stream().collect(Collectors.joining(" "));
    }

    public static String list2StringUsingApacheLang(List<String> list) {
        return StringUtils.join(list, " ");
    }

    public static String arrays2StringWithStringBuilder(String[] strArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            stringBuilder.append(strArray[i]).append(" ");
        }
        stringBuilder.delete(stringBuilder.length() - 1 ,stringBuilder.length());
        return stringBuilder.toString();
    }

    public static String arrays2StringWithString(String[] array) {
        return  String.join(" ", array);
    }

    public static String arrays2StringWithStream(String[] array) {
        return  Arrays.stream(array)
                .collect(Collectors.joining(" "));
    }

    public static String arrays2StringWithCommonLang(String[] array) {
        return  StringUtils.join(array, " ");
    }

    public static String arrays2StringWithGuava(String[] array) {
        return  Joiner.on(" ").skipNulls().join(array);
    }

    public static String arraysToString(Object[] arrays) {
        String raw = Arrays.toString(arrays);
        return raw.substring(1, raw.length() - 1).replace(", ", " ");
    }

}
