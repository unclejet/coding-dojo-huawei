package com.uj.study.little_ball_path_height;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/17 下午12:22
 * @description：
 */
public class Main {

    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        LittleBallPathHeightUserInputReader reader = new LittleBallPathHeightUserInputReader(lineReader);
        LittleBallPathHeight lbph = new LittleBallPathHeight();
        lbph.calculate(reader.readHeight());
        System.out.println(lbph.getPathLength());
        System.out.println(lbph.getLastJumpHeights());
    }
}
