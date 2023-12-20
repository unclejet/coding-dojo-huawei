package com.uj.study.binary_1_count;

import com.uj.study.common.SuperMain;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/12/20 下午12:33
 * @description：
 */
public class Main extends SuperMain {
    public static void main(String[] args) {
        BinaryOneCountReader reader = new BinaryOneCountReader(lineReader);
        System.out.println(BinaryOneCounter.count(BinaryOneCounter.dec2Bin(reader.readNumberStr())));
    }
}
