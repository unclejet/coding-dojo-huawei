package com.uj.study.put_apple;

import com.uj.study.common.SuperMain;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/12/19 下午12:40
 * @description：
 */
public class Main extends SuperMain {
    public static void main(String[] args) {
        PutAppleReader reader = new PutAppleReader(lineReader);
        reader.readAppleAndPlateNumber();
        System.out.println(ApplePutter.possible(reader.getApple(), reader.getPlate()));
    }
}
