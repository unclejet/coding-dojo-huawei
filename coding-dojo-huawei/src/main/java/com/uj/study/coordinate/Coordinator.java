package com.uj.study.coordinate;

import lombok.Getter;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/3/31 上午11:47
 * @description：
 */
@Getter
public class Coordinator {
    private int direction;
    private int distance;

    public Coordinator(int direction, int distance) {
        this.direction = direction;
        this.distance = distance;
    }
}
