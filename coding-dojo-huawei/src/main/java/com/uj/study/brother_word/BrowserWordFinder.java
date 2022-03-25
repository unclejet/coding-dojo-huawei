package com.uj.study.brother_word;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/3/9 下午12:42
 * @description：
 */
public class BrowserWordFinder {
    public static String findSpecialBrother(List<String> words, String word, int idx) {
        List<String> sortedBros = find(words, word).stream().sorted().collect(Collectors.toList());
        return sortedBros.size() + "," + sortedBros.get(idx - 1);
    }

    static List<String> find(List<String> words, String word) {
        return words.stream().filter(w->isBrother(w, word)).collect(Collectors.toList());
    }

    private static boolean isBrother(String w, String word) {
        return w.length() == word.length() &&
                !word.equals(w) &&
                allMatch(w, word);
    }

    private static boolean allMatch(String w, String word) {
        char[] letters = w.toCharArray();
        for (char c: letters) {
            if (word.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
}
