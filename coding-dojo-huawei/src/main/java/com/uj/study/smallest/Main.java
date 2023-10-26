package com.uj.study.smallest;

import com.uj.study.common.SuperMain;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/26 下午12:44
 * @description：
 */
public class Main extends SuperMain {
    public static void main(String[] args) {
        SmallestIntegerKGeneratorReader reader = new SmallestIntegerKGeneratorReader(lineReader);
        reader.read();
        System.out.println(SmallestIntegerKGenerator.format(
                SmallestIntegerKGenerator.smallestNumbers(reader.getArray(), reader.getKNumber())));
    }
}
