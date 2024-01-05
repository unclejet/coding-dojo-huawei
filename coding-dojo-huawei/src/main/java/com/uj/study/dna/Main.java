package com.uj.study.dna;

import com.uj.study.common.SuperMain;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/5 下午12:50
 * @description：
 */
public class Main extends SuperMain {
    public static void main(String[] args) {
        DnaSequenceReader reader = new DnaSequenceReader(lineReader);
        reader.read();
        System.out.println(DnaSequenceCounter.gcRatio(reader.getFirstLine(), reader.getSecondLine()));
    }
}
