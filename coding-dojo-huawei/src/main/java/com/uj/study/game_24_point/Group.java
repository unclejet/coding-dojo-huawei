package com.uj.study.game_24_point;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/31 下午12:50
 * @description：
 */
public class Group {
    private int big;
    private int small;
    private int[] values;

    public Group(int a, int b) {
        big = a >= b ? a : b;
        small = a < b ? a : b;
        values = new int[4];
        calculate();
    }

    private void calculate() {
        values[0] = big + small;
        values[1] = big - small;
        values[2] = big * small;
        values[3] = big / small;
    }

    public int getBig() {
        return big;
    }

    public int getSmall() {
        return small;
    }

    public int[] getValues() {
        return values;
    }
}
