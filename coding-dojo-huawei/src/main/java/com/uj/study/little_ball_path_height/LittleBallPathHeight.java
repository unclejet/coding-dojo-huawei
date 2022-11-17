package com.uj.study.little_ball_path_height;

import java.util.stream.IntStream;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/11/17 下午12:18
 * @description：
 */
public class LittleBallPathHeight {
    private double pathLength;
    private double lastJumpHeights;

    public double getPathLength() {
        return pathLength;
    }

    public double getLastJumpHeights() {
        return lastJumpHeights;
    }

    public void calculate(int initHeight) {
        double[] heights = calBallJumpHeights(initHeight);
        lastJumpHeights = generate6Digit(heights[heights.length - 1]);
        pathLength = generate6Digit(IntStream.range(1, heights.length - 1).mapToDouble(i -> heights[i] * 2).sum() + heights[0]);
    }

    private double generate6Digit(double v) {
        String str = String.format("%.6f",v);
        return Double.parseDouble(str);
    }

    private double[] calBallJumpHeights(int initHeight) {
        int jump = 6;
        double[] results = new double[jump];
        results[0] = initHeight;
        for (int i = 1; i < jump; i++) {
            results[i] = results[i - 1] / 2;
        }
        return results;
    }
}
