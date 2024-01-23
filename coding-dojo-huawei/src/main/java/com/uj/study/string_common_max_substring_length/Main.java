package com.uj.study.string_common_max_substring_length;

import com.uj.study.common.SuperMain;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/22 下午12:55
 * @description：
 */
public class Main extends SuperMain {
    public static void main(String[] args) {
        MaxCommonSubStringSearcherReader reader = new MaxCommonSubStringSearcherReader(lineReader);
        System.out.println(MaxCommonSubStringSearcher.search(reader.readString(), reader.readString()));
    }
}
