package com.uj.study.game_24_point;

import com.uj.study.common.SuperMain;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/2/4 下午12:45
 * @description：
 */
public class Main extends SuperMain {
    public static void main(String[] args) {
        Game24UserInputReader reader = new Game24UserInputReader(lineReader);
        System.out.println(Game24.has24(reader.readNumber()));
    }
}
