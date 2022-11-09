package com.uj.study.string_encrypt;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/8 下午12:31
 * @description：
 */
public class StringEncrypt {
    public static String encrypt(String key, String needEncryptWord) {
        List<String> alphabets = generateAlphabetList();
        List<String> newAlphabets = createEncryptAlphaTable(key);
        Map<String, String> map = IntStream.range(0, alphabets.size()).boxed().collect(Collectors.toMap(i -> alphabets.get(i), i -> newAlphabets.get(i)));
        return Arrays.stream(needEncryptWord.split("")).map(s->translate(s, map)).collect(Collectors.joining());
    }

    static String translate(String s, Map<String, String> map) {
        if (!s.matches("\\p{Alpha}*"))
            return s;
        String lowercase = s.toLowerCase(Locale.ROOT);
        String trans = map.get(lowercase);
        return lowercase.equals(s) ? trans : trans.toUpperCase(Locale.ROOT);
    }

    static List<String> createEncryptAlphaTable(String word) {
        List<String> result = new ArrayList<>(removeDuplicateWord(word));
        List<String> alphabets = generateAlphabetList();
        for (int i = 0; i < 26; i++) {
            if (!result.contains(alphabets.get(i)))
                result.add(alphabets.get(i));
        }
        return result;
    }

    static List<String> generateAlphabetList() {
        List<String> result = new ArrayList<>(26);
        for (int i = 'a'; i <= 'z'; i++) {
            result.add(String.valueOf((char) i));
        }
        return result;
    }

    static List<String> removeDuplicateWord(String word) {
        return Arrays.stream(word.split("")).distinct().collect(Collectors.toList());
    }
}
