package com.uj.study.ip_identity.model;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/5/12 上午11:49
 * @description：
 */
public class Segment {
    private int[] segmentNumbers;

    public Segment(int[] segmentNumbers) {
        this.segmentNumbers = segmentNumbers;
    }

    public int[] getSegment() {
        return segmentNumbers;
    }

    public IntStream getStream() {
        return Arrays.stream(segmentNumbers);
    }
}
