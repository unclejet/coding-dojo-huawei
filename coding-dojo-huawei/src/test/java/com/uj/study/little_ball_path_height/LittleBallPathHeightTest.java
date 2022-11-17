package com.uj.study.little_ball_path_height;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/14 下午12:31
 * @description：
 * 描述
 *
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 *
 *
 * 数据范围：输入的小球初始高度满足 1≤n≤1000 1≤n≤1000  ，且保证是一个整数
 * 输入描述：
 *
 * 输入起始高度，int型
 * 输出描述：
 * 分别输出第5次落地时，共经过多少米以及第5次反弹多高。
 * 注意：你可以认为你输出保留六位或以上小数的结果可以通过此题。
 * 示例1
 * 输入：
 *
 * 1
 *
 * 输出：
 *
 * 2.875
 * 0.03125
 */
public class LittleBallPathHeightTest {
    private LittleBallPathHeight lbph;

    @BeforeEach
    void setUp() {
        lbph = new LittleBallPathHeight();
    }

    @Test
    void lastJumpBallHeights() {
        lbph.calculate(1);
        assertThat(lbph.getLastJumpHeights(), is(0.03125));
        assertThat(lbph.getPathLength(), is(2.875));
    }
}