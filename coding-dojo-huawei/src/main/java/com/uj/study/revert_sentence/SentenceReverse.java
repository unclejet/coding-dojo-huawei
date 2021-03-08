package com.uj.study.revert_sentence;

import static com.uj.study.common.utils.Collection2String.arrays2StringWithGuava;
import static com.uj.study.common.utils.StringCollectionReverse.invertUsingCommonsLang;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/3 上午11:28
 * @description：
 */
public class SentenceReverse {
    public static String revert(String input) {
        String[] words = assembleSentenceWords(input);
        String[] revertWords = invertUsingCommonsLang(words);
        return arrays2StringWithGuava(revertWords);
    }

    private static String[] assembleSentenceWords(String sentence) {
        return sentence.split("\\s+");
    }
}
