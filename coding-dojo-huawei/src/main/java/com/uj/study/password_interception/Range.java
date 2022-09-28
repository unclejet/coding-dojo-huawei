package com.uj.study.password_interception;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/9/27 下午12:40
 * @description：
 */
class Range {
    private int start;
    private int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getNextIdx() {
        return start + 1;
    }

    public int getPreviousIdx() {
        return end - 1;
    }

    public int getLength() {
        return end - start + 1;
    }
}
