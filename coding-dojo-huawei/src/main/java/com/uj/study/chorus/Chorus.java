package com.uj.study.chorus;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/10/12 下午12:33
 * @description：
 */
public class Chorus {
    List<Integer> outedInfos;
    private int[] heights;

    public Chorus(int[] heights) {
        this.heights = heights;
    }

    public int outOfQueue() {
        outedInfos = new ArrayList<>();
//        int highest = Arrays.stream(heights).max().getAsInt();
        int hIdx = findMiddleIdx();
        if (!hasLeft(hIdx) && hasRight(hIdx)) {
            for (int i = hIdx + 1; i < heights.length; i++) {
                outedInfos.add(heights[i]);
            }
        } else if (hasLeft(hIdx) && !hasRight(hIdx)) {
            for (int i = 0; i < hIdx; i++) {
                outedInfos.add(heights[i]);
            }
        } else {
            for (int i = 0; i < hIdx; i++) {
                if (needOutLeft(i, hIdx)) {
                    outedInfos.add(heights[i]);
                }
            }
            for (int i = heights.length - 1; i > hIdx; i--) {
                if (needOutRight(i, hIdx)) {
                    outedInfos.add(heights[i]);
                }
            }
        }

        return outedInfos.size();
    }

    private int findMiddleIdx() {
        if (heights.length <= 3) {
            return findHighestIdx();
        }

        int[] candidatesIdx = IntStream.range(1, heights.length - 1).filter(i -> isCandidate(i)).toArray();
        return candidatesIdx.length > 1 ? IntStream.range(0, candidatesIdx.length).reduce((i, j) -> heights[candidatesIdx[i]] > heights[candidatesIdx[j]] ? candidatesIdx[i] : candidatesIdx[j]).getAsInt() : candidatesIdx[0];
    }

    private int findHighestIdx() {
        return IntStream.range(0, heights.length)
                .reduce((i, j) -> heights[i] >= heights[j] ? i : j)
                .getAsInt();
    }

    private boolean isCandidate(int idx) {
        return isLeftSatisfy(idx) && isRightSatisfy(idx);
    }

    private boolean isRightSatisfy(int idx) {
        return IntStream.range(idx + 1, heights.length).anyMatch(i -> heights[i] < heights[idx]);
    }

    private boolean isLeftSatisfy(int idx) {
        return IntStream.range(0, idx).anyMatch(i -> heights[i] < heights[idx]);
    }

    /**
     * 后面有比自己小的，就把自己踢出去
     *
     * @param idx
     * @param hIdx
     * @return
     */
    private boolean needOutLeft(int idx, int hIdx) {
        if (heights[idx] >= heights[hIdx]) {
            return true;
        }
        for (int i = idx; i < hIdx; i++) {
            if (heights[i + 1] < heights[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 前面有比自己小的，就把自己踢出去
     *
     * @param idx
     * @param hIdx
     * @return
     */
    private boolean needOutRight(int idx, int hIdx) {
        if (heights[idx] >= heights[hIdx]) {
            return true;
        }
        for (int i = idx; i > hIdx; i--) {
            if (heights[i - 1] < heights[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean hasRight(int hIdx) {
        return hIdx != heights.length - 1;
    }

    private boolean hasLeft(int highestIdx) {
        return highestIdx != 0;
    }
}
