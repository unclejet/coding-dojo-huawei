package com.uj.study.first_only_once_char;

import com.uj.study.common.SuperMain;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/27 下午12:56
 * @description：
 */
public class Main extends SuperMain {
    public static void main(String[] args) {
        FirstOnlyOnceCharacterReader reader = new FirstOnlyOnceCharacterReader(lineReader);
        System.out.println(FirstOnlyOnceCharacterFinder.findFirstAppearedOnceChar(reader.readString()));
    }
}
